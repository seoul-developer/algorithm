import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[] solution(int[] arr, int[] query) {
        List<Integer> answer = new ArrayList<>(
                Arrays.stream(arr).boxed().collect(Collectors.toList())
        );

        for (int i = 0; i < query.length; i++) {
            final int num = query[i];
            if (i % 2 == 0) {
                answer = answer.subList(0, num + 1);
            } else {
                answer = answer.stream().skip(num).collect(Collectors.toList());
            }
        }

        return answer.stream().mapToInt(it -> it).toArray();
    }
}
