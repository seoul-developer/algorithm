import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] t = op.split(" ");
            String code = t[0];
            int val = Integer.parseInt(t[1]);

            if ("I".equals(code)) {
                map.put(val, map.getOrDefault(val, 0) + 1);
                continue;
            }

            // D 연산: 비어있으면 무시
            if (map.isEmpty()) continue;

            if ("D".equals(code) && val == 1) {           // 최댓값 삭제
                Map.Entry<Integer, Integer> e = map.lastEntry();
                int key = e.getKey();
                int cnt = e.getValue();
                if (cnt == 1) map.remove(key);
                else map.put(key, cnt - 1);
            } else if ("D".equals(code) && val == -1) {   // 최솟값 삭제
                Map.Entry<Integer, Integer> e = map.firstEntry();
                int key = e.getKey();
                int cnt = e.getValue();
                if (cnt == 1) map.remove(key);
                else map.put(key, cnt - 1);
            }
        }

        if (map.isEmpty()) return new int[]{0, 0};
        return new int[]{ map.lastKey(), map.firstKey() };
    }
}
