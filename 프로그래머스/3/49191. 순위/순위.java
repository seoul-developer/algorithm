import java.util.*;

class Solution {
    
    int n;
    
    public int solution(int n, int[][] results) {
        this.n = n;
        
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        
        for(int[] result: results) {
            int a = result[0];
            int b = result[1];
            
            graph.get(a).add(b);
            rev.get(b).add(a);
        }
        
        int answer = 0;

        for(int i=1; i<=n; i++) {
            int cnt = count(i, graph);
            int revCnt = count(i, rev);
            
            // System.out.printf("i: %d, cnt: %d, rev: %d%n", i, cnt, revCnt);
            
            if(cnt+revCnt+1 == n) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int count(int idx, List<List<Integer>> graph) {
        int cnt = -1;
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if(visited[curr]) {
                continue;
            }
            
            visited[curr] = true;
            cnt++;
            
            for(int next: graph.get(curr)) {
                if(!visited[next]) {
                    queue.offer(next);
                }
            }
        }
        
        return cnt;
    }
}