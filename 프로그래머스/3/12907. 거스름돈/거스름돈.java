import java.util.*;

class Solution {
    int[] dp;
    int div;
    public int solution(int n, int[] money) {
        dp = new int[n+1];
        div = 1000000007;
        Arrays.sort(money);
        
        dp[0] = 1;
        for(int i = 0; i < money.length; i++) {
            int unit = money[i];
            for(int k = unit; k <= n; k++) {
                dp[k] = dp[k] + dp[k - unit];
            }
        }
        return dp[n];
    }
}