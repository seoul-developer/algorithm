import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayDeque<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		String[] orders = new String[N];
		for (int i = 0; i < N; i++) {
			String order = br.readLine();
			execute(order);
		}

		System.out.println(ans.toString());
	}

	private static void execute(String order) {
		if (order.startsWith("push")) {
			String value = order.split(" ")[1];
			queue.offer(Integer.parseInt(value));
			return;
		}
		if (order.equals("size")) {
			ans.append(queue.size()).append("\n");
			return;
		}
		if (order.equals("pop")) {
			if (queue.isEmpty()) {
				ans.append(-1).append("\n");
				return;
			}
			ans.append(queue.poll()).append("\n");
			return;
		}
		if (order.equals("empty")) {
			if (queue.isEmpty()) {
				ans.append(1).append("\n");
				return;
			}
			ans.append(0).append("\n");
			return;
		}
		if (order.equals("front")) {
			if (queue.isEmpty()) {
				ans.append(-1).append("\n");
				return;
			}
			ans.append(queue.peekFirst()).append("\n");
			return;
		}
		if (order.equals("back")) {
			if (queue.isEmpty()) {
				ans.append(-1).append("\n");
				return;
			}
			ans.append(queue.peekLast()).append("\n");
			return;
		}
	}
}
