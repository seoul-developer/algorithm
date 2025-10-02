import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 100
		int M = Integer.parseInt(br.readLine());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			cnt++;

			for (int next : graph.get(curr)) {
				if (visited[next]) {
					continue;
				}

				visited[next] = true;
				queue.offer(next);
			}
		}

		System.out.println(cnt - 1);
	}
}