import java.util.*;

class Solution {
    public long solution(int k, int d) {

        long answer = 0;
        for(int i = 0; i <= d; i = i + k) {
            answer += 1;
        }
        System.out.println(answer);
        for(int i = k; i <= d; i = i + k) {
            double result = Math.sqrt((long)d*d - (long)i*i);
            answer += ((long) result) / k + 1;
        }
        return answer;
    }
}