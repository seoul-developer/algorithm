import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		boolean[] isPrime = prime();
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			int a = 3, b = n - a;
			for (int i = 3; i < n / 2; i += 2) {
				if (isPrime[i] && isPrime[n - i]) {
					a = i;
					b = n - i;
					break;
				}
			}

			sb.append(n).append(" = ").append(String.valueOf(a)).append(" + ").append(String.valueOf(b)).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static boolean[] prime() {
		int N = 1_000_000;

		boolean[] isPrime = new boolean[N + 1];
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

		return isPrime;
	}
}
