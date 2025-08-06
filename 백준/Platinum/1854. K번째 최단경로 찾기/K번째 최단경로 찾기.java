import java.io.*;
import java.util.*;

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;

	public static void main(String args[]) throws Exception {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 1000
		int m = Integer.parseInt(st.nextToken()); // 25만
		int k = Integer.parseInt(st.nextToken()); // 100

		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 1~1000

			graph.get(a).add(new int[] { b, c });
		}

		kthMinPath(graph, k);
	}

	private static void kthMinPath(List<List<int[]>> graph, int k) {
		Map<Integer, PriorityQueue<Long>> dists = new HashMap<>(); // 각 정점별로 갈 수 있는 경로를 내림차순으로 저장

		for (int i = 1; i <= n; i++) {
			dists.put(i, new PriorityQueue<>(Collections.reverseOrder()));
		}

		PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

		queue.offer(new long[] { 1, 0 });
		dists.get(1).offer(0L);

		while (!queue.isEmpty()) {
			long[] curr = queue.poll();
			long index = curr[0];
			long w = curr[1];

			List<int[]> nexts = graph.get((int) index);
			for (int[] next : nexts) {
				int nextIndex = next[0];
				int nextW = next[1];

				PriorityQueue<Long> dist = dists.get(nextIndex);
				if (dist.size() < k) {
					dist.offer(w + nextW);
					queue.offer(new long[] { nextIndex, w + nextW });
				} else {
					// 이미 k개 확보한 상황이라면 현재 중 Max보다 작은 경우에만 데려간다
					if (dist.peek() > w + nextW) {
						dist.poll();
						dist.offer(w + nextW);
						queue.offer(new long[] { nextIndex, w + nextW });
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int v = 1; v <= n; v++) {
			PriorityQueue<Long> pq = dists.get(v);
			if (pq.size() < k) {
				sb.append(-1).append("\n");
			} else {
				sb.append(pq.peek()).append("\n");
			}
		}

		System.out.println(sb);
	}
}