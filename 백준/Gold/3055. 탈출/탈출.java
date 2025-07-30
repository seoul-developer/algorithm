import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		String line = br.readLine(); // R, C
		StringTokenizer st = new StringTokenizer(line);

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		int[][] visited = new int[R][C];
		ArrayDeque<Bfs> waterAd = new ArrayDeque<>();

		int[][] watersTime = new int[R][C];
		int startX = 0, startY = 0;

//		System.out.println(R);
//		System.out.println(C);

		for (int i = 0; i < R; i++) {
			String currLine = br.readLine();
			for (int j = 0; j < C; j++) {
				char val = currLine.charAt(j);
				map[i][j] = val;
				watersTime[i][j] = -1;
				visited[i][j] = 0;
				if (val == 'S') { // start
					startX = i;
					startY = j;
				}
				if (val == '*') { // water
					waterAd.add(new Bfs(i, j, 0));
				}
			}
		}
		// 여기까지 성공

		// water 퍼짐 map 미리 만들어놓기
		while (!waterAd.isEmpty()) {
			Bfs curr = waterAd.pollFirst();
			int x = curr.x;
			int y = curr.y;

			if (x < 0 || y < 0 || x >= R || y >= C) {
				continue;
			}

			if (map[x][y] != 'D' && map[x][y] != 'X') {
				int time = watersTime[x][y];
				if (time == -1) {
					watersTime[x][y] = curr.cnt;
					for (int[] dir : directions) {
						waterAd.add(new Bfs(x + dir[0], y + dir[1], curr.cnt + 1));
					}
				}
			}
		}

		// 로깅
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(watersTime[i][j]);
//			}
//			System.out.println();
//		}

		ArrayDeque<Bfs> path = new ArrayDeque<>();
		path.add(new Bfs(startX, startY, 0));

		while (!path.isEmpty()) {
			Bfs curr = path.pollFirst();
			int x = curr.x;
			int y = curr.y;
			int cnt = curr.cnt;

			if (x < 0 || x > R - 1 || y < 0 || y > C - 1) {
				continue;
			}

			if (visited[x][y] != 0) {
				continue;
			}

			visited[x][y] = 1;

			if (map[x][y] == 'D') {
				System.out.println(cnt);
				return;
			}

			if ((map[x][y] == '.' || map[x][y] == 'S') && 
				    (watersTime[x][y] == -1 || cnt < watersTime[x][y])) {
				for (int[] dir : directions) {
					path.add(new Bfs(x + dir[0], y + dir[1], cnt + 1));
				}
			}
		}

		System.out.println("KAKTUS");
	}
}

class Bfs {
	public int x;
	public int y;
	public int cnt;

	public Bfs(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
