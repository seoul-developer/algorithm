import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // O(E) -> 최대 5만
        for(int[] e: edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // BFS
        int[] path = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0}); // idx, dist
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int idx = curr[0];
            int dist = curr[1];
            
            if(visited[idx]) {
                continue;
            }
            
            visited[idx] = true;
            path[idx] = dist;
            
            for(int next: graph.get(idx)) {
                if(!visited[next]) {
                    queue.offer(new int[]{next, dist+1});
                }
            }
        }
        
        int max = 0;
        for(int p: path) {
            max = Math.max(max, p);
        }
        System.out.println(max);

        int cnt = 0;
        for(int p: path) {
            if(max == p) {
                cnt++;
            }
        }
        
        return cnt;
    }
}