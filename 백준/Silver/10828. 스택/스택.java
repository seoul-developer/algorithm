import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Integer> stack = new Stack<>();
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
			stack.push(Integer.parseInt(value));
			return;
		}
		if (order.equals("top")) {
			if (stack.isEmpty()) {
				ans.append(-1).append("\n");
				return;
			}
			ans.append(stack.peek()).append("\n");
			return;
		}
		if (order.equals("size")) {
			ans.append(stack.size()).append("\n");
			return;
		}
		if (order.equals("pop")) {
			if (stack.isEmpty()) {
				ans.append(-1).append("\n");
				return;
			}
			ans.append(stack.pop()).append("\n");
			return;
		}
		if (order.equals("empty")) {
			if (stack.isEmpty()) {
				ans.append(1).append("\n");
				return;
			}
			ans.append(0).append("\n");
			return;

		}
	}
}
