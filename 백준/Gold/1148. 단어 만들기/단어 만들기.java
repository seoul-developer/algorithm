import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[][] jisho;
	private static int size;

	public static void main(String[] args) throws IOException {
		List<String> words = new ArrayList<>(); // 20만
		while (true) {
			String input = br.readLine();
			if (input.equals("-")) {
				break;
			}

			words.add(input);
		}

		size = words.size();
		jisho = new int[size][26];

		for (int i = 0; i < size; i++) {
			for (char c : words.get(i).toCharArray()) {
				jisho[i][c - 'A']++;
			}
		}

//		for (int[] cnt : jisho) {
//			System.out.println(Arrays.toString(cnt));
//		}

		while (true) {
			String input = br.readLine();
			if (input.equals("#")) {
				break;
			}

			int[] board = new int[9];
			char[] chBoard = input.toCharArray();
			for (int i = 0; i < 9; i++) {
				board[i] = chBoard[i] - 'A';
			}

			Res res = play(board);
			sb.append(res.min).append(" ").append(res.minVal).append(" ").append(res.max).append(" ").append(res.maxVal)
					.append("\n");
		}

		System.out.println(sb);
	}

	private static Res play(int[] board) {
		int[] boardCnt = new int[26];
		for (int it : board) {
			boardCnt[it]++;
		}

		Map<Integer, Integer> res = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < board.length; i++) {
			int val = board[i]; // 필수
			if (res.containsKey(val)) {
				continue; // 이미 전에 계산함
			}

			int cnt = 0;

			loop: for (int[] word : jisho) {
				if (word[val] == 0) {
					continue;
				}
				for (int j = 0; j < 26; j++) {
					if (boardCnt[j] - word[j] < 0) {
						continue loop;
					}
				}
				cnt++;
			}

			min = Math.min(cnt, min);
			max = Math.max(cnt, max);
			res.put(val, cnt);
		}

		List<Character> mins = new ArrayList<>();
		List<Character> maxs = new ArrayList<>();

		for (int key : res.keySet()) {
			if (res.get(key) == min) {
				mins.add((char) ('A' + key));
			}
			if (res.get(key) == max) {
				maxs.add((char) ('A' + key));
			}
		}

		Collections.sort(mins);
		Collections.sort(maxs);

		StringBuilder minRes = new StringBuilder();
		for (char it : mins) {
			minRes.append(it);
		}
		StringBuilder maxRes = new StringBuilder();
		for (char it : maxs) {
			maxRes.append(it);
		}

		return new Res(minRes.toString(), min, maxRes.toString(), max);
	}
}

class Res {

	String min;
	int minVal;
	String max;
	int maxVal;

	public Res(String min, int minVal, String max, int maxVal) {
		this.min = min;
		this.minVal = minVal;
		this.max = max;
		this.maxVal = maxVal;
	}
}