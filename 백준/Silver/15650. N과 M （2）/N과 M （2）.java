import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Bfs> queue = new LinkedList<>();
		queue.offer(new Bfs(new ArrayList<>(), 0, 0));
		List<String> ans = new ArrayList<>();

		while (!queue.isEmpty()) {
			Bfs curr = queue.poll();

			List<Integer> list = curr.list;
			int last = curr.last;
			int cnt = curr.cnt;

//			System.out.printf("list: %s, last: %d, cnt: %d%n", list.toString(), last, cnt);

			if (cnt == M) {
				String str = list.stream().map(it -> String.valueOf(it)).collect(Collectors.joining(" "));
//				System.out.printf("str: %s%n", str);
				ans.add(str);
				continue;
			}

			for (int i = last + 1; i <= N; i++) {
				List<Integer> newList = new ArrayList<>(list);
				newList.add(i);
				queue.offer(new Bfs(newList, i, cnt + 1));
			}
		}

		System.out.println(ans.stream().collect(Collectors.joining("\n")));
	}
}

class Bfs {
	List<Integer> list;
	int last;
	int cnt;

	public Bfs(List<Integer> list, int last, int cnt) {
		this.list = list;
		this.last = last;
		this.cnt = cnt;
	}
}
