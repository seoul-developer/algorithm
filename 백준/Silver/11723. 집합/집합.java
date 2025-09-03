import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<Integer> S = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine()); // 300만
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String code = st.nextToken();
			execute(code, st);
		}
		System.out.println(sb);
		
	}

	private static void execute(String code, StringTokenizer st) {
		if (code.equals("all")) {
			S = new HashSet<>();
			S.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
			return;
		}
		if (code.equals("empty")) {
			S = new HashSet<>();
			return;
		}
		int x = Integer.parseInt(st.nextToken());
		if (code.equals("add")) {
			S.add(x);
			return;
		}
		if (code.equals("remove")) {
			S.remove(x);
			return;
		}
		if (code.equals("toggle")) {
			if (S.contains(x)) {
				S.remove(x);
			} else {
				S.add(x);
			}
			return;
		}
		if (code.equals("check")) {
			int check = S.contains(x) ? 1 : 0;
			sb.append(check).append("\n");
			return;
		}
	}
}
