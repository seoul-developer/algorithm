import java.util.*;

class Solution {
    int INF = Integer.MAX_VALUE;
    boolean[] visit;
    int[] distance;
    int[][] map;
    
    public int solution(int N, int[][] road, int K) {
        visit = new boolean[N+1]; //방문여부
        distance = new int[N+1]; //최단거리
        map = createMap(N, road); //거리정보
        
        //다익스트라 시작
        for(int i = 1; i <= N; i++) {
            distance[i] = map[1][i];
        }
        visit[1] = true;
        
        for(int i = 0; i < N-2; i++) {
            int current = getSmallIndex();
            visit[current] = true;
            for(int j = 1; j <= N; j++) {
                if(!visit[j] && map[current][j] != INF) {
                    distance[j] = Math.min(distance[current] + map[current][j], distance[j]);
                }
            }
        }
        //다익스트라 끝
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(distance[i] <= K) answer++;
        }
        return answer;
    }
    
    public int[][] createMap(int N, int[][] road) {
        int[][] map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = INF;
            }
        }
        for(int i = 0; i < road.length; i++) {
            int[] tmp = road[i];
            map[tmp[0]][tmp[1]] = Math.min(tmp[2], map[tmp[0]][tmp[1]]);
            map[tmp[1]][tmp[0]] = Math.min(tmp[2], map[tmp[0]][tmp[1]]);
        }
        map[1][1] = 0;
        return map;
    }
    
    public int getSmallIndex() {
        int min = INF;
        int index = -1;
        for(int i = 1; i < distance.length; i++) {
            if(distance[i] < min && !visit[i]){
                min = distance[i];
                index = i;
            }
        }
        return index;
    }
}