import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 1000만
		List<Integer> primes = prime(); // O(root N * N)

//		for (int prime : primes) {
//			System.out.println(prime);
//		}

		StringBuilder sb = new StringBuilder();
		for (int primeNumber : primes) {
			while (N % primeNumber == 0) {
				// 나누어 떨어지면 소인수에 추가
				sb.append(primeNumber).append("\n");
				N /= primeNumber;
			}
		}

		if (N > 1) {
			sb.append(N).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static List<Integer> prime() {
		int N = 1_000_000;

		boolean[] isPrime = new boolean[N + 1];
		List<Integer> primes = new ArrayList<>();
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		// O(root N)
		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = 2 * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (isPrime[i])
				primes.add(i);
		}

		return primes;
	}
}
