import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<String> nums = new HashSet<>();
	static int k;
	static int[] cards;

	// #5568
	public static void main(String[] args) throws IOException {
		// 입력 받기 완료
		int n = Integer.parseInt(br.readLine()); // 10
		k = Integer.parseInt(br.readLine()); // 4

		cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		boolean[] visited = new boolean[n];
		dfs(visited, 0, new ArrayList<>());

		System.out.println(nums.size());
	}

	private static void dfs(boolean[] visited, int chooseCnt, List<Integer> selected) {
		if (chooseCnt == k) {
			String num = selected.stream().map(String::valueOf).collect(Collectors.joining());
			nums.add(num);
		} else {
			for (int i = 0; i < cards.length; i++) {
				if (visited[i] == true) {
					continue;
				}
				// 이번 카드 방문
				visited[i] = true;
				selected.add(cards[i]);
				dfs(visited, chooseCnt + 1, selected);
				selected.remove(selected.size() - 1);
				visited[i] = false;
			}
		}
	}
}