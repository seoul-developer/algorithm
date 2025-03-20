import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<height; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }
        
        for(int i=1; i<height; i++) {
            for(int j=1; j<triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j]+triangle[i][j]);
            }
        }

        return Arrays.stream(dp[height-1]).max().orElse(-1);
    }
}