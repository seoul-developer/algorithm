import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		// dp[len][digit][mask]: 길이가 len, 마지막 수가 digit, 숫자 사용 mask인 계단 수의 개수
		// 총 100x10x2^10 = 약 100만

		int[][][] dp = new int[N + 1][10][1 << 10];

		// init (can't start with 0)
		for (int d = 1; d <= 9; d++) {
			dp[1][d][1 << d] = 1;
		}

		for (int len = 2; len <= N; len++) {
			for (int digit = 0; digit <= 9; digit++) {
				for (int mask = 0; mask < (1 << 10); mask++) {
					if (dp[len - 1][digit][mask] == 0) {
						continue;
					}

					if (digit > 0) {
						int nextMask = mask | (1 << (digit - 1));
						dp[len][digit - 1][nextMask] += dp[len - 1][digit][mask];
						dp[len][digit - 1][nextMask] %= MOD;
					}

					if (digit < 9) {
						int nextMask = mask | (1 << (digit + 1));
						dp[len][digit + 1][nextMask] += dp[len - 1][digit][mask];
						dp[len][digit + 1][nextMask] %= MOD;
					}
				}
			}
		}

		int FULL = (1 << 10) - 1;
		long ans = 0;
		for (int d = 0; d <= 9; d++) {
			ans += dp[N][d][FULL];
			ans %= MOD;
		}

		System.out.println(ans);
	}
}
