class Solution {
    public int solution(int a, int b) {    
        int res1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int res2 = 2 * a * b;
        
        if(res1>=res2){
            return res1;
        }
        return res2;
    }
}