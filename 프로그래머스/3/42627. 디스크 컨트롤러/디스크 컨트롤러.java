import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청한 순서로 정렬 
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a[1] != b[1]) {
                    // 소요 시간
                    return a[1] - b[1];
                } else {
                    // 요청 시각 (= 작업번호)
                    return a[0] - b[0];
                }
            }
        );
        
        int time = 0; // 현재 시각
        int idx = 0;
        int total = 0;
        int cnt = jobs.length;
        
        while (idx < cnt || !pq.isEmpty()) {
            // 현재 시각까지 들어온 작업들 큐에 넣기 
            while(idx < cnt && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                total += (time - job[0]);
            } else {
                // 아직 들어올 작업이 없다면 시간 점프 
                time = jobs[idx][0];
            }
        }
       
        return total / cnt;
    }
}