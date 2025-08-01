import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 100

		long[][] cnts = new long[N][21]; // i번째까지 계산했을 때 j일 경우의 수를 저장
		int[] values = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		int firstVal = values[0];
		int target = values[N - 1];

		cnts[0][firstVal] = 1;

		// O(N)
		for (int i = 1; i < N - 1; i++) {
			int val = values[i];
//			System.out.printf("val: %d%n", val);

			for (int j = 0; j <= 20; j++) {
				if (cnts[i - 1][j] > 0) {
					int beforeVal = j;
					int new1 = beforeVal + val;
					if (new1 <= 20 && new1 >= 0) {
						cnts[i][new1] += cnts[i - 1][j];
					}
					int new2 = beforeVal - val;
					if (new2 >= 0 && new2 <= 20) {
						cnts[i][new2] += cnts[i - 1][j];
					}
				}
			}
		}

//		for (int i = 0; i < N - 1; i++) {
//			System.out.println("더하는 수: " + values[i]);
//			for (int j = 0; j <= 20; j++) {
//				System.out.printf("%d번째 연산까지 해서 합이 %d인 경우의 수: %d %n", i, j, cnts[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(cnts[N - 2][target]);
	}
}