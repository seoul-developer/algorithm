import java.util.*;

class Solution {
    int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int[][] memo = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                memo[i][j] = INF;
            }
        }
        memo[1][1] = 0;
        for(int i = 0; i < road.length; i++) {
            int[] tmp = road[i];
            if(tmp[0] == 1) memo[1][tmp[1]] = Math.min(memo[1][tmp[1]], tmp[2]);
            else if(tmp[1] == 1) memo[1][tmp[0]] = Math.min(memo[1][tmp[0]], tmp[2]);
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        visited.add(1);
        result.add(0);
        int index = 1;
        int current = getNextMin(visited, memo[index]);
        result.add(memo[index][current]);

        while(visited.size() < N) {
            visited.add(current);
            if(visited.size() == N) {
                break;
            }
            memo[index+1][current] = memo[index][current];
            for(int i = 1; i <= N; i++) {
                if(visited.contains(i)) continue;
                if(memo[index][i] != INF) memo[index+1][i] = memo[index][i];
            }
            index++;
            for(int i = 0; i < road.length; i++) {
                int[] tmp = road[i];
                if(tmp[0] == current && !visited.contains(tmp[1])) memo[index][tmp[1]] = Math.min(
                        memo[index][tmp[1]],
                        memo[index][current] + tmp[2]
                );
                else if(tmp[1] == current && !visited.contains(tmp[0])) memo[index][tmp[0]] = Math.min(
                        memo[index][tmp[0]],
                        memo[index][current] + tmp[2]
                );
            }
            current = getNextMin(visited, memo[index]);
            result.add(memo[index][current]);
        }

        int answer = 0;
        for(int i = 0; i < result.size(); i++) {
            if(result.get(i) <= K) answer++;
        }
        return answer;
    }

    public int getNextMin(Set<Integer> visited, int[] lengths) {
        int min = Integer.MAX_VALUE;
        int next = -1;
        for(int i = 1; i < lengths.length; i++) {
            if(visited.contains(i)) continue;
            if(lengths[i] < min){
                next = i;
                min = lengths[i];
            }
        }
        return next;
    }
}