import java.util.*;

class Solution {
    public long solution(int[] weights) {
        int[] weightsCount = new int[1001];
        for (int weight : weights) {
            weightsCount[weight] ++;
        }

        long answer = 0;
        for(int i = 100; i < 1001; i++) {
            if(weightsCount[i] == 0) continue;
            List<Integer> 후보 = new ArrayList<>(List.of(i, i/2*3, i*2, i/3*4));
            if(i % 2 != 0) 후보.set(1, 0);
            if(i % 3 != 0) 후보.set(3, 0);

            final int current = weightsCount[i];
            answer += (long)current * (current - 1) / 2;
            for(int k = i+1; k < 1001; k++) {
                if(후보.contains(k)) answer += (long)weightsCount[k] * current;
            }
        }
        return answer;
    }
}