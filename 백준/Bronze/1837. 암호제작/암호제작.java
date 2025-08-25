import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int THRESHOLD = 10_000_000; // K

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger P = new BigInteger(st.nextToken());// 개큼
		int K = Integer.parseInt(st.nextToken()); // 10^6

		List<Integer> primes = primes(THRESHOLD);
		for (int prime : primes) {
			if (P.mod(BigInteger.valueOf(prime)).equals(BigInteger.ZERO) && prime < K) {
				System.out.println("BAD " + prime);
				return;
			}
		}
		System.out.println("GOOD");
	}

	private static List<Integer> primes(int threshold) {
		List<Integer> primes = new ArrayList<>();
		boolean[] isPrime = new boolean[threshold + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i * i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}

		return primes;
	}
}
