import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;
	private static boolean[] done;
	private static int cnt = 0;
	private static int[] inputs;
	private static int n;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			inputs = new int[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}

			int res = exec(n, inputs);
			sb.append(res).append("\n");
		}

		System.out.println(sb);
	}

	private static int exec(int n, int[] inputs) {
		visited = new boolean[n + 1];
		done = new boolean[n + 1];
		cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		return n - cnt;
	}

	private static void dfs(int x) {
		visited[x] = true;
		int next = inputs[x];

		if (!visited[next]) {
			dfs(next);
		} else {
			// 방문은 했었는데, 끝나지는 않은 상태 -> 사이클 발견
			if (!done[next]) {
				cnt++;

				for (int i = next; i != x; i = inputs[i]) {
					cnt++;
				}
			}
		}

		done[x] = true;
	}
}