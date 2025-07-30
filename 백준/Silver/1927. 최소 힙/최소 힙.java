import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Long> minHeap = new PriorityQueue<>();
	static StringBuilder ans = new StringBuilder();
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 10만

		for (int i = 0; i < N; i++) {
			long input = Long.parseLong(br.readLine());
			if (input == 0) {
				if (minHeap.isEmpty()) {
					ans.append(0).append("\n");
					continue;
				}
				ans.append(minHeap.poll()).append("\n");
			} else if (input > 0) {
				minHeap.add(input);
			}
		}

		System.out.println(ans.toString());
	}
}
