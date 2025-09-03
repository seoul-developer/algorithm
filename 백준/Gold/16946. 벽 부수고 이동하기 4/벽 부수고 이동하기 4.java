import java.io.*;
import java.util.*;

public class Main {

	static final int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[][] clusterMaps;
	private static String[][] parents;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1000
		int M = Integer.parseInt(st.nextToken()); // 1000

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		// 먼저, 벽이 다 있는 상태로 각자 몇 개로 이동 가능한지를 미리 적어둔 맵 생성 -> BFS
		// 각 벽마다, 인접한 맵에 적힌 글씨 + 1이 답

		clusterMap(N, M, map);

		int[][] ans = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}

				int cnt = 1;
				Set<String> usedParents = new HashSet<>();
				for (int[] dir : dirs) {
					int dx = dir[0];
					int dy = dir[1];

					int nx = i + dx;
					int ny = j + dy;

					if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
						continue;
					}

					if (map[nx][ny] == 0) {
						String parent = parents[nx][ny];
//						System.out.printf("key: %s, useParents: %s%n", parent, usedParents.toString());

						if (usedParents.contains(parent)) {
							continue;
						}

						usedParents.add(parent);
						cnt += clusterMaps[nx][ny];
					}
				}

				ans[i][j] = cnt % 10;
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(parents[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void clusterMap(int N, int M, int[][] map) {
		clusterMaps = new int[N][M];
		parents = new String[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || map[i][j] == 1) {
					continue;
				}

				// start BFS
				Queue<int[]> queue = new LinkedList<>();
				List<int[]> clusters = new ArrayList<>();
				queue.offer(new int[] { i, j, 1 });
				visited[i][j] = true;

				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					int x = curr[0];
					int y = curr[1];
					int cnt = curr[2];

					clusters.add(new int[] { x, y });

					for (int[] dir : dirs) {
						int dx = dir[0];
						int dy = dir[1];

						int nx = x + dx;
						int ny = y + dy;

						if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
							continue;
						}

						if (visited[nx][ny] || map[nx][ny] == 1) {
							continue;
						}

						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny, cnt + 1 });
					}
				}

				int size = clusters.size();
				for (int[] cluster : clusters) {
					int x = cluster[0];
					int y = cluster[1];
					clusterMaps[x][y] = size;
					parents[x][y] = createKey(i, j);
				}
			}
		}
	}

	private static String createKey(int i, int j) {
		return String.format("%d %d", i, j);
	}
}
