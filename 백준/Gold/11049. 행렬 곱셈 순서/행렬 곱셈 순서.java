import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine()); // 500

		int[][] matrix = new int[N + 1][2];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 500
			int c = Integer.parseInt(st.nextToken()); // 500

			matrix[i][0] = r;
			matrix[i][1] = c;
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.println(matrix[i][0] + "X" + matrix[i][1]);
//		}

		int[][] dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			// 가운데 대각선 초기화
			dp[i][i] = 0;
		}

		for (int len = 2; len <= N; len++) {
			for (int i = 1; i <= N - len + 1; i++) {
				int j = i + len - 1;
				// D[i][j]를 구함
				dp[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {
					int cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
//					System.out.printf("i %d j %d k %d cost %d%n", i, j, k, cost);

					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 정답 2^31-1 이하 -> int
		System.out.println(dp[1][N]);
	}
}