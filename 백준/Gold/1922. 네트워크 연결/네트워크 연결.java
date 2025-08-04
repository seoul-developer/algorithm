import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] roots;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 1000
		int M = Integer.parseInt(br.readLine()); // 10만

//		System.out.println(1000 * (1000 - 1) / 2); // N = 1000 -> 499500개의 연결 

		List<int[]> edges = new ArrayList<>();
		StringTokenizer st;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int comA = Integer.parseInt(st.nextToken());
			int comB = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()); // 1만

			if (comA == comB) {
				continue;
			}

			edges.add(new int[] { comA, comB, cost });
		}

		Collections.sort(edges, (a, b) -> (a[2] - b[2]));

		for (int i = 0; i < edges.size(); i++) {
			int[] curr = edges.get(i);
		}

		// 대표자 선정
		roots = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			roots[i] = i;
		}

		long totalCost = 0;
		for (int i = 0; i < edges.size(); i++) {
			int[] curr = edges.get(i);
			int comA = curr[0];
			int comB = curr[1];
			int cost = curr[2];

			int comAroot = findRoot(comA);
			int comBroot = findRoot(comB);

			if (comAroot == comBroot) {
				continue;
			}

			// 연결
			connect(comA, comB, comAroot, comBroot);

			totalCost += cost;
		}

		System.out.println(totalCost);
	}

	private static void connect(int comA, int comB, int comAroot, int comBroot) {
		roots[comA] = comBroot;
		for (int i = 1; i <= roots.length - 1; i++) {
			if (roots[i] == comAroot) {
				roots[i] = comBroot;
			}
		}
	}

	private static int findRoot(int com) {
		if (roots[com] == com) {
			return com;
		}

		int root = findRoot(roots[com]);
		roots[com] = root;

		return root;
	}
}