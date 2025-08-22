import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int H;
	static int W;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new int[H + 2][W + 2];
		for (int h = 1; h <= H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 1; w <= W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[H + 2][W + 2]; // N-1번째까지의 칸 방문 횟수
		dp[1][1] = N - 1;

		for (int h = 1; h <= H; h++) {
			for (int w = 1; w <= W; w++) {
				if (dp[h][w] == 0) {
					continue;
				}

				if (map[h][w] == 1) {
					// right
					long right = dp[h][w] / 2 + dp[h][w] % 2;
					long down = dp[h][w] / 2;

					dp[h][w + 1] += right;
					dp[h + 1][w] += down;
				} else {
					// down
					long down = dp[h][w] / 2 + dp[h][w] % 2;
					long right = dp[h][w] / 2;

					dp[h + 1][w] += down;
					dp[h][w + 1] += right;
				}

			}
		}

//		for (int h = 1; h <= H; h++) {
//			for (int w = 1; w <= W; w++) {
//				System.out.print(dp[h][w] + " ");
//			}
//			System.out.println();
//		}

		for (int h = 1; h <= H; h++) {
			for (int w = 1; w <= W; w++) {
				if (dp[h][w] % 2 == 1) {
					map[h][w] ^= 1; // flip

				}
			}
		}

		int[] result = dfs(1, 1);
		System.out.printf("%d %d%n", result[0], result[1]);
	}

	private static int[] dfs(int i, int j) {
		if (i == H + 1 || j == W + 1) {
			return new int[] { i, j };
		}

		int curr = map[i][j];

		if (curr == 1) {
			// right
			return dfs(i, j + 1);
		} else {
			// down
			return dfs(i + 1, j);
		}
	}
}
