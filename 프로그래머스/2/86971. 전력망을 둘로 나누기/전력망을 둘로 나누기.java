class Solution {
    
    private static int[][] arr;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        arr = new int[n + 1][n + 1];

        
        // 인접행렬 생성
        for(int[] wire: wires){
            int start = wire[0];
            int end = wire[1];
            arr[start][end] = 1;
            arr[end][start] = 1;
        }
        
        // 하나씩 끊기
        for(int[] wire: wires){
              int start = wire[0];
            int end = wire[1];
            arr[start][end] = 0;
            arr[end][start] = 0;
            
            int tmp = bfs(n, start);
            answer = Math.min(answer, tmp);
            
            // 복구
            arr[start][end] = 1;
            arr[end][start] = 1;
        }
        
        return answer;
    }
    
    private int bfs(int n, int start){
        int[] visited = new int[n+1];
        int[] queue = new int[n]; // 큐를 배열로 직접 구현
        // front: 큐에서 요소를 제거할 위치 (디큐 역할).
        // rear: 큐에서 요소를 추가할 위치 (인큐 역할).
        int front = 0;
        int rear = 0;
        
        int cnt = 1;
        
        queue[rear++] = start;
        visited[start] = 1;
        while(front < rear){
            int point = queue[front++];
            for(int i=1; i<=n; i++){
                if (arr[point][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    queue[rear++] = i;
                    cnt++;
                }
            }
        }
        
        return Math.abs(n-2*cnt);
    }
}