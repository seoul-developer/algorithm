import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<List<int[]>> graph = new ArrayList<>();
	static long[] shortestPath;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 2만 다익스트라 N^2 = 4억이지만 PQ로 개선 가능 O(ElogV)
		int E = Integer.parseInt(st.nextToken()); // 30만

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		shortestPath = new long[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(shortestPath, Long.MAX_VALUE);

		int K = Integer.parseInt(br.readLine()); // start index

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new int[] { v, w });
		}

		// initialize
		Queue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

		visited[0] = true;
		shortestPath[K] = 0;
		pq.offer(new long[] { K, 0 });

		while (!pq.isEmpty()) {
			long[] curr = pq.poll();
			int index = (int) curr[0];
			long w = curr[1];

			if (!visited[index]) {
				visited[index] = true;
			} else {
				// 이미 뽑았던 것이면 건너뜀
				continue;
			}

			for (int[] next : graph.get(index)) {
				int nextIndex = next[0];
				int nextW = next[1];

				if (!visited[nextIndex]) {
					shortestPath[nextIndex] = Math.min(shortestPath[nextIndex], w + nextW);
					pq.offer(new long[] { nextIndex, shortestPath[nextIndex] });
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (shortestPath[i] == Long.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(shortestPath[i]).append("\n");
			}
		}

		System.out.println(sb);
	}
}