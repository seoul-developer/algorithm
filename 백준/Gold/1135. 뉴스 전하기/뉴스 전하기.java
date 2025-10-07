import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int a = i;
			int b = Integer.parseInt(st.nextToken());

			if (a == 0) {
				continue;
			}

			graph.get(b).add(a);
		}

		System.out.println(findLongest(0));
	}

	private static int findLongest(int root) {
		List<Integer> childTimes = new ArrayList<>();

		// leaf node
		for (int child : graph.get(root)) {
			childTimes.add(findLongest(child));
		}

		if (childTimes.isEmpty()) {
			return 0;
		}

		childTimes.sort(Collections.reverseOrder());

		int maxTime = 0;
		for (int i = 0; i < childTimes.size(); i++) {
			int time = childTimes.get(i) + (i + 1);
			maxTime = Math.max(maxTime, time);
		}

		return maxTime;
	}
}