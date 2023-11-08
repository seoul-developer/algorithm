
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited;
    public static String[] split;
    public static int max = 0;

    public int solution(String numbers) {
        split = numbers.split("");
        final int length = split.length;
        visited = new boolean[length];

        for (int i = 1; i <= length; i++) {
            StringBuilder sb = new StringBuilder();
            pick(i, sb);
        }

        set.remove(1);
        set.remove(0);
        for(int k = 2; k <= Math.sqrt(max); k++) {
            for (int j = 2; j * k <= max; j++) {
                final Integer now = k * j;
                set.remove(now);
            }
        }
        return set.size();
    }

    private void pick(int i, final StringBuilder sb) {
        if (i == 0) {
            final int n = Integer.parseInt(sb.toString());
            set.add(n);
            if (max < n) {
                max = n;
            }
            return;
        }
        for (int k = 0; k < visited.length; k++) {
            if (visited[k]) {
                continue;
            }
            visited[k] = true;
            StringBuilder tmp = new StringBuilder(sb);
            pick(i - 1, tmp.append(split[k]));
            visited[k] = false;
        }
    }
}