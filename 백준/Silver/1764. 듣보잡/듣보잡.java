import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<Integer> S = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 50만
		int M = Integer.parseInt(st.nextToken()); // 50만

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		List<String> ans = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (set.contains(input)) {
				ans.add(input);
			}
		}

		Collections.sort(ans);
		sb.append(ans.size()).append("\n");
		for (String it : ans) {
			sb.append(it).append("\n");
		}

		System.out.println(sb
				);
	}
}
