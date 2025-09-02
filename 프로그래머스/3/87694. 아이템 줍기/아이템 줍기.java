import java.util.*;

class Solution {
    
    int[][] direction = new int[][]{ {-1,0}, {1,0}, {0,1}, {0,-1} };
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int MAX = 50 * 2;
        boolean[][] map = new boolean[MAX + 1][MAX + 1];
        
        // 모든 부분 채우기
        for(int[] r: rectangle) {
            int recX1 = r[0] * 2;
            int recY1 = r[1] * 2;
            int recX2 = r[2] * 2;
            int recY2 = r[3] * 2;
            
            // System.out.printf("x: (%d ~ %d), y: (%d ~ %d)%n", recX1, recX2, recY1, recY2);
            for(int y=recY1; y<=recY2; y++) {
                    for(int x=recX1; x<=recX2; x++) {
                    map[y][x] = true;
                }
            }
        }
        
        // 내부 비우기
        for(int[] r: rectangle) {
            int recX1 = r[0] * 2;
            int recY1 = r[1] * 2;
            int recX2 = r[2] * 2;
            int recY2 = r[3] * 2;
            
            // System.out.printf("x: (%d ~ %d), y: (%d ~ %d)%n", recX1, recX2, recY1, recY2);
            for(int y=recY1 + 1; y<recY2; y++) {
                    for(int x=recX1 + 1; x<recX2; x++) {
                    map[y][x] = false;
                }
            }
        }
        
        // bfs (chX, chY, dist, visited)
        Queue<Bfs> queue = new LinkedList<>();
        queue.offer(new Bfs(characterX * 2, characterY * 2, 0));
        boolean[][] visited = new boolean[MAX + 1][MAX + 1];
        visited[characterY*2][characterX*2] = true;

        while (!queue.isEmpty()) {
            Bfs curr = queue.poll();
            
            int x = curr.chX;
            int y = curr.chY;
            int dist = curr.dist;
            
            if(map[y][x] == false) {
                continue;
            }
            
            if(x==itemX*2 && y == itemY*2) {
                return dist / 2;
            }
            
            for(int[] dir: direction) {
                int dx = dir[0];
                int dy = dir[1];
                
                int newX = x+dx;
                int newY = y+dy;
                
                if(newX < 0 || newX >= MAX+1 || newY <0 || newY >=MAX+1) {
                    continue;
                }
                
                if(visited[newY][newX]) {
                    continue;
                }
                
                visited[newY][newX] = true;
                queue.offer(new Bfs(newX, newY, dist+1));
            }
        }

        return 0;
    }
}

class Bfs {
    int chX; 
    int chY; 
    int dist; 
    
    public Bfs (int chX, int chY, int dist) {
        this.chX = chX;
        this.chY = chY;
        this.dist = dist;
    }
}