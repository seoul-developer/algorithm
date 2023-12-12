import java.util.*;

class Solution {
    int[][] map;
    boolean[][] visit;
    List<Integer> result = new ArrayList<>();

    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            final String line = maps[i];
            for(int j = 0; j < line.length(); j++) {
                if(line.charAt(j) == 'X') {
                    map[i][j] = 0;
                    visit[i][j] = true;
                }else{
                    map[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
        }

        for(int i = 0; i < visit.length; i++) {
            for(int j = 0; j < visit[i].length; j++) {
                if(!visit[i][j]) {
                    result.add(dfs(List.of(i, j)));
                }
            }
        }

        if(result.isEmpty()) {
            result.add(-1);
        }

        int[] answer = result.stream().mapToInt(each -> each).toArray();
        Arrays.sort(answer);
        return answer;
    }

    private int dfs(List<Integer> start) {
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(start);
        int day = 0;
        while(!stack.isEmpty()) {
            final List<Integer> pop = stack.pop();
            final Integer a = pop.get(0);
            final Integer b = pop.get(1);
            if(visit[a][b]) {
                continue;
            }
            visit[a][b] = true;
            if(map[a][b] == 0) {
                continue;
            }
            day += map[a][b];
            if(a+1 < map.length && !visit[a+1][b]) stack.push(List.of(a+1, b));
            if(a-1 >= 0 && !visit[a-1][b]) stack.push(List.of(a-1, b));
            if(b+1 < map[0].length && !visit[a][b+1]) stack.push(List.of(a, b+1));
            if(b-1 >= 0 && !visit[a][b-1]) stack.push(List.of(a, b-1));
        }
        return day;
    }
}