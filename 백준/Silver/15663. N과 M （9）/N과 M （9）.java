import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] values;

	public static void main(String[] args) throws IOException {
		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 8
		int M = Integer.parseInt(st.nextToken()); // 8

		values = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		// N 개의 자연 수 values 중 M 개를 고른 수열
		Arrays.sort(values);
		boolean[] visited = new boolean[N];

		dfs(0, visited, M, new ArrayList<Integer>());

		System.out.println(sb.toString());

	}

	private static void dfs(int index, boolean[] visited, int totalNum, ArrayList<Integer> chooseNums) {
		// TODO Auto-generated method stub
		if (totalNum == chooseNums.size()) {
			for (int i = 0; i < totalNum - 1; i++) {
				int num = chooseNums.get(i);
				sb.append(num).append(" ");
			}
			sb.append(chooseNums.get(totalNum - 1)).append("\n");
			return;
		}

		for (int i = 0; i < values.length; i++) {
			if (i >= values.length || visited[i] == true) {
				continue;
			}
			if (i > 0 && values[i] == values[i - 1] && visited[i - 1] == false) {
				continue;
			}

			// 현재 인덱스를 고름
			visited[i] = true;
			chooseNums.add(values[i]);
			dfs(i + 1, visited, totalNum, chooseNums);

			// 현재 인덱스를 안고름
			visited[i] = false;
			chooseNums.remove(chooseNums.size() - 1);
		}
	}
}