import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> tree = new ArrayList<>();
	static int[] depth;
	static int[][] parents;
	static int K;

	public static void main(String[] args) throws IOException {
		// 입력 받기
		int N = Integer.parseInt(br.readLine()); // 10만

		StringTokenizer st;
		List<int[]> edges = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			edges.add(new int[] { v1, v2 });
		}

		int M = Integer.parseInt(br.readLine()); // 10만

		List<int[]> queries = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			queries.add(new int[] { v1, v2 });
		}

		// 트리 구성
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];

			tree.get(v1).add(v2);
			tree.get(v2).add(v1);
		}

		// bfs로 depth, parent 설정
		final int root = 1;
		depth = new int[N + 1];
		int k = 1;
		while ((1 << k) <= N) {
			k++;
		}
		K = k;
		parents = new int[K + 1][N + 1];

		bfs(N, root); // O(N)

		// DP parents
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				int mid = parents[i - 1][j];
				if (mid != 0) {
					parents[i][j] = parents[i - 1][mid];
				}
			}
		}

//		for (int i = 0; i <= K; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(parents[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < M; i++) {
			int[] query = queries.get(i);
			int v1 = query[0];
			int v2 = query[1];

			int LCA = findLCA(v1, v2);
			sb.append(LCA).append("\n");
		}

		System.out.println(sb);
	}

	private static int findLCA(int x, int y) {
		// 항상 y가 더 깊이 있게 됨
		if (depth[x] > depth[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		// x,y의 높이를 같게 맞춤
		for (int i = K; i >= 0; i--) {
			if (depth[y] - depth[x] >= (1 << i)) { // 2^i
				y = parents[i][y];
			}
		}

		if (x == y) {
			return x;
		}

		for (int i = K; i >= 0; i--) {
			if (parents[i][x] != parents[i][y]) {
				x = parents[i][x];
				y = parents[i][y];
			}
		}

		return parents[0][x];
	}

	private static void bfs(int N, final int root) {
		boolean[] visited = new boolean[N + 1];
		Queue<Bfs> queue = new LinkedList<>();
		visited[root] = true;
		queue.offer(new Bfs(1, 0, 0));

		while (!queue.isEmpty()) {
			Bfs curr = queue.poll();
			depth[curr.index] = curr.depth;
			parents[0][curr.index] = curr.parent;

			List<Integer> nexts = tree.get(curr.index);
			for (int next : nexts) {
				if (visited[next] == false) {
					visited[next] = true;
					queue.offer(new Bfs(next, curr.index, curr.depth + 1));
				}
			}
		}
	}

//	private static int findLCA(int x, int y) {
//		// x, y의 높이 맞추기 (depth)
//		// x를 더 깊은 아이로 맞추기
//		if (depth[x] > depth[y]) {
//			int tmp = y;
//			y = x;
//			x = tmp;
//		}
//
//		// y의 depth가 x의 depth와 같아질 때까지 y를 끌어올림 => 높이 맞추기
//		for (int i = K; i >= 0; i--) {
//			if (depth[y] - depth[x] >= Math.pow(2, i)) {
//				y = parents[i][y];
//			}
//		}
//
//		// 동일한 높이가 되었을 때, x==y라면 그것이 LCA
//		if (x == y) {
//			return x;
//		}
//
//		// x,y가 같지 않다면, 루트에서부터 처음으로 조사잉 같지 않은 지점을 만날 때까지 탐색
//		// 처음으로 달라진 위치에서 그들의 부모 중 공통 조상을 다시 찾음
//		for (int i = K; i >= 0; i--) {
//			if (parents[i][x] != parents[i][y]) {
//				x = parents[i][x];
//				y = parents[i][y];
//			}
//		}
//		return parents[0][x];
//	}
}

class Bfs {
	int index;
	int parent;
	int depth;

	public Bfs(int index, int parent, int depth) {
		this.index = index;
		this.parent = parent;
		this.depth = depth;
	}
}