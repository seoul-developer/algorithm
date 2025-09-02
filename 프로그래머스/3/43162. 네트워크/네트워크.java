import java.util.*;

class Solution {
    
    private int[] groups;
    
    public int solution(int n, int[][] computers) {
        groups = new int[n];
        for(int i=0; i<n; i++) {
            groups[i] = i;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                boolean connected = computers[i][j] == 1;
                
                if(connected) {
                    // connect
                    int par1 = findParent(i);
                    int par2 = findParent(j);

                    if(par1 != par2) {
                        groups[par1] = par2;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            groups[i] = findParent(groups[i]);
        }
        
        Set<Integer> cnt = new HashSet<>();
        for(int group: groups) {
            cnt.add(group);
        }
        
        return cnt.size();
    }
    
    private int findParent(int com) {
        if(groups[com] == com) {
            return com;
        }
        
        int parent = findParent(groups[com]);
        groups[com] = parent;
        
        return parent;
    }
}