import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>(set);

		Collections.sort(list, (a, b) -> {
			if (a.length() != b.length()) {
				return a.length() - b.length();
			}
			return a.compareTo(b);
		});

		for (String it : list) {
			sb.append(it).append("\n");
		}

		System.out.println(sb);
	}
}