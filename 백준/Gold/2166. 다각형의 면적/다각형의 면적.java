import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		long[] x = new long[n + 1];
		long[] y = new long[n + 1];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}

		x[n] = x[0];
		y[n] = y[0];

		double sum1 = 0, sum2 = 0;

		for (int i = 0; i < n; i++) {
			sum1 += x[i] * y[i + 1];
			sum2 += y[i] * x[i + 1];
		}

		double res = Math.abs(sum1 - sum2) / 2.0;
		System.out.printf("%.1f", res);
	}
}