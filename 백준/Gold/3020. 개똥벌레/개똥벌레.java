import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] indexedTree;
	static int ans = 0;
	static int size = 1;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] rocks = new int[H + 2];
		Arrays.fill(rocks, 0);

		for (int i = 1; i <= N; i++) {
			int length = Integer.parseInt(br.readLine());
			if (i % 2 == 1) {
				rocks[1]++;
				rocks[length + 1]--;
			} else if (i % 2 == 0) {
				rocks[H - length + 1]++;
				rocks[H + 1]--;
			}
		}

		for (int i = 1; i <= H; i++) {
			rocks[i] = rocks[i] + rocks[i - 1];
		}

		// O(N*H) 20만*50만=1000억=1000초
//		for (int i = 1; i <= N; i++) {
//			int length = Integer.parseInt(br.readLine());
//			if (i % 2 == 1) {
//				for (int j = 1; j <= length; j++) {
//					rocksNum[j]++;
//				}
//			} else if (i % 2 == 0) {
//				// H-length+1 ~ H
//				for (int j = H - length + 1; j <= H; j++) {
//					rocksNum[j]++;
//				}
//			}
//		}

//		for (int i = 1; i <= H; i++) {
//			System.out.println(rocks[i]);
//		}
		
		Arrays.sort(rocks, 1, H+1);
		int min = rocks[1];
		
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			if (rocks[i] < 0) {
				continue;
			}
			if (rocks[i] == min) {
				cnt++;
			} else {
				break;
			}
		}

		System.out.printf("%d %d%n", min, cnt);
	}
}