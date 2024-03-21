import java.util.*;

class Solution {
    
    int[] dp1;
    int[] dp2;
    
    public int solution(int sticker[]) {
        dp1 = new int[sticker.length];
        dp2 = new int[sticker.length];
        
        if(sticker.length == 1) {
            return sticker[0];
        }else if(sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        dp1[0] = sticker[0];
        dp1[1] = sticker[1];
        dp1[2] = sticker[0] + sticker[2];
        
        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];
        
        for(int i = 3; i < sticker.length; i++) {
            if(i == sticker.length-1 && sticker.length % 2 != 0){
                dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + sticker[i];
                continue;
            }
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + sticker[i];
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + sticker[i];
        }

        int max1 = Math.max(dp1[sticker.length - 3], dp1[sticker.length - 2]);
        int max2 = Math.max(dp2[sticker.length - 1], dp2[sticker.length - 2]);
        return Math.max(max1, max2);
    }
}