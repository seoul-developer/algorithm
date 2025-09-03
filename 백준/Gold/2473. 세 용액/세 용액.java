import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static final int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static Map<Integer, List<String>> sum2Map;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 10만

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] inputs = new int[N]; // 10억
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputs);

		long[] min = new long[4]; // e1, e2, e3, val
		Arrays.fill(min, Long.MAX_VALUE);

		for (int fixIdx = 0; fixIdx <= N - 2; fixIdx++) {
			int l = fixIdx + 1, r = N - 1;
			int e1 = inputs[fixIdx];

			while (l < r) {
				int e2 = inputs[l];
				int e3 = inputs[r];

				long sum3 = (long) e1 + e2 + e3;

				if (Math.abs(sum3) < Math.abs(min[3])) {
					min[3] = sum3;
					min[0] = e1;
					min[1] = e2;
					min[2] = e3;
				}

				if (sum3 < 0) {
					l++;
				} else if (sum3 > 0) {
					r--;
				} else {
					break;
				}
			}
		}

		Arrays.sort(min, 0, 3);
		System.out.printf("%d %d %d", min[0], min[1], min[2]);
	}
}
