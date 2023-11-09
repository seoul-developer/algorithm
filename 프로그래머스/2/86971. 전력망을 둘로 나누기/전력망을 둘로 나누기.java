import java.util.HashSet;
import java.util.Set;

class Solution {
    public static boolean[] visited;
    public static int count = 1;
    public static Set<Integer> set = new HashSet<>();
    public static int length;
    public static int all;

    public int solution(int n, int[][] wires) {
        length = wires.length;
        visited = new boolean[length];
        all = n;

        for (int i = 0; i < length; i++) {
            int tmpA = wires[i][0];
            int tmpB = wires[i][1];
            wires[i][0] = 0;
            wires[i][1] = 0;
            visited[i] = true;
            func(tmpA, wires, true);
            visited[i] = false;
            wires[i][0] = tmpA;
            wires[i][1] = tmpB;
        }
        return set.stream().mapToInt(each -> each).min().getAsInt();
    }

    public void func(int a, int[][] wires, boolean isStart) {
        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            if (wires[i][0] == a) {
                count++;
                visited[i] = true;
                func(wires[i][1], wires, false);
                visited[i] = false;
            } else if (wires[i][1] == a) {
                count++;
                visited[i] = true;
                func(wires[i][0], wires, false);
                visited[i] = false;
            }
        }
        if (isStart) {
            set.add(Math.abs(all - count * 2));
            count = 1;
        }
    }
}