import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a1, a2) -> a1[2] - a2[2]);
        
        Set<Integer> set = new HashSet<>();
        set.add(costs[0][0]);
        int answer = 0;
        
        while(set.size() < n) {
            for(int i = 0; i < costs.length; i++) {
                if((set.contains(costs[i][0]) && !set.contains(costs[i][1]))
                  || !set.contains(costs[i][0]) && set.contains(costs[i][1])){
                    set.add(costs[i][0]);
                    set.add(costs[i][1]);
                    answer += costs[i][2];
                    break;
                }
            }
        }
        return answer;
    }
}