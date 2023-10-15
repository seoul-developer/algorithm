import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> finishRunners = new HashMap<>();
        for (String runner : completion) {
            finishRunners.put(runner, finishRunners.getOrDefault(runner, 0) + 1);
        }
        String answer = "";
        for (String runner : participant) {
            final Integer n = finishRunners.getOrDefault(runner, 0);
            if(n == 0) {
                answer = runner;
                break;
            }
            finishRunners.put(runner, n-1);
        }
        return answer;
    }
}