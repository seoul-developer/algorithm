import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] tree;
	static int rootIndex;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 선수의 수 (50만)
		int[] input = new int[N];
		int[] original = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine()); // 10억
			original[i] = input[i];
		}

		Arrays.sort(original);

		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			indexMap.put(original[i], i + 1); // index 압축
		}

		// create indexed tree
		int size = 1;
		while (size < N) {
			size *= 2;
		}

		size *= 2;
		tree = new int[size + 1];

		rootIndex = size / 2; // root는 8번부터 시작

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {

//			for (int j = 1; j < tree.length; j++) {
//				System.out.printf("it %d: index %d val %d %n", i, j, tree[j]);
//			}
//			System.out.println();

			// 실력 압축 인덱스 K 의 선수 1명을 트리에 추가
			int index = indexMap.get(input[i]);
			addIndex(index);
			// 실력 압축 인덱스 1 ~ K-1 의 선수 수를 트리에서 더함 -> 내 앞에 나보다 못하는 사람 수
			int cnt = cnt(1, index - 1);
			// i번째 선수의 최선의 등수는 (i+1-앞의합)
			int best = i + 1 - cnt;
			if (best < 1) {
				best = 1;
			}
			sb.append(best).append("\n");
//			System.out.println("best: " + best);
		}

		System.out.println(sb);
	}

	private static int cnt(int left, int right) {
		int l = rootIndex + left - 1;
		int r = rootIndex + right - 1;

//		System.out.printf("left %d val %d, right %d val %d%n", l, tree[l], r, tree[r]);

		int cnt = 0;
		while (l <= r) {
			if (l % 2 == 1) {
				cnt += tree[l];
				l++;
			}
			l /= 2;

			if (r % 2 == 0) {
				cnt += tree[r];
				r--;
			}
			r /= 2;
//			System.out.printf("l: %d, r: %d, cnt: %d %n", l, r, cnt);
		}

		return cnt;
	}

	private static void addIndex(int index) {
		int insertIndex = rootIndex + index - 1;
//		System.out.println(insertIndex);

		tree[insertIndex]++;

		// rebalance tree
		int currIndex = insertIndex / 2;
		while (currIndex >= 1) {
			tree[currIndex] = tree[currIndex * 2] + tree[currIndex * 2 + 1];
			currIndex /= 2;
		}
	}
}