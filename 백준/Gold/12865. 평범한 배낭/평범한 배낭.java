import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 100
		int K = Integer.parseInt(st.nextToken()); // 10만

		List<int[]> monos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()); // 10만
			int V = Integer.parseInt(st.nextToken()); // 1000

			monos.add(new int[] { W, V });
		}

		// dp[i][j] = i번째 물건까지 고려했을 때 무게 j일 때의 최대 가치
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			int w = monos.get(i - 1)[0];
			int v = monos.get(i - 1)[1];

			for (int j = 1; j <= K; j++) {
				if (j < w) {
					// 현재 물건을 못 넣는 경우
					dp[i][j] = dp[i - 1][j];
				} else {
					// 현재 물건을 넣을지 말지 선택
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}