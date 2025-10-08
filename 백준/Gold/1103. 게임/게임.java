import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static boolean[][] visited;
	private static char[][] board;
	private static int[][] dp;
	private static boolean infinite = false;
	private static int N;
	private static int M;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		visited = new boolean[N][M];
		int res = dfs(0, 0);

		if (infinite) {
			System.out.println(-1);
			return;
		}

		System.out.println(res);
	}

	private static int dfs(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= M) {
			return 0;
		}

		if (infinite) {
			return -1;
		}

		char b = board[i][j];
		if (b == 'H') {
			return 0;
		}

		if (visited[i][j]) {
			// 왔던 곳을 다시 갈 수 있다면 앞으로 무한루프도 가능
			infinite = true;
			return -1;
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		visited[i][j] = true;

		int step = b - '0';

		int maxMove = 0;

		for (int dir = 0; dir < 4; dir++) {
			int newI = i + dx[dir] * step;
			int newJ = j + dy[dir] * step;
			maxMove = Math.max(maxMove, dfs(newI, newJ) + 1);
		}

		visited[i][j] = false;
		dp[i][j] = maxMove;

		return dp[i][j];
	}
}