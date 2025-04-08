class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for(int i=0; i<included.length; i++) {
            boolean flag = included[i];
            if(flag) {
                answer += a + i * d;
            }
        }
        
        return answer;
    }
}