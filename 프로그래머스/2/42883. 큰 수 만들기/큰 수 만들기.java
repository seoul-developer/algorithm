import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int tmpIndex = 0;
        int removeCount = 0;
        StringBuilder answer = new StringBuilder(number);
        while(removeCount < k) {
            char tmp = answer.charAt(tmpIndex);
            if(tmpIndex + 1 == answer.length() || tmp < answer.charAt(tmpIndex + 1)) {
                answer = answer.replace(tmpIndex, tmpIndex + 1, "");
                removeCount++;
                tmpIndex--;
                if(tmpIndex < 0) tmpIndex = 0;
                continue;
            }
            
            //아무 변화도 없었다면
            tmpIndex++;
        }
        return answer.toString();
    }
}