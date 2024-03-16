import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long partCount = 0;
        long lineCount = r2 - r1 + 1;
        
        for(long x = 1; x < r2; x++) {
            long high = (long) Math.sqrt((long)r2*r2 - x*x);
            long low = 1;
            if(x < r1) {
                low = (long) Math.sqrt((long)r1*r1 - x*x);
                if(Math.sqrt(low*low + x*x) < r1) low++;
            }
            long tmp = high - low + 1;
            //System.out.println("high = " + high + ", low = "+ low);
            //System.out.println(tmp);
            partCount = partCount + tmp;
        }

        return 4 * partCount + 4 * lineCount;
    }
}