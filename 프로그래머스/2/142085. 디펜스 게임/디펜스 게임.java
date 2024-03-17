import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            pq.add(enemy[i]);
        }
        
        int index = k;
        int count = 0;
        int answer = 0;
        while(k < enemy.length && count < n) {
            if(enemy[k] > pq.peek()) {
                count += pq.remove();
                pq.add(enemy[k]);
            }else {
                count += enemy[k];
            }
            if(count <= n) {
                answer++;
            }
            k++;
        }

        return answer + pq.size();
    }
}