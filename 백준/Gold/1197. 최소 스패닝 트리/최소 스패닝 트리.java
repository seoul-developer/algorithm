import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 1만
		int E = Integer.parseInt(st.nextToken()); // 10만

		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		List<int[]> edges = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.get(A).add(new int[] { B, C });
			graph.get(B).add(new int[] { A, C });

			edges.add(new int[] { A, B, C });
		}

		Collections.sort(edges, (a, b) -> (a[2] - b[2]));

		int cnt = 0;
		int ans = 0;

		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < edges.size(); i++) {
			if (cnt == V - 1) {
				break;
			}

			int[] edge = edges.get(i);
			int s = edge[0];
			int d = edge[1];
			int weight = edge[2];

			int parS = findParent(s);
			int parD = findParent(d);

			if (parS == parD) {
				continue;
			} else {
				// 스패닝 트리에 추가
				parents[parD] = parS;
				cnt++;
				ans += weight;
			}
		}

		System.out.println(ans);
	}

	private static int findParent(int s) {
		if (parents[s] == s) {
			return s;
		}

		int par = findParent(parents[s]);
		parents[s] = par;
		return par;
	}
}
