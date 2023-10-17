import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashSet;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(number);
        }
        
        final HashSet<Integer> set = new HashSet<>(list);
        if(set.size() == 1 && set.contains(0)) {
            return String.valueOf(0);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                final String v1 = String.valueOf(o1);
                final String v2 = String.valueOf(o2);
                final int c1 = Integer.parseInt(v1 + v2);
                final int c2 = Integer.parseInt(v2 + v1);
                if (c1 < c2) {
                    return 1;
                } else if (c1 > c2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }
}