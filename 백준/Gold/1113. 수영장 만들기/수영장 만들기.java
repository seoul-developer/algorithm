import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		System.out.println(simulate());
	}

	private static int simulate() {
		PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.h - b.h);

		for (int i = 0; i < N; i++) {
			queue.offer(new Cell(i, 0, map[i][0]));
			queue.offer(new Cell(i, M - 1, map[i][M - 1]));

			visited[i][0] = true;
			visited[i][M - 1] = true;
		}

		for (int j = 0; j < M; j++) {
			queue.offer(new Cell(0, j, map[0][j]));
			queue.offer(new Cell(N - 1, j, map[N - 1][j]));

			visited[0][j] = true;
			visited[N - 1][j] = true;
		}

		int totalWater = 0;

		while (!queue.isEmpty()) {
			Cell curr = queue.poll();

			for (int d = 0; d < 4; d++) {
				int newX = curr.x + dx[d];
				int newY = curr.y + dy[d];

				if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
					continue;
				}

				if (visited[newX][newY]) {
					continue;
				}

				visited[newX][newY] = true;

				if (map[newX][newY] < curr.h) {
					totalWater += curr.h - map[newX][newY];
					map[newX][newY] = curr.h;
				}

				queue.add(new Cell(newX, newY, map[newX][newY]));
			}
		}

		return totalWater;
	}
}

class Cell {
	int x, y, h;

	public Cell(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
}
