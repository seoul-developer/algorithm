import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long[] fac;

	public static void main(String[] args) throws IOException {
		// 입력 받기
		N = Integer.parseInt(br.readLine()); // 20 (1~20 숫자로 순열)
		calculateFac();

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String code = st.nextToken();
		if (code.equals("1")) {
			long k = Long.parseLong(st.nextToken());
			List<Integer> res = exec1(k - 1);
			for (int val : res) {
				sb.append(val).append(" ");
			}
		} else {
			// 2
			List<Integer> inputs = new ArrayList<>();
			while (st.hasMoreTokens()) {
				String next = st.nextToken();
				inputs.add(Integer.parseInt(next));
			}
			long res = exec2(inputs);
			sb.append(res);
		}

		System.out.println(sb.toString());
	}

	private static List<Integer> exec1(long k) {
		List<Integer> res = new ArrayList<>();
		List<Integer> nonused = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			nonused.add(i);
		}

		while (nonused.size() > 1) {
			long oneSize = fac[nonused.size() - 1];
			int letterIndex = (int) (k / oneSize);

			int newVal = nonused.get(letterIndex);
			res.add(newVal);
			nonused.remove(letterIndex);

			k -= letterIndex * oneSize;
//			System.out.printf("남은 개수: %d, k: %d, fac: %d, nonused: %s, 순열: %s, k: %d %n", nonused.size(), k,
//					fac[nonused.size() - 1], nonused.toString(), res.toString(), k);
		}

		res.add(nonused.get(0));
		return res;
	}

	private static long exec2(List<Integer> inputs) {
		// N개의 숫자 입력받고 해당 순열이 몇 번째인지 출력
		List<Integer> nonused = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			nonused.add(i);
		}

		long res = 1;
		for (int i = 0; i < inputs.size(); i++) {
			int val = inputs.get(i);
			int f = N - i - 1;
			int index = nonused.indexOf(val);
			nonused.remove(index);

			res = res + fac[f] * index;
//			System.out.printf("val: %d, N-1: %d, index: %d, res: %d, nonused: %s%n", val, f, index, res,
//					nonused.toString());
		}

		return res;
	}

	private static void calculateFac() {
		fac = new long[N + 1];
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i <= N; i++) {
			fac[i] = fac[i - 1] * i;
		}
	}
}