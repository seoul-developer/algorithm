import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        Arrays.sort(works);
        
        int turn = works.length -1;
        while(n > 0) {
            n--;
            works[turn]--;
            if(turn-1 >= 0 && works[turn] < works[turn-1]) turn--;
            else if(turn < works.length-1 &&works[turn] == works[turn+1]) turn = works.length - 1;
            if(turn == 0 && works[0] == 0) return 0;
        }
        long answer = 0;
        for(int i = 0; i < works.length; i++) {
            answer += Math.pow(works[i], 2);
        }
        return answer;
    }
}