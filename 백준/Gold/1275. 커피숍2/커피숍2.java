import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] tree;
	static int rootIndex;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 10만
		int Q = Integer.parseInt(st.nextToken()); // 10만

		st = new StringTokenizer(br.readLine());
		int[] values = new int[N];
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		// create Tree
		createTree(values);

		List<Long> res = new ArrayList<>();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

//			System.out.printf("code: %d %d %d %d%n", x, y, a, b);
//			for (int j = 1; j < tree.length; j++) {
//				System.out.printf("index: %d, val: %d%n", j, tree[j]);
//			}

			if (x <= y) {
				res.add(sum(x, y));
			} else {
				res.add(sum(y, x));
			}
			change(a, b);
		}

		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining("\n")));
	}

	private static void createTree(int[] values) {
		int N = values.length;

		int size = 1;
		while (size < N) {
			size *= 2;
		}

		rootIndex = size;
		size *= 2;
		tree = new long[size + 1];

		// initialize root nodes
		for (int i = 0; i < values.length; i++) {
			tree[rootIndex + i] = values[i];
		}

		// calculate inner nodes
		for (int i = rootIndex - 1; i >= 1; i--) {
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
	}

	private static long sum(int x, int y) {
		int l = rootIndex + x - 1;
		int r = rootIndex + y - 1;
		long sum = 0;
		while (l <= r) {
//			System.out.printf("l: %d, r: %d, sum: %d %n", l, r, sum);

			if (l % 2 == 0) {
				l /= 2;
			} else {
				sum += tree[l];
				l++;
				l /= 2;
			}

			if (r % 2 == 1) {
				r /= 2;
			} else {
				sum += tree[r];
				r--;
				r /= 2;
			}
		}

		return sum;
	}

	private static void change(int a, int b) {
		int changeIndex = rootIndex + a - 1;
		tree[changeIndex] = b;

		int index = changeIndex / 2;
		while (index >= 1) {
			tree[index] = tree[2 * index] + tree[2 * index + 1];
			index /= 2;
		}
	}
}
