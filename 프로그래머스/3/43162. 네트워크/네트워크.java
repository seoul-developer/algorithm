class Solution {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int count = 0;

    public int solution(int n, int[][] computers) {
        graph = computers;
        visited = new boolean[n][n];

        int answer = 0;
        for(int i = 0; i < n; i++) {
            func(i, n);
            if(count != 0) {
                answer++;
                count = 0;
            }
        }

        return answer;
    }

    public void func(int i, int n) {
        for(int k = 0; k < n; k++) {
            if((!visited[i][k] && graph[i][k] == 1) || (!visited[k][i] && graph[k][i] == 1)) {
                visited[i][k] = true;
                visited[k][i] = true;
                count++;
                func(k, n);
            }
        }
    }
}