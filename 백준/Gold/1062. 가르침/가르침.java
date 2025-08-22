import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<String> taught = new HashSet<>();
	static int N;
	static int K;
	static int[] words;
	static int ans = 0;
	static int taughtMask;

	static int bit(char c) {
		return 1 << (c - 'a');
	}

	public static void main(String[] args) throws IOException {
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		taught.add("a");
		taught.add("n");
		taught.add("t");
		taught.add("i");
		taught.add("c");

		if (K < taught.size()) {
			System.out.println(0);
			return;
		}

		if (K == 26) { // 전부 가르칠 수 있으면 N
			for (int i = 0; i < N; i++)
				br.readLine();
			System.out.println(N);
			return;
		}

		words = new int[N];
		taughtMask = bit('a') | bit('n') | bit('t') | bit('i') | bit('c');

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			String mid = input.substring(4, input.length() - 4);
			int mask = 0;
			for (char ch : mid.toCharArray()) {
				if ((taughtMask & bit(ch)) == 0) {
					// 아직 들어온 적 없는 글자의 경우
					mask |= bit(ch);
				}
			}
			words[i] = mask;
		}

		dfs(0, 0, taughtMask);
		System.out.println(ans);
	}

	private static void dfs(int idx, int depth, int mask) {
		if (depth == K - 5) {
			int cnt = 0;
			for (int w : words) {
				if ((w & ~mask) == 0)
					cnt++;
			}
			ans = Math.max(cnt, ans);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if ((mask & (1 << i)) == 0) {
				dfs(i + 1, depth + 1, mask | (1 << i));
			}
		}
	}
}
