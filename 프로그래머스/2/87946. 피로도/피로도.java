import java.util.*;

class Solution {
    int cnt = 0;
    public int solution(int k, int[][] dungeons) {
        // k: 현재 피로도
        int hp = k;
        boolean[] visited = new boolean[dungeons.length];
        dfs(hp, dungeons, visited, 0);
        return cnt;
    }
    
    private void dfs(int hp, int[][] dungeons, boolean[] visited, int count) {
        cnt = Math.max(cnt,count);
        
        for(int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(!visited[i] && hp>=need){
                visited[i]=true;
                dfs(hp-cost,dungeons,visited,count+1);
                visited[i]=false;
            }
        }
    }
}