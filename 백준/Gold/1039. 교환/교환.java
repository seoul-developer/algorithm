import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int THRESHOLD = 100000000;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] init = String.valueOf(N).toCharArray();

		Queue<Bfs> queue = new LinkedList<>();
		queue.offer(new Bfs(init, K));
		Set<String>[] visited = new HashSet[K + 1];
		for (int i = 0; i <= K; i++) {
			visited[i] = new HashSet<>();
		}

		List<Integer> ans = new ArrayList<>();

		StringBuilder sb;
		while (!queue.isEmpty()) {
			Bfs curr = queue.poll();
			char[] val = curr.val;
			int cnt = curr.cnt;

			if (cnt == 0) {
				ans.add(Integer.parseInt(new String(val)));
				continue;
			}

			for (int i = 0; i < val.length; i++) {
				for (int j = i + 1; j < val.length; j++) {
					if (i == 0 && val[j] == '0') {
						continue;
					}

					char[] next = Arrays.copyOf(val, val.length);

					// swap
					char a = next[i];
					next[i] = next[j];
					next[j] = a;

					String nextString = new String(next);
					if (!visited[cnt - 1].contains(nextString)) {
						visited[cnt - 1].add(nextString);
						queue.offer(new Bfs(next, cnt - 1));
					}
				}
			}
		}

		if (ans.isEmpty()) {
			System.out.println(-1);
			return;
		}

		Collections.sort(ans, Comparator.reverseOrder());
		System.out.println(ans.get(0));
	}
}

class Bfs {
	char[] val;
	int cnt;

	public Bfs(char[] val, int cnt) {
		this.val = val;
		this.cnt = cnt;
	}
}