class Solution {
    static int[][] dp;

    public int solution(int alp, int cop, int[][] problems) {
        int alpMax = alp;
        int copMax = cop;
        for (int i = 0; i < problems.length; i++) {
            if (problems[i][0] > alpMax) {
                alpMax = problems[i][0];
            }
            if (problems[i][1] > copMax) {
                copMax = problems[i][1];
            }
        }

        dp = new int[alpMax+1][copMax+1];
        for (int i = alp; i <= alpMax; i++) {
            for (int j = cop; j <= copMax; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
        for (int i = alp; i <= alpMax; i++) {
            for (int j = cop; j <= copMax; j++) {
                if(i+1 <= alpMax) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                if(j+1 <= copMax) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                for(int k = 0; k < problems.length; k++) {
                                      final int dx = problems[k][2];
                    final int dy = problems[k][3];
                    final int cost = problems[k][4];
                    if (i >= problems[k][0] && j >= problems[k][1] && i + dx <= alpMax && j + dy <= copMax) {
                        dp[i + dx][j + dy] = Math.min(dp[i][j] + cost, dp[i + dx][j + dy]);
                    }else if (i >= problems[k][0] && j >= problems[k][1] && i + dx > alpMax && j + dy > copMax) {
                        dp[alpMax][copMax] = Math.min(dp[i][j] + cost, dp[alpMax][copMax]);
                    }else if (i >= problems[k][0] && j >= problems[k][1] && i + dx <= alpMax && j + dy > copMax) {
                        dp[i + dx][copMax] = Math.min(dp[i][j] + cost, dp[i + dx][copMax]);
                    }else if (i >= problems[k][0] && j >= problems[k][1] && i + dx > alpMax && j + dy <= copMax) {
                        dp[alpMax][j + dy] = Math.min(dp[i][j] + cost, dp[alpMax][j + dy]);
                    }
                }
            }
        }

        return dp[alpMax][copMax];
    }
}