import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 1000
		int m = Integer.parseInt(st.nextToken()); // 1000

		int[][] map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		int max = 0;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 0) {
					dp[i][j] = 0;
					continue;
				}
				int before = dp[i - 1][j - 1] * dp[i - 1][j] * dp[i][j - 1] > 0
						? Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1])
						: 0;
				int curr = before + map[i][j];
				dp[i][j] = curr;
				max = Math.max(curr, max);
			}
		}

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}

		System.out.println(max * max);
	}
}