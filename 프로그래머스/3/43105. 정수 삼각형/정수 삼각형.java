import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                final int me = triangle[i][j];
                if (j == 0) {
                    triangle[i][j] = triangle[i-1][0] + me;
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] = triangle[i-1][j-1] + me;
                } else {
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + me;
                }
            }
        }
        final int[] ints = triangle[triangle.length - 1];
        Arrays.sort(ints);
        return ints[triangle.length-1];
    }
}