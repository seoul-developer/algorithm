import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] tree;
	static int rootIndex; // 루트 시작하는 인덱스

	public static void main(String[] args) throws IOException {
		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 500만
		int L = Integer.parseInt(st.nextToken()); // 500만

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // -10억 ~ + 10억
		}

		createIndexedTree(N);
		initializeTree(A);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			int l = Math.max(i - L + 1, 1);
			int r = i;

			int leftIndex = rootIndex + l - 1;
			int rightIndex = rootIndex + r - 1;

			int min = findMin(leftIndex, rightIndex);
			sb.append(min).append(" ");
		}

		System.out.println(sb);
	}

	private static int findMin(int l, int r) { // 2 pointer 모두 포함
		if (l == r) {
			return tree[l];
		}

		int min = Integer.MAX_VALUE;
		while (l < r) {
			if (l % 2 == 0) {
				l /= 2;
			} else {
				// 오른쪽 자식인 경우
				int curr = tree[l];
				min = Math.min(min, curr);
				l++;
				l /= 2;
			}

			if (r % 2 == 1) {
				r /= 2;
			} else {
				// 왼쪽 자식인 경우
				int curr = tree[r];
				min = Math.min(min, curr);
				r--;
				r /= 2;
			}
		}

		if (l == r) {
			min = Math.min(min, tree[l]);
		}

		return min;
	}

	private static void createIndexedTree(int N) {
		int size = 1;
		while (size < N) {
			size *= 2;
		}

		rootIndex = size;
		size *= 2;
		tree = new int[size + 1];
	}

	private static void initializeTree(int[] A) {
		// root 값 입력
		for (int i = 0; i < A.length; i++) {
			tree[rootIndex + i] = A[i];
		}

		for (int i = rootIndex + A.length; i < tree.length; i++) {
			tree[i] = Integer.MAX_VALUE;
		}

		// inner 노드 최소값으로 채우기
		for (int i = rootIndex - 1; i > 0; i--) {
			tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
		}
	}
}