class Solution {
    public int solution(int n) {
        final String nStr = Integer.toBinaryString(n);
        int n1count = Integer.bitCount(n);
        int next = n+1;
        while(true) {
            int next1count = Integer.bitCount(next);
            if(next1count == n1count){
                break;
            }
            next++;
        }

        int answer = next;
        return answer;
    }
}