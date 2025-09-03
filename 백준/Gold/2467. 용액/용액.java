import java.io.*;
import java.util.*;

public class Main {

	static final int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 10만

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		int[] min = new int[3];
		Arrays.fill(min, Integer.MAX_VALUE);

		int l = 0, r = N - 1;
		while (l < r) {
			int left = inputs[l];
			int right = inputs[r];

			int sum = left + right;

			if (Math.abs(sum) <= Math.abs(min[2])) {
				min[0] = left;
				min[1] = right;
				min[2] = sum;
			}

			if (sum > 0) {
				r--;
			} else if (sum < 0) {
				l++;
			} else if (sum == 0) {
				break;
			}
		}

		System.out.printf("%d %d", min[0], min[1]);
	}
}
