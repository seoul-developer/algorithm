import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int MOD = 1_000_003; // 1,000,003

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 교차점 개수 (≤10)
		int S = Integer.parseInt(st.nextToken()) - 1; // 시작점 (0-index)
		int E = Integer.parseInt(st.nextToken()) - 1; // 도착점
		long T = Long.parseLong(st.nextToken()); // 시간 (≤ 1e9)

		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				A[i][j] = input.charAt(j) - '0';
			}
		}

		int MAX = N * 5; // 확장 그래프
		int[][] mat = new int[MAX][MAX]; // u -> v 1분만에 이동할 수 있는 경로의 개수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cost = A[i][j];
				if (cost == 0) {
					continue;
				}

				if (cost == 1) {
					mat[i * 5][j * 5] = (mat[i * 5][j * 5] + 1) % MOD;
				} else {
					// cost 분 -> 확장 노드를 따라가면서 연결
					for (int k = 0; k < cost - 1; k++) {
						mat[i * 5 + k][i * 5 + k + 1] = 1; // 중간 보조 노드 연결
					}
					mat[i * 5 + cost - 1][j * 5] = (mat[i * 5 + cost - 1][j * 5] + 1) % MOD; // 마지막에서 도착점으로
				}
			}
		}

//		for (int i = 0; i < MAX; i++) {
//			for (int j = 0; j < MAX; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}

		long[][] result = martixPower(mat, T, MAX);

		System.out.println(result[S * 5][E * 5] % MOD);
	}

	private static long[][] martixPower(int[][] base, long exp, int size) {
		long[][] res = new long[size][size];
		long[][] mat = new long[size][size];

		for (int i = 0; i < size; i++) {
			res[i][i] = 1; // 단위행렬
			for (int j = 0; j < size; j++) {
				mat[i][j] = base[i][j]; // int -> long 복사
			}
		}

		while (exp > 0) {
			// divide and conquer
			if ((exp & 1) == 1) { //
				res = multiply(res, mat, size);
			}
			mat = multiply(mat, mat, size);
			exp >>= 1;
		}

		return res;
	}

	private static long[][] multiply(long[][] A, long[][] B, int size) {
		long[][] C = new long[size][size];

		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				if (A[i][k] == 0) {
					continue;
				}
				for (int j = 0; j < size; j++) {
					C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
				}
			}
		}

		return C;
	}
}
