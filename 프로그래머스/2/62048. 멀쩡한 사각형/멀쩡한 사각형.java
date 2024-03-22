import java.util.*;

class Solution {
    public long solution(int w, int h) {
        // y = h/w
        
        //double slide = (double)h/w;
        long answer = 0;
        for(long i = 0; i <= w-1; i++) {
            long high = (long)Math.ceil((double)h*(i+1)/w);
            long low = (long)Math.floor((double)h * i/w);
            answer += h - (high - low);
        }
        
        return answer;
    }
}