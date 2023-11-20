class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] ways = new long[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++) {
            isPuddle[puddles[i][1]][puddles[i][0]] = true;
        }

        ways[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                if(isPuddle[i][j]) {
                    continue;
                }
                ways[i][j] = (ways[i-1][j] +  ways[i][j-1]) % 1000000007;
            }
        }

        return (int)ways[n][m];
    }
}