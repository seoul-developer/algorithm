class Solution {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int number = 1;
        int x = 0;
        int y = -1;
        int direction = 1;

        while (n > 0) {
            for (int i = 0; i < n; i++) {
                y += direction;
                answer[x][y] = number++;
            }
            n--;

            for (int i = 0; i < n; i++) {
                x += direction;
                answer[x][y] = number++;
            }
            direction *= -1;
        }
        return answer;
    }
}
