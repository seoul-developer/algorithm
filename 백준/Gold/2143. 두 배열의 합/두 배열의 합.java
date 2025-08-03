import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] Atree;
	static int n; // A size
	static long[] Btree;
	static int m; // B size
	static int rootIndex;

	public static void main(String[] args) throws IOException {
		// 입력 받기
		int T = Integer.parseInt(br.readLine()); // 10억
		n = Integer.parseInt(br.readLine()); // 1000
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // -100만~+100만
		}

		m = Integer.parseInt(br.readLine()); // 1000
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken()); // -100만~+100만
		}

		long[] cumA = cumSum(A);
		long[] cumB = cumSum(B);

//		for(long a: cumA) {
//			System.out.println(a);
//		}

//		List<Long> partialA = new ArrayList<>();
		Map<Long, Long> partialA = partialSum(cumA); // O(n^2) 100만
		Map<Long, Long> partialB = partialSum(cumB); // O(m^2) 100만

		long ans = 0;
		for (long aSum : partialA.keySet()) {
			long target = T - aSum;
			long aCnt = partialA.get(aSum);
			long bCnt = partialB.getOrDefault(target, 0L);

			ans += aCnt * bCnt;
		}

		System.out.print(ans);
	}

	private static Map<Long, Long> partialSum(long[] cumSum) {
		Map<Long, Long> partialMap = new HashMap<>();
		for (int r = 1; r < cumSum.length; r++) {
			for (int l = 0; l < r; l++) {
				long partialSum = cumSum[r] - cumSum[l];
				partialMap.put(partialSum, partialMap.getOrDefault(partialSum, 0L) + 1);
			}
		}
		return partialMap;
	}

	private static long[] cumSum(int[] list) {
		long[] cumSum = new long[list.length + 1];
		cumSum[0] = 0;
		cumSum[1] = list[0];
		for (int i = 2; i <= list.length; i++) { // O(n)
			cumSum[i] = cumSum[i - 1] + list[i - 1];
		}
		return cumSum;
	}
}