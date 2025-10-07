import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] minTree;
	static int[] maxTree;
	static int rootIndex;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		createTree(N);
//		System.out.printf("treeSize: %d, rootIndex: %d%n", tree.length, rootIndex);

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			minTree[rootIndex + i] = val;
			maxTree[rootIndex + i] = val;
		}

		buildTree();

		for (int i = 1; i < minTree.length; i++) {
//			System.out.printf("i: %d, min: %d%n", i, minTree[i]);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] res = query(a, b);
			sb.append(res[0]).append(" ").append(res[1]).append("\n");
		}

		System.out.println(sb);
	}

	private static int[] query(int l, int r) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		l += rootIndex - 1;
		r += rootIndex - 1;

//		System.out.printf("l: %d, r:%d %n", l, r);

		while (l <= r) {
			if (l % 2 == 1) {
				min = Math.min(min, minTree[l]);
				max = Math.max(max, maxTree[l]);
				l++;
			}
			if (r % 2 == 0) {
				min = Math.min(min, minTree[r]);
				max = Math.max(max, maxTree[r]);
				r--;
			}

			l /= 2;
			r /= 2;
		}

		return new int[] { min, max };
	}

	private static void buildTree() {
		for (int i = rootIndex - 1; i >= 1; i--) {
			minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
			maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
		}

	}

	private static void createTree(int num) {
		int rootSize = 1;
		while (rootSize < num) {
			rootSize *= 2;
		}

		rootIndex = rootSize;
		minTree = new int[rootSize * 2];
		maxTree = new int[rootSize * 2];
	}
}