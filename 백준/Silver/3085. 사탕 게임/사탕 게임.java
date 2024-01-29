import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        final char[][] candies = new char[n][n];

        for (int i = 0; i < n; i++) {
            candies[i] = scanner.next().toCharArray();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    char candy = candies[i][j];
                    candies[i][j] = candies[i][j + 1]; // 오른쪽과 swap
                    candies[i][j + 1] = candy;

                    final int currentMax = countMaximum(candies);
                    if (max < currentMax) {
                        max = currentMax;
                    }

                    candy = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = candy;
                }
                if (i + 1 < n) {
                    char candy = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = candy;

                    final int currentMax = countMaximum(candies);
                    if (max < currentMax) {
                        max = currentMax;
                    }

                    candy = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = candy;
                }
            }
        }
        System.out.println(max);
    }

    private static int countMaximum(final char[][] candies) {
        int n = candies.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candies[i][j] == candies[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (max < cnt)
                    max = cnt;
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candies[j][i] == candies[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (max < cnt)
                    max = cnt;
            }
        }
        return max;
    }
}
