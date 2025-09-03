import java.io.*;
import java.util.*;

public class Main {

	static final int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1000
		int M = Integer.parseInt(st.nextToken()); // 1000

		int[][] map = new int[N + 1][M + 1];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i + 1][j + 1] = input.charAt(j) - '0';
			}
		}

		// 0 - 이동 가능 / 1 - 이동 불가능 (벽)
		// (1,1) -> (N,M)
		// 벽 1개 부수기 가능 -> 최단 경로

		boolean[][][] visited = new boolean[N + 1][M + 1][2];
		// visited[x][y][0] = 벽 안 부순 상태
		// visited[x][y][1] = 벽 부순 상태

		Queue<Bfs> queue = new LinkedList<>();
		queue.offer(new Bfs(1, 1, 1, false));
		visited[1][1][0] = true;

		while (!queue.isEmpty()) {
			Bfs curr = queue.poll();
			int x = curr.x;
			int y = curr.y;
			int dist = curr.dist;
			boolean broken = curr.broken;

			if (x == N && y == M) {
				System.out.println(dist);
				return;
			}

			for (int[] dir : dirs) {
				int dx = dir[0];
				int dy = dir[1];

				int newX = x + dx;
				int newY = y + dy;

				if (newX <= 0 || newX >= N + 1 || newY <= 0 || newY >= M + 1) {
					continue;
				}

				// 이동할 곳이 빈칸
				if (map[newX][newY] == 0) {
					int flag = broken ? 1 : 0;
					if (visited[newX][newY][flag]) {
						continue;
					}

					visited[newX][newY][flag] = true;
					queue.offer(new Bfs(newX, newY, dist + 1, broken));
				}

				// 이동할 곳이 벽이고, 아직 안 부순 경우
				if (map[newX][newY] == 1 && !broken) {
					if (visited[newX][newY][1]) {
						continue;
					}

					visited[newX][newY][1] = true;
					queue.offer(new Bfs(newX, newY, dist + 1, true));
				}
			}
		}
		System.out.println(-1);
	}
}

class Bfs {

	int x, y;
	int dist;
	boolean broken;

	public Bfs(int x, int y, int dist, boolean broken) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.broken = broken;
	}
}