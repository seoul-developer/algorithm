import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine()); // 50

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] colors = new int[M];
		int sum = 0; // 50x50
		for (int i = 0; i < M; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			colors[i] = cnt;
			sum += cnt;
		}

		int K = Integer.parseInt(br.readLine());

		double[][] comb = new double[sum + 1][K + 1];
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= i && j <= K; j++) {
				if (i == j || j == 0) {
					comb[i][j] = 1;
				} else if (j == 1) {
					comb[i][j] = i;
				} else {
					comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
				}
			}
		}

		// sum(color C k) / sum C k
		double up = 0.0;
		for (int val : colors) {
			if (val < K) {
				continue;
			}
			up += comb[val][K];
		}
		double down = comb[sum][K];

		System.out.println(up / down);
	}
}
