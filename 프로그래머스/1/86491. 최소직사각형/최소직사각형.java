class Solution {
    public int solution(int[][] sizes) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < sizes.length; i++) {
            int c = sizes[i][0];
            int d = sizes[i][1];
            if(c < d) {
                int tmp = c;
                c = d;
                d = tmp;
            }
            if(c > a) a = c;
            if(d > b) b = d;
        }
        return a*b;
    }
}