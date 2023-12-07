import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] result = solution.solution(new int[]{0, 1, 1, 1, 1}, 4);
        Arrays.stream(result).forEach(it -> System.out.println(it));
    }

    public int[] solution(int[] arr, int k) {
        final List<Integer> answer = new ArrayList<>();
        int i = 0;
        for (final int num : arr) {
            if (i < k && !answer.contains(num)) {
                answer.add(num);
                i++;
            }
        }

        if (answer.size() == k) {
            return answer.stream().mapToInt(it -> it).toArray();
        }

        final int gap = k - answer.size();
        for (int j = 0; j < gap; j++) {
            answer.add(-1);
        }
        return answer.stream().mapToInt(it -> it).toArray();
    }
}
