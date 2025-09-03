import java.util.*;

class Solution {
    
    private static final int INF = Integer.MAX_VALUE;
    
    public int solution(String numbers) {
        // 10만 
        List<int[]> weights = new ArrayList<>();
    
        weights.add(new int[]{1,7,6,7,5,4,5,3,2,3}); // 0
        weights.add(new int[]{7,1,2,4,2,3,5,4,5,6}); // 1
        weights.add(new int[]{6,2,1,2,3,2,3,5,4,5}); // 2
        weights.add(new int[]{7,4,2,1,5,3,2,6,5,4}); // 3
        weights.add(new int[]{5,2,3,5,1,2,4,2,3,5}); // 4
        weights.add(new int[]{4,3,2,3,2,1,2,3,2,3}); // 5
        weights.add(new int[]{5,5,3,2,4,2,1,5,3,2}); // 6
        weights.add(new int[]{3,4,5,6,2,3,5,1,2,4}); // 7
        weights.add(new int[]{2,5,4,5,3,2,3,2,1,2}); // 8
        weights.add(new int[]{3,6,5,4,5,3,2,4,2,1}); // 9
        
        int[][] cur = new int[10][10];
        int[][] nxt = new int[10][10];
        for (int i = 0; i < 10; i++) Arrays.fill(cur[i], INF);
        
        // 시작 위치: 왼손=4, 오른손=6
        cur[4][6] = 0;
        
        for(char ch: numbers.toCharArray()) {
            int next = ch - '0';
            
            for(int i=0; i<10; i++) {
                Arrays.fill(nxt[i], INF);
            }
            
            for(int l=0; l<10; l++) {
                for(int r=0; r<10; r++) {
                    int cost = cur[l][r];
                    if(cost == INF) {
                        continue;
                    }
                    
                    if(l==next) {
                        // 왼손이 이미 그자리에 있음 -> 누른다
                        nxt[l][r] = Math.min(nxt[l][r], cost+1);
                    } else if(r==next) {
                        nxt[l][r] = Math.min(nxt[l][r], cost+1);
                    } else {
                        // 왼손으로 누르기
                        int cL = weights.get(l)[next];
                        nxt[next][r] = Math.min(nxt[next][r], cost+cL);
                        
                        // 오른손으로 누르기
                        int cR = weights.get(r)[next];
                        nxt[l][next] = Math.min(nxt[l][next], cost+cR);
                    }
                }
            }
            
            // swap
            int[][] tmp = cur;
            cur = nxt;
            nxt = tmp; 
        }
        
        int answer = INF;
        for(int l=0; l<10; l++) {
            for(int r=0; r<10; r++) {
                answer = Math.min(answer, cur[l][r]);
            }
        }
        
        return answer;
    }
}