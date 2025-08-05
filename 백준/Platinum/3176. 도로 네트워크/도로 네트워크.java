import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<List<int[]>> graph = new ArrayList<>(); // destination, length
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int K;
	static int[] depth;
	static int[][] parents;
	static int[][] mins;
	static int[][] maxs;

	public static void main(String args[]) throws Exception {
		N = Integer.parseInt(br.readLine()); // 10만

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 100만

			graph.get(A).add(new int[] { B, C });
			graph.get(B).add(new int[] { A, C });
		}

		// parents, min, max 배열 만들기
		int size = 1;
		while ((1 << size) <= N) {
			size++;
		}
		K = size;
		// size = 3
		depth = new int[N + 1];
		parents = new int[size + 1][N + 1];
		mins = new int[size + 1][N + 1];
		maxs = new int[size + 1][N + 1];

		// bfs를 통해서 parents, min, max k=0 row 채우기
		bfs();

		// DP 통해 parents, min, max 채우기
		for (int k = 1; k <= K; k++) {
			for (int v = 1; v <= N; v++) {
				parents[k][v] = parents[k - 1][parents[k - 1][v]];
				mins[k][v] = Math.min(mins[k - 1][v], mins[k - 1][parents[k - 1][v]]);
				maxs[k][v] = Math.max(maxs[k - 1][v], maxs[k - 1][parents[k - 1][v]]);
			}
		}

		// 문제 풀기
		int K = Integer.parseInt(br.readLine()); // 10만
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int LCA = LCA(D, E);
			int[] minmaxD = calculateMinMax(LCA, D);
			int[] minmaxE = calculateMinMax(LCA, E);

			int min = Math.min(minmaxD[0], minmaxE[0]);
			int max = Math.max(minmaxD[1], minmaxE[1]);

			sb.append(min).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int[] calculateMinMax(int v1, int v2) {
		// 항상 v1이 LCA이므로 v2가 더 깊이 있음

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = K; i >= 0; i--) {
			if (depth[v2] - depth[v1] >= (1 << i)) {
				min = Math.min(min, mins[i][v2]);
				max = Math.max(max, maxs[i][v2]);
				v2 = parents[i][v2];
			}
		}

		return new int[] { min, max };
	}

	private static int LCA(int x, int y) {
		if (depth[x] > depth[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		// y가 더 아래 있음

		// 1. 높이 맞추기
		for (int i = K; i >= 0; i--) {
			if (depth[y] - depth[x] >= (1 << i)) {
				y = parents[i][y];
			}
		}

		if (x == y) {
			return x;
		}

		// 2. 조상이 같기 직전까지 둘 다 함께 상승
		for (int i = K; i >= 0; i--) {
			if (parents[i][x] != parents[i][y]) {
				x = parents[i][x];
				y = parents[i][y];
			}
		}

		return parents[0][x];
	}

	private static void bfs() {
		final int rootIndex = 1;

		// index, depth
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		visited[rootIndex] = true;
		queue.offer(new int[] { rootIndex, 0 });

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int index = curr[0];
			int currDepth = curr[1];

			List<int[]> nexts = graph.get(index);
			for (int[] next : nexts) {
				int nextIndex = next[0];
				int nextLength = next[1];

				if (visited[nextIndex] == false) {
					visited[nextIndex] = true;

					depth[nextIndex] = currDepth + 1;
					parents[0][nextIndex] = index;
					mins[0][nextIndex] = nextLength;
					maxs[0][nextIndex] = nextLength;

					queue.offer(new int[] { nextIndex, currDepth + 1 });
				}
			}
		}
	}
}
