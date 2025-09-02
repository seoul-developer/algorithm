class Solution {
    
    private int CONST = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] map = new boolean[n+1][m+1];
        int[][] nums = new int[n+1][m+1];
        
        for(int[] puddle: puddles) {
            map[puddle[1]][puddle[0]] = true;
        }
        
        nums[1][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(map[i][j] == true) {
                    nums[i][j] = 0;
                    continue;
                }
                if(i==1 && j==1) {
                    continue;
                }
                int val = nums[i-1][j] + nums[i][j-1];
                if(val >= CONST) {
                    val %= CONST;
                }
                nums[i][j] = val;
            }
        }
        
        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=m; j++) {
        //         System.out.print(nums[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return nums[n][m];
    }
}