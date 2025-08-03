import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int houseCnt;
	static char[][] map;
	static int[][] tiredness;
	static int N;
	static int[] di = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dj = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// 입력 받기
		N = Integer.parseInt(br.readLine()); // 50

		map = new char[N][N];
		tiredness = new int[N][N]; // 100만
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		Set<Integer> tiredSet = new HashSet<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tiredVal = Integer.parseInt(st.nextToken());
				tiredness[i][j] = tiredVal;
				tiredSet.add(tiredVal);
			}
		}

		// 시작점, 집 개수 골라내기
		int[] startPoint = new int[2];
		houseCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char curr = map[i][j];
				if (curr == 'P') {
					// 시작점
					startPoint[0] = i;
					startPoint[1] = j;
				} else if (curr == 'K') {
					houseCnt++;
				}
			}
		}

		// 피로도 정렬
		List<Integer> tiredSort = new ArrayList<>(tiredSet); // 2500
		Collections.sort(tiredSort);

		// bfs low, high 범위 이내에서 지정
		int low = 0;
		int high = 0;
		int res = Integer.MAX_VALUE;

		while (low < tiredSort.size() && high < tiredSort.size()) {
			int lowestRange = tiredSort.get(low);
			int highestRange = tiredSort.get(high);

//			System.out.printf("low: %d, high: %d%n", lowestRange, highestRange);

			int tVal = tiredness[startPoint[0]][startPoint[1]];
			if (tVal < lowestRange || tVal > highestRange) {
				high++;
				continue;
			}

			// lowestRange ~ highestRange 내에서 성공시킬 수 있는지 빠르게 판단 -> BFS

			boolean isAvailable = findPath(startPoint, lowestRange, highestRange);
			if (isAvailable) {
				res = Math.min(res, highestRange - lowestRange);
				low++;
			} else {
				high++;
			}
		}

		System.out.println(res);
	}

	private static boolean findPath(int[] startPoint, int lowestRange, int highestRange) {
		boolean[][] visited = new boolean[N][N];
		Queue<Bfs> queue = new LinkedList<>();

		visited[startPoint[0]][startPoint[1]] = true;
		queue.offer(new Bfs(startPoint[0], startPoint[1]));

		int cnt = 0;
		while (!queue.isEmpty()) {
			Bfs curr = queue.poll();
			int i = curr.i, j = curr.j;

			if (map[i][j] == 'K') {
				cnt++;
			}

			if (cnt == houseCnt) {
				// 모든 집 순회 완료
				return true;
			}

			for (int k = 0; k < di.length; k++) {
				int nextI = i + di[k];
				int nextJ = j + dj[k];

				if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N) {
					// out of map
					continue;
				}

				if (visited[nextI][nextJ])
					continue;

				int tiredVal = tiredness[nextI][nextJ];
				if (tiredVal < lowestRange || tiredVal > highestRange) {
					continue;
				}

				visited[nextI][nextJ] = true;
				queue.offer(new Bfs(nextI, nextJ));
			}
		}

		return false;
	}
}

class Bfs {
	int i;
	int j;

	public Bfs(int i, int j) {
		this.i = i;
		this.j = j;

	}
}