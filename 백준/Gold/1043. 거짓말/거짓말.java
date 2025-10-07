import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int truthCnt = Integer.parseInt(st.nextToken());
		int[] truth = new int[truthCnt];
		for (int i = 0; i < truthCnt; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}

		List<int[]> parties = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partyCnt = Integer.parseInt(st.nextToken());
			int[] party = new int[partyCnt];
			for (int j = 0; j < partyCnt; j++) {
				party[j] = Integer.parseInt(st.nextToken());
			}
			parties.add(party);

			// 같은파티 사람들끼리 union
			for (int j = 1; j < partyCnt; j++) {
				union(party[0], party[j]);
			}
		}

		Set<Integer> truthRoots = new HashSet<>();
		for (int t : truth) {
			truthRoots.add(findParent(t));
		}
		int res = 0;
		for (int[] p : parties) {
			boolean canLie = true;
			for (int person : p) {
				if (truthRoots.contains(findParent(person))) {
					canLie = false;
					break;
				}
			}

			if (canLie) {
				res++;
			}
		}

		System.out.println(res);
	}

	private static void union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);

		if (parentA != parentB) {
			parents[parentB] = parentA;
		}
	}

	private static int findParent(int a) {
		if (parents[a] == a) {
			return a;
		}
		int parent = findParent(parents[a]);
		parents[a] = parent;
		return parent;
	}
}