import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int CONST = 100000;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		long[][][][] dp = new long[w + 2][h + 2][2][2]; // i, j, 최근 이동 방향 (동: 0, 북: 1), 턴 가능 (0, 1)

		dp[2][1][0][1] = 1; // 첫 칸 동쪽으로 이동
		dp[1][2][1][1] = 1; // 첫 칸 북쪽으로 이동

		for (int i = 1; i <= w; i++) {
			for (int j = 1; j <= h; j++) {
				// 직진
				dp[i + 1][j][0][1] = (dp[i + 1][j][0][1] + dp[i][j][0][0]) % CONST;
				dp[i + 1][j][0][1] = (dp[i + 1][j][0][1] + dp[i][j][0][1]) % CONST;
				dp[i][j + 1][1][1] = (dp[i][j + 1][1][1] + dp[i][j][1][0]) % CONST;
				dp[i][j + 1][1][1] = (dp[i][j + 1][1][1] + dp[i][j][1][1]) % CONST;

				dp[i + 1][j][0][0] += (dp[i + 1][j][0][0] + dp[i][j][1][1]) % CONST;
				dp[i][j + 1][1][0] += (dp[i][j + 1][1][0] + dp[i][j][0][1]) % CONST;
			}
		}

		long ans = dp[w][h][1][0] + dp[w][h][1][1] + dp[w][h][0][0] + dp[w][h][0][1];
		System.out.println(ans % CONST);
	}
}
