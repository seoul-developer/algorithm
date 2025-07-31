import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 400만

		List<Integer> prime = prime(N);
//		int[] cumPrimes = calculateCumPrimes(prime);

		int l = 0, r = 0, sum = 0, count = 0;

		while (true) {
			if (sum >= N) {
				if (sum == N)
					count++;
				sum -= prime.get(l);
				l++;
			} else {
				if (r == prime.size())
					break;
				sum += prime.get(r);
				r++;
			}
		}

		System.out.println(count);
	}

	private static List<Integer> prime(int N) {
		List<Integer> primes = new ArrayList<>();
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
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
