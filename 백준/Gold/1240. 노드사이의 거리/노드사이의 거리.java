import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static List<List<int[]>> graph;
	private static int N;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 1000

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			graph.get(A).add(new int[] { B, dist });
			graph.get(B).add(new int[] { A, dist });
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());

			sb.append(dist(src, dest)).append("\n");
		}

		System.out.println(sb);
	}

	private static int dist(int src, int dest) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		queue.add(new int[] { src, 0 });
		visited[src] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int node = curr[0];
			int dist = curr[1];

			if (node == dest) {
				return dist;
			}

			for (int[] next : graph.get(node)) {
				if (!visited[next[0]]) {
					visited[next[0]] = true;
					queue.add(new int[] { next[0], next[1] + dist });
				}
			}
		}

		return -1;
	}
}