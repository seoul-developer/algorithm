import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int MOD = 1_000_003; // 1,000,003

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 가수의 수 (1000)
		int M = Integer.parseInt(st.nextToken()); // PD의 수 (100)

		List<List<Integer>> orders = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			List<Integer> order = new ArrayList<>();
			for (int it = 0; it < cnt; it++) {
				order.add(Integer.parseInt(st.nextToken()));
			}

			orders.add(order);
		}

		int[] indegree = new int[N + 1];

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (List<Integer> order : orders) {
			for (int i = 0; i < order.size() - 1; i++) {
				int e1 = order.get(i);
				int e2 = order.get(i + 1);

				indegree[e2]++;
				graph.get(e1).add(e2);
			}
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.print(indegree[i] + " ");
//		}
//		System.out.println();

		Queue<Integer> queue = new LinkedList<>();
		// initialize queue
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		boolean[] visited = new boolean[N + 1];
		List<Integer> ans = new ArrayList<>();

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			visited[curr] = true;
			ans.add(curr);

			List<Integer> nexts = graph.get(curr);
			for (int next : nexts) {
				if (visited[next]) {
					continue;
				}

				indegree[next]--;

				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}

		if (ans.size() < N) {
			System.out.println(0);
			return;
		}

		for (int it : ans) {
			sb.append(it).append("\n");
		}

		System.out.println(sb);
	}
}
