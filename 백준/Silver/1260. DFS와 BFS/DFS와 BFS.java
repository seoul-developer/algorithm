import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int THRESHOLD = 100000000;
	static boolean[] visited;
	private static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		visited = new boolean[N + 1];
		// DFS
		dfs(V);
		sb.append("\n");

		visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(V);
		visited[V] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");

			for (int next : graph.get(curr)) {
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}

		System.out.println(sb);
	}

	private static void dfs(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		sb.append(v).append(" ");

		List<Integer> next = graph.get(v);
		for (int it : next) {
			dfs(it);
		}
	}
}