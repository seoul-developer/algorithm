import java.util.*;

class Solution {
    int[][] map;
    public int solution(int n, int[][] results) {
        createMap(n, results);
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int lowerRank = reverseDfs(i);
            int higherRank = dfs(i);
            if(higherRank + lowerRank == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    
    public void createMap(int n, int[][] results) {
        map = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++) {
            int[] current = results[i];
            map[current[0]][current[1]] = 1;
        }
    }
    
    public int dfs(int i) {
        Set<Integer> visit = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            if(visit.contains(pop)) {
                continue;
            }
            visit.add(pop);
            
            for(int k = 1; k < map[0].length; k++) {
                if(map[k][pop] == 1) stack.push(k);
            }
        }
        return visit.size()-1;
    }
    
    public int reverseDfs(int i) {
        Set<Integer> visit = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            if(visit.contains(pop)) {
                continue;
            }
            visit.add(pop);
            
            for(int k = 1; k < map[0].length; k++) {
                if(map[pop][k] == 1) stack.push(k);
            }
        }
        return visit.size()-1;
    }
}