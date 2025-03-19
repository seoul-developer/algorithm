class Solution {
    private int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private void dfs(int start, int[][] computers, boolean[] visited){
        visited[start] = true;
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]) {
                if(computers[start][i] == 1 && !visited[i]) {
                    dfs(i, computers,visited);
                }
            }
        }
    }
}