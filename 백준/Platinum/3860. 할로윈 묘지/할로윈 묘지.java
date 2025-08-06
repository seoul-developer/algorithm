import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] roots;
	static int H;
	static int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String args[]) throws Exception {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input.equals("0")) {
				continue;
			}

			if (input.equals("0 0")) {
				break;
			}

			st = new StringTokenizer(input);
			int W = Integer.parseInt(st.nextToken()); // 30
			H = Integer.parseInt(st.nextToken()); // 30

			// 묘비
			int G = Integer.parseInt(br.readLine());
//			List<int[]> graveStones = new ArrayList<>();
			Set<Integer> graveStones = new HashSet<>();
			for (int i = 0; i < G; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

//				graveStones.add(new int[] { X, Y });
				graveStones.add(createKey(X, Y));
			}

			// 귀신구멍
			int E = Integer.parseInt(br.readLine());
			List<int[]> ghosts = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int X1 = Integer.parseInt(st.nextToken());
				int Y1 = Integer.parseInt(st.nextToken());
				int X2 = Integer.parseInt(st.nextToken());
				int Y2 = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken()); // -1만~1만

				ghosts.add(new int[] { X1, Y1, X2, Y2, T });
			}

			Object ans = fastestTime(W, H, graveStones, ghosts);
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

	private static Object fastestTime(int w, int h, Set<Integer> graveStones, List<int[]> ghosts) {
		List<List<int[]>> graph = new ArrayList<>();

		// 그래프에 존재하는 노드만 추리기 (묘비 제거)
		for (int i = 0; i < w * h; i++) {
			graph.add(new ArrayList<>());
		}

		Set<Integer> ghostEntrances = new HashSet<>();
		for (int[] ghost : ghosts) {
			int key = createKey(ghost[0], ghost[1]);
			ghostEntrances.add(key);
		}

		// 일반적인 연결 (1초) O(wh)
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int curr = createKey(i, j);

				if (i == w - 1 && j == h - 1) {
					continue;
				}

				if (graveStones.contains(curr)) {
					continue;
				}

				if (ghostEntrances.contains(curr)) {
					continue;
				}

				// (i,j)로부터 연결된 다른 노드들의 key, 거리
				List<int[]> nexts = graph.get(curr);

				for (int[] dir : directions) {
					int x = i + dir[0];
					int y = j + dir[1];

					if (x < 0 || x >= w || y < 0 || y >= h)
						continue;

					int next = createKey(x, y);

					if (graveStones.contains(next)) {
						continue;
					}
					// 그래프에 존재하는 노드인 경우에만 1을 간선으로 연결
					nexts.add(new int[] { next, 1 });
				}
			}
		}

		// 귀신구멍 연결
		for (int[] ghost : ghosts) {
			int X1 = ghost[0];
			int Y1 = ghost[1];
			int start = createKey(X1, Y1);

			int X2 = ghost[2];
			int Y2 = ghost[3];
			int end = createKey(X2, Y2);

			int T = ghost[4];

			List<int[]> nexts = graph.get(start);
			nexts.add(new int[] { end, T });
		}

		// 벨만-포드 알고리즘
		int K = graph.size();

		long[][] shortest = new long[2][K];
		int startIndex = createKey(0, 0);

		for (int v = 0; v < K; v++) {
			if (v == startIndex) {
				shortest[0][startIndex] = 0;
			} else {
				shortest[0][v] = Long.MAX_VALUE;
			}
		}

		for (int it = 1; it <= K; it++) {
			for (int v = 0; v < K; v++) {
				shortest[1][v] = shortest[0][v];
			}

			for (int v = 0; v < K; v++) { // O(Edges)
				if (shortest[1][v] != Long.MAX_VALUE) {
					// 이 정점에 속하는 edge를 모두 순회하면서 값 최소로 업데이트

					List<int[]> nexts = graph.get(v);

					if (nexts.isEmpty()) {
						continue;
					}

					for (int[] next : nexts) {
						int nextIndex = next[0];
						int nextTime = next[1];

						shortest[1][nextIndex] = Math.min(shortest[1][nextIndex], shortest[1][v] + nextTime);
					}
				}
			}

			if (it != K) {
				for (int v = 0; v < K; v++) {
					shortest[0][v] = shortest[1][v];
				}
			}
		}

//		for (int k = 0; k < 2; k++) {
//			for (int v = 0; v < K; v++) {
//				System.out.print(shortest[k][v] + " ");
//			}
//			System.out.println();
//		}

		// 음수 사이클이 있는 경우 Never 반환
		for (int v = 0; v < K; v++) {
			if (shortest[0][v] != shortest[1][v]) {
				return "Never";
			}
		}

		// 출구를 나갈 수 없는 경우 impossible 반환
		int endIndex = createKey(w - 1, h - 1);
		if (shortest[1][endIndex] == Long.MAX_VALUE) {
			return "Impossible";
		}

		return shortest[1][endIndex];
	}

	private static int createKey(int i, int j) {
		return i * H + j;
	}
}
