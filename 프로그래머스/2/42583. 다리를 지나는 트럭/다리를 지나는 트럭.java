import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int answer = 0;
        int bridgeWeight = 0;
        int i = 0;
        while(i < truck_weights.length) {
            final int truckWeight = truck_weights[i];
            if (!bridge.isEmpty() && bridge.size() == bridge_length) {
                bridgeWeight -= bridge.poll();
            }
            if (bridgeWeight + truckWeight <= weight) {
                bridge.offer(truckWeight);
                bridgeWeight += truckWeight;
                i++;
            } else {
                bridge.offer(0);
            }
            answer++;
        }
        return answer + bridge_length;
    }
}