import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int THRESHOLD = 100000000;
	static boolean[] visited;
	private static List<List<Integer>> graph;
	private static int[] acc;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] val = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}

		acc = Arrays.copyOf(val, val.length);
		Arrays.sort(acc);

		Set<Integer> visited = new HashSet<>();
		Queue<Bfs> queue = new LinkedList<>();
		queue.offer(new Bfs(val, 0));
		visited.add(concat(val));

		while (!queue.isEmpty()) {
			Bfs curr = queue.poll();
			int[] per = curr.per;
			int cnt = curr.cnt;

			if (isAcc(per)) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i + K - 1 < per.length; i++) {
				int[] swap = swap(per, i, K);
				int next = concat(swap);

				if (!visited.contains(next)) {
					visited.add(next);
					queue.offer(new Bfs(swap, cnt + 1));
				}
			}
		}

		System.out.println(-1);
	}

	private static int concat(int[] val) {
		StringBuilder sb = new StringBuilder();
		for (int it : val) {
			sb.append(it);
		}
		return Integer.parseInt(sb.toString());
	}

	private static int[] swap(int[] val, int s, int K) {
		int[] res = new int[val.length];
		for (int i = 0; i < s; i++) {
			res[i] = val[i];
		}

		for (int i = s; i <= s + K - 1; i++) {
			res[i] = val[2 * s + K - 1 - i];
		}

		for (int i = s + K; i < val.length; i++) {
			res[i] = val[i];
		}

		return res;
	}

	private static boolean isAcc(int[] per) {
		for (int i = 0; i < per.length; i++) {
			if (per[i] != acc[i]) {
				return false;
			}
		}
		return true;
	}
}

class Bfs {
	int[] per;
	int cnt;

	public Bfs(int[] per, int cnt) {
		this.per = per;
		this.cnt = cnt;
	}
}