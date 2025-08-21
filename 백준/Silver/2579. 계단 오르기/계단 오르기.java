import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine()); // 100만 -> 완전 탐색은 시간 초과

		int[] stairs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		if (N == 1) {
			System.out.println(stairs[1]);
			return;
		}

		// 1만 * 300 = 최대 300만 (int)
		int[][] dp = new int[3][N + 1];

		dp[1][1] = stairs[1];
		dp[2][1] = 0;

		dp[1][2] = stairs[2];
		dp[2][2] = stairs[1] + stairs[2];

		for (int n = 3; n <= N; n++) {
			dp[1][n] = Math.max(dp[1][n - 2], dp[2][n - 2]) + stairs[n];
			dp[2][n] = dp[1][n - 1] + stairs[n];
		}

		System.out.println(Math.max(dp[1][N], dp[2][N]));
	}
}