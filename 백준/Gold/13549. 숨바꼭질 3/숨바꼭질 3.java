import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 10만
		int K = Integer.parseInt(st.nextToken()); // 10만

		boolean[] visited = new boolean[2 * (N + K) + 1];
		Deque<Bfs> deque = new ArrayDeque<>();
		deque.offer(new Bfs(N, 0));

		while (!deque.isEmpty()) {
			Bfs curr = deque.poll();
			int pos = curr.pos;
			int time = curr.time;

			if (pos < 0 || pos >= visited.length) {
				continue;
			}

			if (visited[pos]) {
				continue;
			}

			if (pos == K) {
				System.out.print(time);
				return;
			}

			visited[pos] = true;

			deque.offerFirst(new Bfs(2 * pos, time));
			deque.offerLast(new Bfs(pos + 1, time + 1));
			deque.offerLast(new Bfs(pos - 1, time + 1));
		}
	}
}

class Bfs {
	int pos;
	int time;

	public Bfs(int pos, int time) {
		this.pos = pos;
		this.time = time;
	}
}