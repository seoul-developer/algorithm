import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int order = 1;
	static int V;
	static int E;
	static int[] orders;
	static int[] lows;
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();
	static Set<Integer> ans = new HashSet<>();

	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 1만
		E = Integer.parseInt(st.nextToken()); // 10만

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		// dfs로 order 지정
		orders = new int[V + 1];
		lows = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				dfs(i, -1);
			}
		}

		System.out.println(ans.size());
		System.out
				.println(new ArrayList<>(ans).stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	private static int dfs(int index, int parent) {
		visited[index] = true;
		lows[index] = order; // 초기값은 자신의 order
		orders[index] = order;
		order++;

		int childCnt = 0;

		for (int next : graph.get(index)) {
			if (parent == next) {
				continue;
			}

			if (!visited[next]) {
				childCnt++;
				int subLow = dfs(next, index);
				lows[index] = Math.min(lows[index], subLow);

				if (parent != -1 && subLow >= orders[index]) {
					ans.add(index);
				}
			} else {
				lows[index] = Math.min(lows[index], orders[next]);

			}
		}

		if (parent == -1 && childCnt >= 2) {
			ans.add(index);
		}

		return lows[index];
	}
}
