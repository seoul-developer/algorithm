import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        Map<Integer, Integer> scoreOfChoice = new HashMap();
        scoreOfChoice.put(1, -3);
        scoreOfChoice.put(2, -2);
        scoreOfChoice.put(3, -1);
        scoreOfChoice.put(4, 0);
        scoreOfChoice.put(5, 1);
        scoreOfChoice.put(6, 2);
        scoreOfChoice.put(7, 3);

        for(int i = 0; i < choices.length; i++) {
            final Integer score = scoreOfChoice.get(choices[i]);
            if(score < 0) {
                final String s = String.valueOf(survey[i].charAt(0));
                map.put(s, map.get(s) + Math.abs(score));
            }else if(score > 0) {
                final String s = String.valueOf(survey[i].charAt(1));
                map.put(s, map.get(s) + score);
            }
        }

        String answer = "";
        final Integer r = map.get("R");
        final Integer t = map.get("T");
        if(r < t) {
            answer += "T";
        }else{
            answer += "R";
        }

        final Integer c = map.get("C");
        final Integer f = map.get("F");
        if(c < f) {
            answer += "F";
        }else{
            answer += "C";
        }

        final Integer j = map.get("J");
        final Integer m = map.get("M");
        if(j < m) {
            answer += "M";
        }else{
            answer += "J";
        }

        final Integer a = map.get("A");
        final Integer n = map.get("N");
        if(a < n) {
            answer += "N";
        }else{
            answer += "A";
        }
        return answer;
    }
}