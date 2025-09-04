import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int MAX_SIZE = 1000 * 100 + 1;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 1000
		int N = Integer.parseInt(st.nextToken()); // 20

		long[] dp = new long[MAX_SIZE]; // i 의 비용으로 확보할 수 있는 최대 고객 수
		Arrays.fill(dp, 0);

		for (int it = 0; it < N; it++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			for (int i = cost; i < MAX_SIZE; i++) {
				dp[i] = Math.max(dp[i], dp[i - cost] + cnt);
			}
		}

		for (int i = 0; i < MAX_SIZE; i++) {
			if (dp[i] >= C) {
				System.out.println(i);
				return;
			}
		}
	}
}