import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);
    
        int answer = 1;
        int camera = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
            if(camera < routes[i][0]) {
                answer ++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
    
    //-20 -15 / -18 -17 / -16 -15 
    //-18-17 / -20-15 / -16-15
}