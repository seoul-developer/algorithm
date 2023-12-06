class Solution {

    public int[] solution(int n, int k) {
        final int num = n / k;
        int[] answer = new int[num];

        for (int i = 1; i <= num; i++) {
            answer[i - 1] = k * i;
        }

        return answer;
    }
}