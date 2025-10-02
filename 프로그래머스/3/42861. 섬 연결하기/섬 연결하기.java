import java.util.*;

class Solution {
    
    private int[] parents;
    
    public int solution(int n, int[][] costs) {
        // MST 구하기 
        int[][] edges = new int[costs.length * 2][3];
        
        for(int i=0; i<costs.length; i++) {
            edges[i] = costs[i];
        }
        
        for(int i=0; i<costs.length; i++) {
            int[] cost = costs[i];
            edges[i+costs.length] = new int[]{cost[1], cost[0], cost[2]};
        }
        
        Arrays.sort(edges, (a,b) -> (a[2]-b[2]));
        
        int cnt = 0;
        int ans = 0;
        parents = new int[n];
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }
        
        for(int[] cost: edges) {            
            if(cnt == n-1) {
                return ans;
            }
            
            int s = cost[0];
            int d = cost[1];
            int w = cost[2];

            int sp = findParent(s);
            int dp = findParent(d);
            
            if(sp == dp) { 
                continue;
            }
            
            parents[sp] = dp;
            cnt++;
            ans += w;
        }
        
        return ans;
    }
    
    private int findParent(int e) {
        if(parents[e] == e) {
            return e;
        }
        
        int parent = findParent(parents[e]);
        parents[e] = parent;
        
        return parent;
    }
}