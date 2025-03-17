import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {

    public int solution(String begin, String target, String[] words) {
        char[] end = target.toCharArray();
        final LinkedList<ArrayList<String>> queue = new LinkedList<>();
        final ArrayList<String> first = new ArrayList<>();
        first.add(begin); // 글자
        first.add(String.valueOf(0)); // 단계
        queue.offer(first);

        Set<String> visited = new HashSet<>();
        visited.add(begin);

        while (!queue.isEmpty()) {
            final ArrayList<String> poll = queue.poll();

            char[] tmp = poll.get(0).toCharArray();
            int cnt = Integer.parseInt(poll.get(1));

            if (poll.get(0).equals(target)) {
                return cnt;
            }

            for (final String word : words) {
                boolean changeable = calculateDiff(tmp, word.toCharArray()) == 1;

                if (!visited.contains(word) && changeable) {
                    ArrayList<String> next = new ArrayList<>();
                    next.add(word);
                    next.add(String.valueOf(cnt + 1));
                    queue.offer(next);
                    visited.add(word);
                }
            }
        }

        return 0;
    }

    private int calculateDiff(final char[] start, final char[] end) {
        int diff = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] != end[i]) {
                diff++;
            }
        }
        return diff;
    }
}
