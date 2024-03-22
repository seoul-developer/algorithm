import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int wLength = 2 * w + 1;
        
        int firstStation = stations[0];
        int okStart = firstStation - w;
        if(okStart > 1) {
            answer += okStart / wLength;
            if(okStart % wLength != 0) answer += 1;
        }
        int okEnd = firstStation + w;
        for(int i = 1; i < stations.length; i++) {
            int currentStation = stations[i];
            okStart = currentStation - w;
            if(okEnd + 1 < okStart) {
                int noWSize = okStart - okEnd - 1;
                answer += noWSize / wLength;
                if(noWSize % wLength != 0) answer += 1;
            }
            okEnd = currentStation + w;
        }
        if(okEnd < n) {
            int noWSize = n - okEnd;
            answer += noWSize / wLength;
            if(noWSize % wLength != 0) answer += 1;
        }
        return answer;
    }
}