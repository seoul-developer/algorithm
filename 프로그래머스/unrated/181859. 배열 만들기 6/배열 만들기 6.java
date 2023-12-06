import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int[] arr) {
        final List<Integer> stk = new ArrayList<>();

        int i = 0;
        while (i < arr.length) {
            final int size = stk.size();
            final int element = arr[i];

            if (stk.isEmpty()) {
                stk.add(element);
                i++;
                continue;
            }

            final Integer last = stk.get(size - 1);
            if (last == element) {
                stk.remove(size - 1);
                i++;
            }
            if (last != element) {
                stk.add(element);
                i++;
            }
        }

        if (stk.isEmpty()) {
            return new int[]{-1};
        }

        return stk.stream().mapToInt(it -> it).toArray();
    }
}
