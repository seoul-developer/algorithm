import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<int[]> edges = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new int[] { a, b, c });
		}

		int res = 0;
		int cnt = 0;

		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		Collections.sort(edges, (a, b) -> a[2] - b[2]);

		for (int[] edge : edges) {
			if (cnt == V - 1) {
				break;
			}

			int a = edge[0];
			int b = edge[1];
			int w = edge[2];

			int parentA = findParent(a);
			int parentB = findParent(b);
			if (parentA == parentB) {
				continue;
			} else {
				res += w;
				cnt++;
				parents[parentB] = parentA;
			}
		}

		System.out.println(res);
	}

	private static int findParent(int v) {
		if (parents[v] == v) {
			return v;
		}
		int parent = findParent(parents[v]);
		parents[v] = parent;
		return parent;
	}
}