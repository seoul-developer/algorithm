import java.util.LinkedList;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        LinkedList<Integer> deleted = new LinkedList<>();

        for (String s : cmd) {
            if (s.equals("C")) {
                deleted.add(k);
                if (k == n - 1) {
                    k--;
                }
                n--;
            } else if (s.equals("Z")) {
                int lastDeleted = deleted.removeLast();
                if (lastDeleted <= k) {
                    k++;
                }
                n++;
            } else if (s.startsWith("U")) {
                int move = Integer.parseInt(s.substring(2));
                k -= move;
            } else if (s.startsWith("D")) {
                int move = Integer.parseInt(s.substring(2));
                k += move;
            }
        }

        StringBuilder result = new StringBuilder("O".repeat(n));

        for(int i = deleted.size() - 1; i >= 0; i--) {
            final int integer = deleted.removeLast();
            result.insert(integer, 'X');
        }

        return result.toString();
    }
}