import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA); //철수
        Arrays.sort(arrayB); //영희
        
        for(int i = Math.max(arrayA[0], arrayB[0]); i >= 2; i--) {
            int flag = 0;
            int k = 0;
            for(; k < arrayA.length; k++) {
                if(arrayA[k] % i == 0 && arrayB[k] % i != 0) {
                    if(flag == 0) flag = 1;
                    if(flag == 2) break;
                    continue;
                }else if(arrayA[k] % i != 0 && arrayB[k] % i == 0){
                    if(flag == 0) flag = 2;
                    if(flag == 1) break;
                    continue;
                }
                break;
            }
            if(k == arrayA.length) {
                return i;
            }
        }
        return 0;
    }
}