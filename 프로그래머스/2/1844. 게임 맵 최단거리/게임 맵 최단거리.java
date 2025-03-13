import java.util.*;

class Solution {
    private int ans = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
        
            if (x == n-1 && y == m-1){
                return distance;
            }
            
            for (int[] dir: directions){
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1){
                queue.offer(new int[]{nx, ny, distance + 1});
                maps[nx][ny] = 0; // 방문 처리 (벽으로 변경)
                }
            }
        }
        return -1;
    }
}