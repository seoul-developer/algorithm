import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		long[] zeros = new long[41];
		long[] ones = new long[41];

		zeros[0] = 1;
		zeros[1] = 0;
		ones[0] = 0;
		ones[1] = 1;

		for (int i = 2; i <= 40; i++) {
			zeros[i] = zeros[i - 1] + zeros[i - 2];
			ones[i] = ones[i - 1] + ones[i - 2];
		}

		for (int it = 0; it < T; it++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(zeros[N]).append(" ").append(ones[N]).append("\n");
		}
		
		System.out.print(sb);
	}
}