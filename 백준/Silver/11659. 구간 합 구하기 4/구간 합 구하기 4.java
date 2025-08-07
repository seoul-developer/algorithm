import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] values;
	static int[] cumSum;

	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 10만
		int M = Integer.parseInt(st.nextToken()); // 10만

		values = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			values[i] = Integer.parseInt(st.nextToken()); // 1000
		}

		cumSum = new int[N + 1]; // 최대 10만 * 1000 = 1억 < 21억 (int)
		cumSum[1] = values[1];
		for (int i = 2; i <= N; i++) {
			cumSum[i] = cumSum[i - 1] + values[i];
		}

		StringBuilder sb = new StringBuilder();

		for (int it = 0; it < M; it++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(partialSum(i, j)).append("\n");
		}

		System.out.println(sb);
	}

	private static int partialSum(int i, int j) {
		return cumSum[j] - cumSum[i - 1];
	}
}