import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> nodes = new ArrayList<>();
	static int[] indexedTree;
	static int rootIndex;

	public static void main(String[] args) throws IOException {
		// n 10만
		// 정수 A B C
		// A = 1: 사탕을 꺼냄, B = 꺼낼 사탕의 순위 100만
		// A = 2: 사탕을 넣음, B = 사탕의 맛, C = 사탕의 개수 (음수면 뺌)
		// 사탕의 총 개수 20억 (int)
		// 완전탐색 시 10만 * 100만 = 1000억 = 1000초 (시간 초과)
		// indexed tree = 각 맛 별 사탕의 개수

        int size = calculateSize(1_000_000);
		rootIndex = size;
		size *= 2;
		indexedTree = new int[size];

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == 1) {
				int taste = remove(B);
				sb.append(taste).append("\n");
			}
			if (A == 2) {
				int C = Integer.parseInt(st.nextToken());
				insert(B, C);
			}

//			for (int j = 1; j < indexedTree.length; j++) {
//				System.out.printf("index: %d, value: %d%n", j, indexedTree[j]);
//			}
		}

		System.out.println(sb);
	}

	private static int calculateSize(int rootSize) {
		int size = 1;
		while (size < rootSize) {
			size *= 2;
		}
		return size;
	}

	private static void insert(int b, int c) {
		// b맛의 사탕을 c개 넣음, c가 음수인 경우에는 뺌
		int index = rootIndex + b - 1;
		indexedTree[index] += c;
		// re calculate
		index = index / 2;
		while (index >= 1) {
			indexedTree[index] = indexedTree[2 * index] + indexedTree[2 * index + 1];
			index = index / 2;
		}
	}

	private static int remove(int b) {
		// b번째 사탕을 찾아서 1개 꺼냄
		int index = 1;
		int target = b;

//		if (indexedTree[index] < b) {
//			// 사탕 못찾음 -> 문제에서 이런 경우는 없다고 한건가?
//		}

		// 트리 순회하며 찾기
		while (index < rootIndex) {
			int leftIndex = index * 2;
			int rightIndex = index * 2 + 1;

			int leftValue = indexedTree[leftIndex];
			if (leftValue >= target) {
				// 왼쪽 트리로 이동
				index = leftIndex;

			} else {
				// 오른쪽 트리로 이동
				index = rightIndex;
				target -= leftValue;
			}
		}

		int taste = index - rootIndex + 1;

		// update tree
		indexedTree[index]--;
		int currIndex = index / 2;
		while (currIndex >= 1) {
			indexedTree[currIndex] = indexedTree[2 * currIndex] + indexedTree[2 * currIndex + 1];
			currIndex /= 2;
		}

		return taste;
	}
}