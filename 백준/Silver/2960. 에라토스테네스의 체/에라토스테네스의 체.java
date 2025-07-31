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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1000
		int K = Integer.parseInt(st.nextToken()); // 1000

		int cnt = 0;
		int val = 0;
		boolean[] checked = new boolean[N + 1];
		Arrays.fill(checked, false);

		// O(NlogN)
		loop: for (int i = 2; i <= N; i++) { // O(N)
			if (checked[i] == false) {
				checked[i] = true;
				cnt++;
				val = i;
//				System.out.println("erase " + val);

				if (cnt == K) {
					break loop;
				}
				int index = 2 * i;
				while (index <= N) { // O(logN)
//					System.out.println("index " + index);
					if (checked[index] == false) {
						checked[index] = true;
						cnt++;
						val = index;
//						System.out.println("erase " + val);

						if (cnt == K) {
							break loop;
						}
					}
					index += i;
				}
			}

		}

		System.out.println(val);
	}
}
