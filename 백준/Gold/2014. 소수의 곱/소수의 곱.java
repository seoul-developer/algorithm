import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] tree;
	static int rootIndex;
	static long LIMIT = (long) Math.pow(2, 31);

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 100
		int N = Integer.parseInt(st.nextToken()); // 10만

		long[] primes = new long[K];
		PriorityQueue<Long> minHeap = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			long val = Long.parseLong(st.nextToken());
			primes[i] = val;
			minHeap.offer(val); // 541
		}

		for (int i = 0; i < N - 1; i++) {
			long curr = minHeap.poll();
			for (long p : primes) {
				if (curr > LIMIT / p) {
					break;
				}
				long next = curr * p;
				minHeap.offer(next);
				if (curr % p == 0) {
					break;
				}
			}
		}

		System.out.println(minHeap.poll());
	}

}
