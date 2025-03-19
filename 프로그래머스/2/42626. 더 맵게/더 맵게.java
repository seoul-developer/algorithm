import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: scoville){
            queue.offer(i);
        }
        
        int answer = 0;
        
        while(!queue.isEmpty()){
            if(queue.peek() >= K) {
                queue.poll();
                return answer;
            }
            
            if(queue.size() <= 1){
                return -1;
            }
            if(queue.size()>1) {
                int first = queue.poll();
                int second = queue.poll();
                
                int mixed = first + 2*second;
                answer++;
                queue.offer(mixed);
            }
        }
        
        if(queue.isEmpty()){
            return answer;
        }
        return -1;
    }
}