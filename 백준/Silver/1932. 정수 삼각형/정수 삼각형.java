import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine()); // 100만 -> 완전 탐색은 시간 초과

		int[][] triangle = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print(triangle[i][j] + " ");
//			}
//			System.out.println();
//		}

		int[][] dp = new int[N + 1][N + 1];
		dp[1][1] = triangle[1][1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}

//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		int[] res = dp[N];
		Arrays.sort(res);

		System.out.println(res[res.length - 1]);
	}
}