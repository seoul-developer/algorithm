import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 4000

		long[][] nums = new long[n][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = Long.parseLong(st.nextToken());
			nums[i][1] = Long.parseLong(st.nextToken());
			nums[i][2] = Long.parseLong(st.nextToken());
			nums[i][3] = Long.parseLong(st.nextToken());
		}

		// (A+B) + (C+D) = 0
		// 각 O(N^2) < 1억
		long[] ab = new long[n * n];
		long[] cd = new long[n * n];

		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ab[index] = nums[i][0] + nums[j][1];
				cd[index] = -(nums[i][2] + nums[j][3]);
				index++;
			}
		}

		Arrays.sort(ab);
		Arrays.sort(cd);

//		for (int i = 0; i < n * n; i++) {
//			System.out.printf("ab: %d, cd: %d %n", ab.get(i), cd.get(i));
//		}

		int abPtr = 0;
		int cdPtr = 0;
		long ans = 0;

		while (true) {
			if (abPtr >= ab.length || cdPtr >= cd.length) {
				break;
			}

			long abSum = ab[abPtr];
			long cdSum = cd[cdPtr];

			if (abSum == cdSum) {
				long abCnt = 0;
				while (abPtr < ab.length && ab[abPtr] == abSum) {
					abCnt++;
					abPtr++;
				}

				long cdCnt = 0;
				while (cdPtr < cd.length && cd[cdPtr] == cdSum) {
					cdCnt++;
					cdPtr++;
				}

				ans += abCnt * cdCnt;
			} else if (abSum > cdSum) {
				cdPtr++;
			} else {
				abPtr++;
			}
		}

		System.out.println(ans);
	}
}