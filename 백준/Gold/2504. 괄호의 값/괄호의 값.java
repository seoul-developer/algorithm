import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayDeque<String> stack = new ArrayDeque<>();
	static List<String> opening = Arrays.asList("(", "[");
	static List<String> closing = Arrays.asList(")", "]");
	static List<String> brackets = Arrays.asList("(", "[", ")", "]");

	public static void main(String[] args) throws IOException {
		char[] input = br.readLine().toCharArray();

		int ans = 0;

		for (int i = 0; i < input.length; i++) {
			int res = execute(String.valueOf(input[i]));
			if (res == 0) {
				ans = 0;
				break;
			}
//			System.out.println(stack.toString());
		}

		while (!stack.isEmpty()) {
			String tmp = stack.pop();
			if (brackets.contains(tmp)) {
				ans = 0;
				break;
			}
			ans += Integer.parseInt(tmp);
		}
		System.out.println(ans);
	}

	private static int execute(String curr) {
		// 열린 괄호는 그냥 push
		if (opening.contains(curr)) {
			stack.push(curr);
		}

		// 닫힌 괄호는 관련된 괄호를 찾을 때까지 꺼냄
		if (curr.equals(")")) {
			if (stack.isEmpty())
				return 0;
			String peek = stack.peek();
			if (peek.equals("(")) {
				// 정상으로 닫힘
				stack.pop();
				stack.push("2");
				return 1;
			}
			if (peek.equals("[")) {
				// 비정상 [ )
				return 0;
			}
			// 숫자가 있는 경우
			int tmp = 0;
			peek = stack.pop();
			while (!brackets.contains(peek)) {
				tmp += Integer.parseInt(peek);
				if (stack.isEmpty())
					return 0;
				peek = stack.pop();
			}
			if (peek.equals("(")) {
				// 정상으로 닫힘 ( 3 2 2 )
				stack.push(String.valueOf(2 * tmp));
				return 1;
			}
			if (peek.equals("[")) {
				// 비정상 [ 2 3 3 )
				return 0;
			}
		}

		if (curr.equals("]")) {
			if (stack.isEmpty())
				return 0;
			String peek = stack.peek();
			if (peek.equals("[")) {
				// 정상으로 닫힘
				stack.pop();
				stack.push("3");
				return 1;
			}
			if (peek.equals("(")) {
				// 비정상
				return 0;
			}
			// 숫자가 있는 경우
			int tmp = 0;
			peek = stack.pop();
			while (!brackets.contains(peek)) {
				tmp += Integer.parseInt(peek);
				if (stack.isEmpty())
					return 0;
				peek = stack.pop();
			}
			if (peek.equals("[")) {
				// 정상으로 닫힘 ( 3 2 2 )
				stack.push(String.valueOf(3 * tmp));
				return 1;
			}
			if (peek.equals("(")) {
				// 비정상
				return 0;
			}
		}

		return 1;
	}
}