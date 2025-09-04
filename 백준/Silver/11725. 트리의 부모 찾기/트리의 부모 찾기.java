import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int it = 0; it < N - 1; it++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int root = 1;

		int[] parents = new int[N + 1];

		boolean[] visited = new boolean[N + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 1, -1 });
		visited[1] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int idx = curr[0];
			int parent = curr[1];

			parents[idx] = parent;

			for (int next : graph.get(idx)) {
				if (visited[next]) {
					continue;
				}

				visited[next] = true;
				queue.offer(new int[] { next, idx });
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}

		System.out.println(sb);
	}
}