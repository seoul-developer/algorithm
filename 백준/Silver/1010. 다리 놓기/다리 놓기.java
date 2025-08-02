import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		long[][] combinations = new long[31][31];

		for (int n = 0; n <= 30; n++) {
			for (int k = 0; k <= Math.min(n, 30); k++) {
				if (k == 0 || k == n) {
					combinations[n][k] = 1;
				} else {
					combinations[n][k] = combinations[n - 1][k - 1] + combinations[n - 1][k];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 30
			int N = Integer.parseInt(st.nextToken()); // 30

			sb.append(combinations[N][M]).append("\n");
		}

		System.out.println(sb.toString());
	}
}