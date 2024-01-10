import java.util.HashMap;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        final HashMap<String, Integer> keys = new HashMap<>();

        for (final String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                final String k = String.valueOf(key.charAt(i));
                keys.put(k, Integer.min(keys.getOrDefault(k, 10000), i + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            final String target = targets[i];
            int totalNum = 0;
            for (int j = 0; j < target.length(); j++) {
                final String s = String.valueOf(target.charAt(j));
                final int currentNum = keys.getOrDefault(s, -1);
                if (currentNum == -1) {
                    totalNum = -1;
                    break;
                }
                totalNum += currentNum;
            }
            answer[i] = totalNum;
        }

        return answer;
    }
}