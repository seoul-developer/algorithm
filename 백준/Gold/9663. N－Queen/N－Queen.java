import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		int[] location = new int[N];

		dfs(location, 0);

		System.out.println(ans);
	}

	public static void dfs(int[] location, int row) {
		if (row == N) {
			ans++;
		}

		for (int col = 0; col < N; col++) {
			if (isValid(location, row, col)) {
				location[row] = col;
				dfs(location, row + 1);
			}
		}
	}

	public static boolean isValid(int[] location, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (location[i] == col || Math.abs(location[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

}