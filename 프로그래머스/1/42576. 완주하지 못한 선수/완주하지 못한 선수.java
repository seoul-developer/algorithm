import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {

    public String solution(String[] participant, String[] completion) {
        final HashMap<String, Integer> participants = new HashMap<>();
        for (final String p : participant) {
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }

        for (final String c : completion) {
            participants.put(c, participants.getOrDefault(c, 0) - 1);
        }

        final Iterator<Map.Entry<String, Integer>> it = participants.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry<String, Integer> next = it.next();
            if (next.getValue() >= 1) {
                return next.getKey();
            }
        }

        return "";
    }
}
