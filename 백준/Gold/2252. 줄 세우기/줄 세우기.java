import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 3만2천
		int M = Integer.parseInt(st.nextToken()); // 10만

		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			indegree[B]++;
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.printf("N=%d %s%n", i, graph.get(i));
//		}

		StringBuilder sb = new StringBuilder();

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int v = 1; v <= N; v++) {
			if (indegree[v] == 0) {
				queue.offer(v);
			}
		}

		while (!queue.isEmpty()) {
			int v = queue.poll();
			sb.append(v).append(" ");
			for (int adj : graph.get(v)) {
				indegree[adj]--;
				if (indegree[adj] == 0) {
					queue.offer(adj);
				}
			}
		}

		System.out.println(sb);
	}
}