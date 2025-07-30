import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] indexedTree;
	static int ans = 0;
	static int size = 1;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		size = 1;
		while (size < N) {
			size *= 2;
		}
		size *= 2;

		// indexed tree 구성
		indexedTree = new long[size];
		for (int i = 0; i < N; i++) {
			indexedTree[size / 2 + i] = Long.parseLong(br.readLine());
		}

		for (int i = size - 2; i >= 1; i -= 2) {
			indexedTree[i / 2] = indexedTree[i] + indexedTree[i + 1];
		}

//		for (int j = 0; j < size; j++) {
//			System.out.println("index: " + j + ", " + indexedTree[j]);
//		}

		// 명령어 처리
		for (int i = 0; i < M + K; i++) {
			String order = br.readLine();
			st = new StringTokenizer(order);
			int code = Integer.parseInt(st.nextToken());
			int par1 = Integer.parseInt(st.nextToken());
			long par2 = Long.parseLong(st.nextToken());

			execute(code, par1, par2);
//			System.out.printf("code: %d, par1: %d, par2: %d%n", code, par1, par2);

//			for (int j = 0; j < size; j++) {
//				System.out.println("index: " + j + ", " + indexedTree[j]);
//			}
		}
	}

	private static void execute(int code, int par1, long par2) {
		if (code == 1) {
			put(par1, par2);
		}
		if (code == 2) {
			sum(par1, (int) par2);
		}
	}

	private static void put(int par1, long par2) {
		int index = size / 2 + par1 - 1;
		indexedTree[index] = par2;
		// re-calculate inner nodes
		int parentIndex = index / 2;
		while (parentIndex >= 1) {
			indexedTree[parentIndex] = indexedTree[2 * parentIndex] + indexedTree[2 * parentIndex + 1];
			parentIndex /= 2;
		}
	}

	private static void sum(int par1, int par2) {
		int left = size / 2 + par1 - 1;
		int right = size / 2 + par2 - 1;

		long sum = 0;
		// index 짝수 - 왼쪽 자식, 홀수 - 오른쪽 자식
		while (left <= right) {
			if (left % 2 == 1) {
				sum += indexedTree[left];
				left++;
			}
			if (right % 2 == 0) {
				sum += indexedTree[right];
				right--;
			}
			left /= 2;
			right /= 2;
		}

		System.out.println(sum);
	}
}