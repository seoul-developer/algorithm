import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(String[] intStrs, int k, int s, int l) {
        final List<Integer> answer = new ArrayList<>();

        for (final String str : intStrs) {
            final int parsedInt = Integer.parseInt(str.substring(s, s + l));
            if (parsedInt > k) {
                answer.add(parsedInt);
            }
        }

        return answer.stream().mapToInt(it -> it).toArray();
    }
}
