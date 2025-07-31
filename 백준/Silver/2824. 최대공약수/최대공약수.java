import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] isPrime;
	static List<Integer> primes = new ArrayList<>();
	static Map<Integer, Integer> A_primes = new HashMap<>();
	static Map<Integer, Integer> B_primes = new HashMap<>();

	static int CONST = (int) Math.sqrt(1_000_000_000);

	public static void main(String[] args) throws IOException {
		calculatePrime(CONST);

		// A input
		int N = Integer.parseInt(br.readLine()); // 1000

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			parse(val, "A");
		}

		// B input
		int M = Integer.parseInt(br.readLine()); // 1000

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int val = Integer.parseInt(st.nextToken());
			parse(val, "B");
		}

		BigInteger ans = BigInteger.ONE;

		Set<Integer> allPrimes = new HashSet<>();
		allPrimes.addAll(A_primes.keySet());
		allPrimes.addAll(B_primes.keySet());

		for (int p : allPrimes) {
			int pow = Math.min(A_primes.getOrDefault(p, 0), B_primes.getOrDefault(p, 0));
			if (pow > 0) {
				ans = ans.multiply(BigInteger.valueOf(p).pow(pow));
			}
		}

		StringBuilder sb = new StringBuilder();
		int length = String.valueOf(ans).length();
		if (length >= 9) {
			BigInteger newAns = ans.mod(BigInteger.valueOf(1_000_000_000));
			for (int i = 0; i < 9 - String.valueOf(newAns).length(); i++) {
				sb.append("0");
			}

			sb.append(newAns.toString());
		} else {
			sb.append(ans.toString());
		}
		System.out.println(sb.toString());
	}

	// 소인수분해
	private static void parse(int val, String type) {
		// type: A or B
		for (int primeNumber : primes) {
			while (val % primeNumber == 0) {
				if (type.equals("A")) {
					A_primes.put(primeNumber, A_primes.getOrDefault(primeNumber, 0) + 1);
				} else if (type.equals("B")) {
					B_primes.put(primeNumber, B_primes.getOrDefault(primeNumber, 0) + 1);
				}
				val /= primeNumber;
			}
		}
		if (val > 1) {
			if (type.equals("A")) {
				A_primes.put(val, A_primes.getOrDefault(val, 0) + 1);
			} else if (type.equals("B")) {
				B_primes.put(val, B_primes.getOrDefault(val, 0) + 1);
			}
		}
	}

	private static void calculatePrime(int N) {
		isPrime = new boolean[N + 1];
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
	}
}
