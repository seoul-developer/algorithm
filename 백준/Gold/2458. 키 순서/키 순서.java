import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<List<Integer>> graph = new ArrayList<>();
	static List<List<Integer>> graphRev = new ArrayList<>();

	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 500
		int M = Integer.parseInt(st.nextToken()); // N^2

		// DFS 탐색을 통해 나보다 큰 아이들의 수를 세고, 그래프를 반대방향으로 뒤의 애들을 세러 감
		// 이 두 수를 합쳐서 N-1이면 순위를 알 수 있는 번호임.
		// 그래프를 2개 만들고, 순서를 반대로 해둠.

		// 시간 복잡도
		// 모든 정점 N개에 각각에 대해 2번
		// DFS O(N+M) 인접리스트 사용 시
		// DFS worst case: 완전그래프의 경우에는 O(N^2)
		// O(N(N+M)) or O(N^3) 이지만 다행히 N이 작음!!!

		// initialize graph
		for (int iteration = 0; iteration <= N; iteration++) {
			graph.add(new ArrayList<>());
			graphRev.add(new ArrayList<>());
		}

		for (int iteration = 0; iteration < M; iteration++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graphRev.get(b).add(a);
		}

		int ans = 0;
		for (int startIndex = 1; startIndex <= N; startIndex++) {
			int forwardCnt = dfs(startIndex, graph, new boolean[N + 1]);
			int reverseCnt = dfs(startIndex, graphRev, new boolean[N + 1]);

//			System.out.printf("index: %d, forward: %d, rev: %d %n", startIndex, forwardCnt, reverseCnt);
			if (forwardCnt + reverseCnt == N - 1) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static int dfs(int index, List<List<Integer>> graph, boolean[] visited) {
		visited[index] = true;

		int cnt = 0;
		List<Integer> nexts = graph.get(index);
		for (int next : nexts) {
			if (!visited[next]) {
				cnt += 1 + dfs(next, graph, visited); // next 1명 + 그 뒤에 연결
			}
		}

		return cnt;
	}
}