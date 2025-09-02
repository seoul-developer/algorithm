import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // BFS (현재 단어, 지나온 단어 visited, 지나온 스텝 수)
        Queue<Bfs> queue = new LinkedList<>();
        queue.offer(new Bfs(begin, new boolean[words.length], 0));
        
        while (!queue.isEmpty()) {
            Bfs curr = queue.poll();
            
            String word = curr.word;
            if(word.equals(target)) {
                return curr.steps;
            }
            
            boolean[] visited = curr.visited;
            
            for(int i=0; i<words.length; i++) {
                String next = words[i];
                if(visited[i] == false && changeable(word, next)) {
                    // System.out.printf("curr: %s, next: %s, step: %d%n", word, next, curr.steps);
                    boolean[] newVisited = visited.clone();
                    newVisited[i] = true;
                    queue.offer(new Bfs(next, newVisited, curr.steps + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean changeable(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        
        int diffCnt = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i] != b[i]) {
                diffCnt++;
            }
        }
        
        return diffCnt == 1;
    }
}

class Bfs {
    // (현재 단어, 지나온 단어 visited, 지나온 스텝 수)
    String word;
    boolean[] visited;
    int steps;
    
    public Bfs(String word, boolean[] visited, int steps) {
        this.word = word;
        this.visited = visited;
        this.steps = steps;
    }
}