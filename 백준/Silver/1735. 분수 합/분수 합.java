import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int up1 = Integer.parseInt(st.nextToken());
		int down1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int up2 = Integer.parseInt(st.nextToken());
		int down2 = Integer.parseInt(st.nextToken());

		// down1, down2의 최소공배수 만들기
		// 최소공배수 = 최대공약수로 해당 수를 나눔
		int gcd = gcd(down1, down2);
		int newDown = (down1 * down2) / gcd;

		// 분자 변환 후 덧셈
		up1 *= (newDown / down1);
		up2 *= (newDown / down2);

		// 기약분수 만들기
		int newUp = up1 + up2;

		int newGcd = gcd(newUp, newDown);
		if (newGcd != 1) {
			newUp /= newGcd;
			newDown /= newGcd;
		}

		System.out.printf("%d %d%n", newUp, newDown);
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
