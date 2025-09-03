import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static boolean[][][][] visited;
	private static char[][] maps;
	private static int N;
	private static int M;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new char[N][M];
		int[] R = new int[2];
		int[] B = new int[2];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = input.charAt(j);
				if (ch == 'R') {
					R[0] = i;
					R[1] = j;
					ch = '.';
				} else if (ch == 'B') {
					B[0] = i;
					B[1] = j;
					ch = '.';
				}

				maps[i][j] = ch;
			}
		}

		visited = new boolean[N][M][N][M]; // R, B
		System.out.println(bfs(R[0], R[1], B[0], B[1]));
		;
	}

	private static int bfs(int rx, int ry, int bx, int by) {
		Queue<State> queue = new LinkedList<>();
		queue.offer(new State(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = true;

		while (!queue.isEmpty()) {
			State curr = queue.poll();

			if (curr.depth >= 10) {
				continue;
			}

			for (int d = 0; d < 4; d++) {
				// 빨간 구슬 굴리기
				int[] rMove = roll(curr.rx, curr.ry, dx[d], dy[d]);
				int nrx = rMove[0], nry = rMove[1], rDist = rMove[2];

				// 파란 구슬 굴리기
				int[] bMove = roll(curr.bx, curr.by, dx[d], dy[d]);
				int nbx = bMove[0], nby = bMove[1], bDist = bMove[2];

				// 파란 구슬이 구멍에 빠진 경우 실패
				if (maps[nbx][nby] == 'O') {
					continue;
				}

				if (maps[nrx][nry] == 'O') {
					return curr.depth + 1;
				}

				// 두 구슬이 같은 칸에 도착 -> 더 많이 이동한 구슬을 한 칸 뒤로
				if (nrx == nbx && nry == nby) {
					if (rDist > bDist) {
						nrx -= dx[d];
						nry -= dy[d];
					} else {
						nbx -= dx[d];
						nby -= dy[d];
					}
				}

				if (!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					queue.offer(new State(nrx, nry, nbx, nby, curr.depth + 1));
				}
			}
		}

		return -1;
	}

	private static int[] roll(int x, int y, int dx, int dy) {
		// 구슬을 한 방향으로 굴려서 최종 위치와 이동 거리 반환
		int dist = 0;
		while (maps[x + dx][y + dy] != '#' && maps[x][y] != 'O') {
			x += dx;
			y += dy;
			dist++;

			if (maps[x][y] == 'O') {
				break;
			}
		}
		return new int[] { x, y, dist };
	}
}

class State {

	int rx, ry, bx, by, depth;

	State(int rx, int ry, int bx, int by, int depth) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.depth = depth;
	}
}