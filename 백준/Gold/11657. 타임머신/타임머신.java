import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<List<int[]>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 500
		int M = Integer.parseInt(st.nextToken()); // 6000

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // -1만 ~ 1만

			graph.get(A).add(new int[] { B, C });
		}

		// 음수 가중치 벨만-포드 알고리즘 O(NM) < 1초
		long[][] shortest = new long[N + 1][N + 1];

		for (int v = 1; v <= N; v++) {
			if (v == 1) {
				shortest[0][v] = 0;
			} else {
				shortest[0][v] = Long.MAX_VALUE;
			}
		}

		for (int it = 1; it <= N; it++) { // O(NM)
			// 먼저 이전 거리 복사
			for (int v = 1; v <= N; v++) {
				shortest[it][v] = shortest[it - 1][v];
			}

			// 간선 갱신은 오직 it-1 거리만 참조
			for (int v = 1; v <= N; v++) { // 내부 실행은 총 edge 수 만큼이므로 O(M)
				if (shortest[it - 1][v] != Long.MAX_VALUE) {
					List<int[]> edges = graph.get(v);
					for (int[] edge : edges) {
						int start = v;
						int end = edge[0];
						int weight = edge[1];

						long val1 = shortest[it][end];
						long val2 = shortest[it][start] + weight;

//						System.out.printf("%d -> %d, w: %d, val1: %d vs val2: %d %n", start, end, weight, val1, val2);
						shortest[it][end] = Math.min(val1, val2);
					}
				}
			}
		}

//		for (int it = 1; it <= N; it++) {
//			for (int v = 1; v <= N; v++) {
//				System.out.print(shortest[it][v] + " ");
//			}
//			System.out.println();
//		}

		for (int v = 1; v <= N; v++) {
			if (shortest[N - 1][v] != shortest[N][v]) {
				System.out.println(-1);
				return;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int v = 2; v <= N; v++) {
			if (shortest[N - 1][v] == Long.MAX_VALUE) {
				sb.append(-1).append("\n");
				continue;
			}
			sb.append(shortest[N - 1][v]).append("\n");
		}

		System.out.println(sb);
	}
}
