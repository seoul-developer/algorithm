import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int truckNum = truck_weights.length;
        
        Queue<Integer> queue = new LinkedList<>();
        
        int sum = 0;
        int time = 0;
        
        for(int i=0; i<truckNum; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum+=truck;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                    // 트럭이 가득참
                    sum -= queue.poll();
                } else {
                    if(sum+truck<=weight) {
                        queue.add(truck);
                        sum+=truck;
                        time++;
                        break;
                    } else {
                        // 0을 넣어 큐에 트럭이 다리를 건너게 만든다. 
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time+bridge_length;
    }
}