import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++) {
            char[][] place = new char[5][5];
            for(int k = 0; k < 5; k++) {
                final String row = places[i][k];
                place[k] = row.toCharArray();
            }
            answer[i] = bfs(place);
        }
        return answer;
    }

    private int bfs(final char[][] place) {
        Queue<List<Integer>> q = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];

        q.add(List.of(0, 0));

        while(!q.isEmpty()) {
            final List<Integer> poll = q.poll();
            final int a = poll.get(0);
            final int b = poll.get(1);
            if (a >= 5 || b >= 5) {
                continue;
            }
            if(visit[a][b]){
                continue;
            }
            final char mark = place[a][b];
            visit[a][b] = true;
            System.out.println("{" + a + "," + b+ "}");
            if (mark == 'P') {
                if (a+1 < 5 && place[a + 1][b] == 'P')
                    return 0;
                if (b+1 < 5 && place[a][b + 1] == 'P')
                    return 0;
                if (a+2 < 5 && place[a + 2][b] == 'P' && place[a + 1][b] != 'X')
                    return 0;
                if (b+2 < 5 && place[a][b + 2] == 'P' && place[a][b + 1] != 'X')
                    return 0;
                if (a+1 < 5 && b+1 < 5 && place[a + 1][b + 1] == 'P' && !(place[a + 1][b] == 'X' && place[a][b + 1] == 'X'))
                    return 0;
                if (a-1 >= 0 && b+1 < 5 && place[a - 1][b + 1] == 'P' && !(place[a - 1][b] == 'X' && place[a][b + 1] == 'X'))
                    return 0;
                if (a+1 < 5 && b-1 >= 0 && place[a + 1][b - 1] == 'P' && !(place[a + 1][b] == 'X' && place[a][b - 1] == 'X'))
                    return 0;
                if (a-1 >= 0 && b-1 >= 0 && place[a - 1][b - 1] == 'P' && !(place[a - 1][b] == 'X' && place[a][b - 1] == 'X'))
                    return 0;
                if (a-1 >= 0 && place[a - 1][b] == 'P')
                    return 0;
                if (b-1 >= 0 && place[a][b - 1] == 'p')
                    return 0;
                if (a-2 >= 0 && place[a - 2][b] == 'P' && place[a - 1][b] != 'X')
                    return 0;
                if (b-2 >= 0 && place[a][b - 2] == 'P' && place[a][b - 1] != 'X')
                    return 0;

            }
            q.add(List.of(a+1, b));
            q.add(List.of(a, b+1));
        }
        return 1;
    }
}