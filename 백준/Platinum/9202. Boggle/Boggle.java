import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Map<Integer, Integer> scoreMap = new HashMap<>(); // 길이, 점수
	static StringBuilder sb = new StringBuilder();

	static {
		for (int i = 0; i <= 2; i++)
			scoreMap.put(i, 0);
		for (int i = 3; i <= 4; i++)
			scoreMap.put(i, 1);
		scoreMap.put(5, 2);
		scoreMap.put(6, 3);
		scoreMap.put(7, 5);
		scoreMap.put(8, 11);
	}

	public static void main(String[] args) throws IOException {
		int w = Integer.parseInt(br.readLine()); // 단어의 수 (30만)
		String[] dict = new String[w];
		for (int i = 0; i < w; i++) {
			dict[i] = br.readLine();
		}
		br.readLine(); // 공백

		int b = Integer.parseInt(br.readLine()); // 보글 보드의 수 (30)
		List<char[][]> boards = new ArrayList<>();
		for (int i = 0; i < b; i++) {
			char[][] board = new char[4][4];
			for (int row = 0; row < 4; row++) {
				board[row] = br.readLine().toCharArray();
			}
			boards.add(board);
			if (i < b - 1) {
				br.readLine();
			}
		}

//		for (char[][] board : boards) {
//			for (int i = 0; i < 4; i++) {
//				for (int j = 0; j < 4; j++) {
//					System.out.println(board[i][j]);
//				}
//			}
//		}
		// 입력 받기 완료

		for (int i = 0; i < b; i++) {
			// board만큼 반복 (최대 30회)
//			System.out.println(i + " round");
			Object[] res = findWord(boards.get(i), dict);
			sb.append(res[0]).append(" ").append(res[1]).append(" ").append(res[2]).append("\n");
		}

		System.out.println(sb);
	}

	private static Object[] findWord(char[][] board, String[] dict) {
		Set<String> foundWords = new HashSet<>();

		for (String word : dict) {
			// board에서 word만큼 반복
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (board[i][j] == word.charAt(0)) {
						boolean[][] visited = new boolean[4][4];
						visited[i][j] = true;

						for (int dir = 0; dir < dx.length; dir++) {
//							System.out.printf("x: %d, y: %d, char: %c%n", i, j, board[i][j]);

							int newX = i + dx[dir];
							int newY = j + dy[dir];

							if (dfs(newX, newY, board, visited, word, 1)) {
								foundWords.add(word);
							}
						}

						visited[i][j] = false;
					}
				}
			}
		}

		return calculateResult(foundWords);
	}

	private static Object[] calculateResult(Set<String> words) {
		List<String> foundWords = new ArrayList<>(words);
		if (foundWords.isEmpty()) {
			return new Object[] { 0, null, 0 };
		}

		Collections.sort(foundWords, (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b); // 길이가 같으면 오름차순
			}
			return b.length() - a.length(); // 길이 긴 순
		});

		String longestWord = foundWords.get(0);
//		System.out.println("longest: " + longestWord);

		int score = 0;
		for (String word : foundWords) {
//			System.out.println(word);
			score += scoreMap.get(word.length());
		}

		return new Object[] { score, longestWord, foundWords.size() };
	}

	private static boolean dfs(int x, int y, char[][] board, boolean[][] visited, String word, int wordIndex) {
		if (wordIndex == word.length()) {
			return true;
		}

		if (x < 0 || x >= 4 || y < 0 || y >= 4) {
			return false;
		}

		if (visited[x][y] == false && board[x][y] == word.charAt(wordIndex)) {
			visited[x][y] = true;

			for (int dir = 0; dir < dx.length; dir++) {
				int newX = x + dx[dir];
				int newY = y + dy[dir];

				if (dfs(newX, newY, board, visited, word, wordIndex + 1)) {
					return true;
				}
			}

			visited[x][y] = false;
		}

		return false;
	}
}