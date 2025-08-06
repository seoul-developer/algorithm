import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parents;

	public static void main(String[] args) throws IOException {
		// n 100만 집합의 개수: n+1
		// m 10만 연산의 개수

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int code = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (code == 0) {
				// 합집합: a가 포함된 집합 U b가 포함된 집합
				union(a, b);
			}
			if (code == 1) {
				// a, b가 같은 집합에 포함되어 있는지 확인
				if (parent(a) == parent(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		int aRoot = parent(a);
		int bRoot = parent(b);

		if (aRoot == bRoot) {
			return;
		}

		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
	}

	private static int parent(int val) {
		if (parents[val] != val) {
			parents[val] = parent(parents[val]);
		}

		return parents[val];
	}
}