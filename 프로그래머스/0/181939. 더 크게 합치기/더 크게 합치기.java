class Solution {
    public int solution(int a, int b) {
       int res1=  Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int res2=  Integer.parseInt(Integer.toString(b) + Integer.toString(a));
        
        if(res1>=res2){
            return res1;
        }
        return res2;
    }
}