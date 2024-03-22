import java.util.*;

class Solution {
    public int solution(int n) {
        long[] dp = new long[n+1];
        int div = 1000000007;
        
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        for(int i = 6; i <= n; i = i + 2) {
            dp[i] = dp[i-2] * 3 % div;
            for(int h = i-4; h >= 0; h = h-2) {
                dp[i] += dp[h]*2 % div;
            }
            dp[i] %= div;
        }
        return (int)dp[n];
    }
}