class Solution {
    public int solution(int[] money) {
        int max = 0;
        int num = money.length;
        int[] dp1 = new int[num]; // 첫 집을 털기 
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for(int i=2; i<num-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            max = Math.max(max, dp1[i]);
        }
        
        int[] dp2 = new int[num]; // 마지막 집 털기 
        dp2[0] = 0;
        dp2[1] = money[1];
        for(int i=2; i<num; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
            max = Math.max(max, dp2[i]);
        }
        
        return max;
    }
}