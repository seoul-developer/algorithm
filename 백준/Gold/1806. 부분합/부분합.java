import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 연속된 수의 부분합 중 S 이상인 것 -> 이중 가장 짧은 것의 길이

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 10만
		int S = Integer.parseInt(st.nextToken()); // 1억

		int[] values = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken()); // 1만
		}

		// 2 pointer -> O(N)
		int l = 0, r = 0;
		long sum = values[0], length = Integer.MAX_VALUE, cnt = 0;
		;

		while (true) {
			if (r == N) {
				break;
			}

			if (sum < S) {
				r++;
				if (r <= N - 1) {
					sum += values[r];
				}
			} else if (sum >= S) {
				int currLength = r - l + 1;
				length = Math.min(length, currLength);
				cnt++;
				sum -= values[l];
				l++;
			}
		}

		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		
		System.out.print(length);
	}
}