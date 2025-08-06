import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] roots;
	static int[] weightDiff;

	public static void main(String args[]) throws Exception {
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		while (true) {
			String input = br.readLine();
			if (input.equals("0 0")) {
				break;
			}

			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken()); // 10만
			int M = Integer.parseInt(st.nextToken()); // 10만

			// initialize arrays
			initialize();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				String code = st.nextToken();
				if (code.equals("!")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int w = Integer.parseInt(st.nextToken());

					write(a, b, w);

					// log
//					for (int ind = 1; ind <= N; ind++) {
//						System.out.printf("ind: %d, root: %d, diff: %d%n", ind, roots[ind], weightDiff[ind]);
//					}
//					System.out.println();

				} else if (code.equals("?")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					Object res = read(a, b);

//					System.out.printf("a: %d, b: %d, res: %d%n", a, b, res);

					sb.append(res).append("\n");
				}
			}
		}

		System.out.println(sb);
	}

	private static void initialize() {
		roots = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			roots[i] = i;
		}

		weightDiff = new int[N + 1];
		Arrays.fill(weightDiff, 0);
	}

	private static void write(int a, int b, int w) {
		// weightDiff[x] = weight[x] - weight[root[x]]

		int aRoot = findRoot(a); // 왼쪽 노드
		int bRoot = findRoot(b); // 오른쪽 노드

		if (aRoot == bRoot) {
			// 이미 쓰여 있는 경우
			return;
		}

		// union: a가 b 아래에 붙는다
		roots[bRoot] = aRoot; // bRoot는 더이상 루트가 아니게 됨! aRoot 기준으로 재조정 필요

		// b는 a보다 w만큼 무겁다
		// weight b = weight a + w
		// weightDiff[x] = weight[x] - weight[root[x]]
		// weight[x] = weight[root[x]] + weightDiff[x]
		// weight[bRoot] + weightDiff[b] = weight[aRoot] + weightDiff[a] + w
		// weight[bRoot] - weight[aRoot] = weightDiff[a] - weightDiff[b] + w
		// 우리는 bRoot를 aRoot로 만들었으니, 그 차이만큼을 더해서 평행이동 시켜야 함
		weightDiff[bRoot] = weightDiff[a] + w - weightDiff[b];
//		System.out.printf("a: %d, b: %d, aRoot: %d, bRoot: %d%n", a, b, aRoot, bRoot);
	}

	private static Object read(int a, int b) {
		int aParent = findRoot(a);
		int bParent = findRoot(b);

		if (aParent == bParent) {
			return weightDiff[b] - weightDiff[a];
		}

		return "UNKNOWN";
	}

	private static int findRoot(int v) {
		int parent = roots[v];
		if (parent == v) {
			return v;
		}
		int root = findRoot(parent);
		roots[v] = root; // 경로 압축
		weightDiff[v] += weightDiff[parent];
		return root;
	}
}
