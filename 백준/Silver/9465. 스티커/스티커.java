import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;
	private static boolean[] done;
	private static int cnt = 0;
	private static int[] inputs;
	private static int n;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int res = maxScore(n, stickers);
			sb.append(res).append("\n");
		}

		System.out.println(sb);
	}

	private static int maxScore(int n, int[][] stickers) {
		int[][] dp = new int[3][n]; // n열까지의 최대 점수, 마지막으로 i행을 골랐을 때

		dp[0][0] = stickers[0][0];
		dp[1][0] = stickers[1][0];
		dp[2][0] = 0; // 안고름

		for (int col = 1; col < n; col++) {
			dp[0][col] = Math.max(dp[1][col - 1], dp[2][col - 1]) + stickers[0][col];
			dp[1][col] = Math.max(dp[0][col - 1], dp[2][col - 1]) + stickers[1][col];
			dp[2][col] = Math.max(dp[0][col - 1], Math.max(dp[1][col - 1], dp[2][col - 1]));
		}

		return Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1]));
	}
}