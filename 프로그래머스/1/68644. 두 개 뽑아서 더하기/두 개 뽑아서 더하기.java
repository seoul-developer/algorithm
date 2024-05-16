import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public int[] solution(int[] numbers) {
        final HashSet<Integer> sums = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                sums.add(numbers[i] + numbers[j]);
            }
        }

        final int[] result = sums.stream().mapToInt(it -> it).toArray();
        Arrays.sort(result);
        return result;
    }
}
