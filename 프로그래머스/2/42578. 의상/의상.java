import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cnts = new HashMap<>();
        for(String[] cloth: clothes){
            String a = cloth[0]; // 구체
            String b = cloth[1]; // 종류
            
            cnts.put(b, cnts.getOrDefault(b,0)+1);
        }
        
        int answer = 1;
        for(String key: cnts.keySet()){
            answer = answer * (cnts.get(key)+1);
        }
        
        return answer-1;
    }
}