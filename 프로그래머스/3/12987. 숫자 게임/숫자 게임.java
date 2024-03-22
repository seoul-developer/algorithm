import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int indexB = 0;
        for(int indexA = 0; indexA < A.length; indexA++) {
            if(indexB >= B.length) break;
            if(A[indexA] < B[indexB]) {
                answer++;
                indexB++;
                continue;
            }
            while(indexB < B.length) {
                if(A[indexA] < B[indexB]) {
                    answer++;
                    indexB++;
                    break;
                }else{
                    indexB++;
                }
            }
        }
        return answer;
    }
}