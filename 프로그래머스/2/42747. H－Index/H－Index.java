import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // n=5 편 중 h=3편 이상 인용된 논문이 3편이고 나머지는 3번 이상 인용됨
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for (int i=0; i<n; i++){
            int h = n-i; // 5-0 -> 4 
            if(citations[i]>=h){ // citations[0] >= 5 -> citations[1] >= 4 
                return h;
            }
        }
        
        return 0;
    }
}