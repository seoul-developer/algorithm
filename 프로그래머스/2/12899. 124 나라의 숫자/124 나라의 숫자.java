import java.util.*;

class Solution {
    public String solution(int n) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(0, "4");

        Stack<String> stack = new Stack<>();
        int tmp = n;
        while (tmp != 0) {
            final int 몫 = tmp / 3;
            final int 나머지 = tmp % 3;
            stack.add(map.get(나머지));
            tmp = 몫;
            if(나머지 == 0) tmp--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}