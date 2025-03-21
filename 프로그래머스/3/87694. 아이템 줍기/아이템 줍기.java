import java.util.*;

class Solution {
    
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        // 테두리 그리기
        for(int[] rec: rectangle) {
            int x1 = rec[0]*2, y1 = rec[1]*2;
            int x2 = rec[2]*2, y2 = rec[3]*2;
            
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    if(i==x1 || i==x2 || j==y1 || j==y2) {
                        if(map[i][j] != 2) {
                            // 테두리 => 1
                            map[i][j]=1;
                        }
                    } else{
                        map[i][j]=2;
                    }
                }
            }
        }
        
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            if(x==itemX && y==itemY) {
                return dist/2;
            }
            
            for(int d=0; d<dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx>=0 && ny>=0 && nx<=100 && ny<=100){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        visited[nx][ny]=true;
                        queue.add(new int[]{nx,ny,dist+1});
                    }
                }
            }
        }
        return 0;
    }
}