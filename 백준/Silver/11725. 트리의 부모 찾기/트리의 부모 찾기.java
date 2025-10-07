import java.io.*;
import java.util.*;

public class Main {

	private static final int ROOT = 1;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 10만

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int[] parents = new int[N + 1];

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(ROOT);
		visited[ROOT] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			List<Integer> next = graph.get(curr);
//			System.out.printf("curr: %d, next: %s%n", curr, next.toString());
			for (int it : next) {
				if (visited[it]) {
					continue;
				}

				parents[it] = curr;
				visited[it] = true;
				queue.offer(it);
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}

		System.out.println(sb);
	}
}