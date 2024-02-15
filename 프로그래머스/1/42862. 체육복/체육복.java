import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n+1];
        boolean[] hasReserve = new boolean[n+1];
        for(int i = 0; i < lost.length; i++) {
            isLost[lost[i]] = true;
        }
        for(int i = 0; i < reserve.length; i++) {
            hasReserve[reserve[i]] = true;
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(isLost[i]) {
                if(hasReserve[i]){
                    hasReserve[i] = false;
                    answer++;
                } else if(i-1 >= 1 && hasReserve[i-1]) {
                    hasReserve[i-1] = false;
                    answer++;
                } else if(i+1 <= n && hasReserve[i+1] && !isLost[i+1]) {
                    hasReserve[i+1] = false;
                    answer++;
                }
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}