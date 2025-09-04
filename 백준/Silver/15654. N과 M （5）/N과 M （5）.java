import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static Set<String> res;
	private static boolean[] visited;
	private static int N;
	private static int M;
	private static int[] nums;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); // 10000
		}

		Arrays.sort(nums);

		res = new HashSet<>();
		visited = new boolean[N];

		dfs(new ArrayList<>());

		System.out.println(sb);
	}

	private static void dfs(List<Integer> choose) {
		if (choose.size() == M) {
			for (int it : choose) {
				sb.append(it).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			choose.add(nums[i]);
			dfs(choose);
			choose.remove(choose.size() - 1);
			visited[i] = false;
		}
	}
}