import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long f = facto(n-1);
        int type = n;
        int[] answer = new int[n];
        List<Integer> hubo = new ArrayList<>();
        for(int i = 1; i <=n; i++) {
            hubo.add(i);
        }
        
        long tmp = k;
        while(type > 1) {
            int a = (int) (tmp / f);
            long b = tmp % f;
            if(b == 0) {
                a--;
                b = f;
            }
            answer[n - type] = hubo.get(a);
            hubo.remove(a);
            tmp = b;
            type--;
            f /= type;
        }
        answer[n-1] = hubo.get(0);
        
        return answer;
    }
    
    private long facto(int n) {
        if(n == 1) return 1;
        return facto(n-1) * n;
    }
}