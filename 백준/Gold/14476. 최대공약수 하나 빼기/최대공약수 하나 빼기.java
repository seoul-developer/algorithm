import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 100만
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 완전탐색 -> 100만*100만(최대공약수 구하기) 시간 초과
		int[] left = new int[N];
		left[0] = nums[0];
		int[] right = new int[N];
		right[N - 1] = nums[N - 1];

		for (int i = 1; i < N; i++) {
			left[i] = gcd(left[i - 1], nums[i]);
		}

		for (int i = N - 2; i >= 0; i--) {
			right[i] = gcd(right[i + 1], nums[i]);
		}
		;

		int[] GCD = new int[N]; // i번째 빼고의 최대공약수
		GCD[0] = right[1];
		GCD[N - 1] = left[N - 2];
		for (int j = 1; j < N - 1; j++) {
			GCD[j] = gcd(left[j - 1], right[j + 1]);
		}

		int max = 1;
		int index = -1;
		for (int j = 0; j < GCD.length; j++) {
			int currGCD = GCD[j];
			if (currGCD > max) {
				max = currGCD;
				index = j;
			}
		}

		if (index == -1) {
			System.out.println(-1);
			return;
		}

		if (nums[index] % max == 0) {
			System.out.println(-1);
			return;
		}

		System.out.printf("%d %d%n", max, nums[index]);
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
