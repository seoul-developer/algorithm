import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int[] solution(int[] num_list) {
        final List<Integer> sorted = Arrays.stream(num_list)
                .sorted()
                .mapToObj(it -> it)
                .collect(Collectors.toList());

        final List<Integer> result = sorted.subList(5, sorted.size());

        return result.stream().mapToInt(i -> i).toArray();
    }
}
