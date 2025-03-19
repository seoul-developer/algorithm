import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            
            int mok = (100 - progress) / speed;
            int remainder = (100 - progress) % speed;
            
            if(remainder == 0) {
                queue.offer(mok);
            }
            if(remainder > 0) {
                queue.offer(mok+1);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int first = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty() && first >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            
            result.add(cnt);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}