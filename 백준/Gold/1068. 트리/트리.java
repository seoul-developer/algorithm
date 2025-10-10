import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 50
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new HashSet<>());
		}

		int root = -1;
		int[] parents = new int[N];
		for (int node = 0; node < N; node++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = node;
				continue;
			}
			parents[node] = parent;
			graph.get(parent).add(node);
		}

		int deleteNode = Integer.parseInt(br.readLine());

		if (deleteNode == root) {
			System.out.println(0);
			return;
		}

		for (int node = 0; node < N; node++) {
			if (graph.get(node).contains(deleteNode)) {
				graph.get(node).remove(deleteNode);
			}
		}

		parents[deleteNode] = -1;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);

		int answer = 0;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (parents[curr] == -1) {
				continue;
			}

			Set<Integer> nexts = graph.get(curr);
			if (nexts.isEmpty()) {
				answer++;
			}
			for (int next : nexts) {
				queue.offer(next);
			}
		}

		System.out.println(answer);
	}
}
