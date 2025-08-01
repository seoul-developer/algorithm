import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MOD = 10007;

	public static void main(String[] args) throws IOException {
		// 큰 숫자의 combination
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1000
		int K = Integer.parseInt(st.nextToken()); // 1000

		// 완전탐색 => O(2^N) 시간 초과 발생
		long[][] combinations = new long[N + 1][K + 1];

		for (int n = 0; n <= N; n++) {
			for (int k = 0; k <= Math.min(n, K); k++) {
				if (k == 0 || k == n) {
					combinations[n][k] = 1;
				} else {
					combinations[n][k] = (combinations[n - 1][k - 1] + combinations[n - 1][k]) % MOD;
				}
			}
		}

		System.out.println(combinations[N][K]);
	}
}