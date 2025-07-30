class Solution {
    public int solution(int a, int b, int c) {
        if(a!=b && b!=c && a!=c) {
            return a+b+c;
        }
        
        boolean twoDiff1 = a==b && b!=c && c!=a;
        boolean twoDiff2 = a!=b && b==c && c!=a;
        boolean twoDiff3 = a!=b && b!=c && c==a;
        
        if(twoDiff1 || twoDiff2 || twoDiff3){
            return (a+b+c)*(a*a+b*b+c*c);
        }
        
        return (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c);
    }
}