import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a1, a2) -> a1[2] - a2[2]);
        
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        //Set<Integer> set = new HashSet<>();
        
        int answer = 0;
        int lineCount = 0;
        for(int i = 0; i < costs.length; i++) {
            int[] tmp = costs[i];
            if(getRoot(tmp[0]) != getRoot(tmp[1])) {//부모가 같지 않다면(사이클이 아니라면)
                answer += tmp[2];
                unionParent(tmp[0], tmp[1]);//부모를 같게 갱신
                //set.add(tmp[0]);
                //set.add(tmp[1]);
                lineCount++;
            }
            if(lineCount == n-1) {
                return answer;
            }
        }
        
        return -1;
    }
    
    public void unionParent(int v1, int v2) {
        parent[v1] = getRoot(v1);
        parent[v2] = getRoot(v2);
        if(parent[v1] > parent[v2]) {
            parent[parent[v1]] = parent[v2];
        } else {
            parent[parent[v2]] = parent[v1];
        }       
    }
    
    public int getRoot(int v) {
        if(parent[v] == v) return v;
        return getRoot(parent[v]);
    }
}