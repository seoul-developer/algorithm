import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] cumSum;

	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 1024
		int M = Integer.parseInt(st.nextToken()); // 10만

		int[][] values = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				values[i][j] = Integer.parseInt(st.nextToken()); // 1000
			}
		}

		cumSum = new int[N + 1][N + 1]; // 최대 1024 * 1000 < int
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cumSum[i][j] = cumSum[i - 1][j] + cumSum[i][j - 1] + values[i][j] - cumSum[i - 1][j - 1];
			}
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(cumSum[i][j] + " ");
//			}
//			System.out.println();
//		}

		StringBuilder sb = new StringBuilder();

		for (int it = 0; it < M; it++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int partialSum = cumSum[x2][y2] - cumSum[x2][y1 - 1] - cumSum[x1 - 1][y2] + cumSum[x1 - 1][y1 - 1];
			sb.append(partialSum).append("\n");
		}

		System.out.println(sb);
	}
}