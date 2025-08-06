import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine()); // 100
		int m = Integer.parseInt(br.readLine()); // 10만

		long[][] ans = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					ans[i][j] = 0;
				} else {
					ans[i][j] = Long.MAX_VALUE;
				}
			}
		}

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 0~10만

			// 노선은 하나가 아닐 수 있다.
			// initialize
			ans[a][b] = Math.min(ans[a][b], c);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (ans[i][k] != Long.MAX_VALUE && ans[k][j] != Long.MAX_VALUE) {
						ans[i][j] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				long val = ans[i][j];
				if (val == Long.MAX_VALUE) {
					ans[i][j] = 0;
				}
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
