import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int l, int r) {
        final List<Integer> answer = new ArrayList<>();
        for (int num = l; num < r + 1; num++) {
            final String original = String.valueOf(num);
            final String replaced = original
                    .replace("5", "")
                    .replace("0", "");

            if (replaced.isEmpty()) {
                answer.add(Integer.valueOf(original));
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        return answer.stream().mapToInt(it -> it).toArray();
    }
}