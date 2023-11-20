class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] first = new int[n];
        int[] last = new int[n];

        first[0] = money[0];
        first[1] = money[1];
        first[2] = money[2] + money[0];
        first[3] = money[3] + Math.max(first[1], first[0]);

        last[1] = money[1];
        last[2] = money[2];
        last[3] = money[3] + money[1];
        
        for(int i = 4; i < n - 1; i++) {
            first[i] = money[i] + Math.max(first[i-2], first[i-3]);
            last[i] = money[i] + Math.max(last[i-2], last[i-3]);
        }

        last[n-1] = money[n-1] + Math.max(last[n-3], last[n-4]);

        return Math.max(Math.max(first[n-2], first[n-3]), Math.max(last[n-1], last[n-2]));
    }
}