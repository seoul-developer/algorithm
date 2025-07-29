import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(trees[i]);
//		}

		// 입력 받기 완료

		int low = 0;
		int high = 1_000_000_000;
		int mid = -1;
		int ans = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			long sum = cutTree(trees, mid);
			if (sum < M) {
				high = mid - 1;
			}
			if (sum >= M) {
				ans = mid;
				low = mid + 1;
			}
		}

		System.out.println(ans);
	}

	private static long cutTree(int[] trees, int mid) {
		long sum = 0;
		for (int tree : trees) {
			sum += Math.max(tree - mid, 0);
		}

		return sum;

	}
}
