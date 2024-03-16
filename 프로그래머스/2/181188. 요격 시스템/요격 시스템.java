import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (t1, t2) -> t1[1] != t2[1] ? t1[1] - t2[1] : t1[0] - t2[0]);
        
        int answer = 1;
        int boundary = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] >= boundary) {
                boundary = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}