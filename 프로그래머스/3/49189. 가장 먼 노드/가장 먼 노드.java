import java.util.*; 

class Solution {
    public int solution(int n, int[][] edge) {
        // int[][] vs = new int[n+1][n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int[] e = edge[i];
            int a = e[0];
            int b = e[1];
            
            // vs[v1][v2] = 1;
            // vs[v2][v1] = 1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // for(int i=1; i<edge.length; i++){
        //     int[] v = vs[i];
        //     System.out.println(Arrays.toString(v));
        // }
        
        
        // 거리 
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            for(int next: graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        
        System.out.println(Arrays.toString(distance));
        int max = Arrays.stream(distance).max().orElse(0);
        return (int) Arrays.stream(distance).filter(i->i==max).count();
    }
}