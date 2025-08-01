import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] combinations;
	static int K;

	public static void main(String[] args) throws IOException {
		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 100
		int M = Integer.parseInt(st.nextToken()); // 100
		K = Integer.parseInt(st.nextToken()); // 10억

		// (N+M) C M
		StringBuilder sb = new StringBuilder();

		// combination 계산
		combinations(N + M);

		if (combinations[N + M][M] < K) {
			sb.append(-1);
			System.out.println(sb.toString());
			return;
		}

		int target = K;
		int aNum = N; // a의 개수
		int zNum = M; // z의 개수
//		System.out.printf("남은 a: %d, z: %d -> %s%n", aNum, zNum, sb.toString());
		while (true) {
			int cnt = combinations[aNum + zNum - 1][zNum]; // 첫글자가 a인 글자의 개수
			if (cnt >= target) {
				// 첫글자가 a인 경우
				sb.append("a");
				aNum--;
			} else {
				// 첫글자가 z인 경우
				sb.append("z");
				zNum--;
				target -= cnt;
			}
//			System.out.printf("cnt: %d, 남은 a: %d, z: %d, taget: %d -> %s%n", cnt, aNum, zNum, target, sb.toString());
			if (aNum == 0) {
				// 남은 건 전부 다 z
				for (int i = 0; i < zNum; i++) {
					sb.append("z");
				}
				break;
			}

			if (zNum == 0) {
				// 남은거는 전부 다 a
				for (int i = 0; i < aNum; i++) {
					sb.append("a");
				}
				break;
			}
		}

		System.out.println(sb.toString());
	}

	private static void combinations(int total) {
		combinations = new int[total + 1][total + 1];

		for (int n = 0; n <= total; n++) {
			for (int m = 0; m <= n; m++) {
				if (n == m || m == 0) {
					combinations[n][m] = 1;
				} else {
					int newVal = combinations[n - 1][m] + combinations[n - 1][m - 1];
					if (newVal > K) {
						combinations[n][m] = K + 1;
					} else {
						combinations[n][m] = newVal;
					}
				}
			}
		}
	}

}