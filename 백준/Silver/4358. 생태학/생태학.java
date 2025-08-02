import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 입력 최대 1만
		// 종 최대 100만

		int totalNum = 0;
		Map<String, Integer> trees = new HashMap<>();
		while (true) { // O(N)
			String tree = br.readLine();
			if (tree == null || tree.isEmpty() || tree.isBlank()) {
				break;
			}
			trees.put(tree, trees.getOrDefault(tree, 0) + 1);
			totalNum++;
		}

		List<String> treeList = new ArrayList<>(trees.keySet());
		Collections.sort(treeList); // O(NlogN)

//		System.out.println(totalNum);

		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = 0; i < treeList.size() - 1; i++) {
			String tree = treeList.get(i);
			int num = trees.get(tree);
			double res = (num * 100.0) / totalNum;
			sb.append(tree).append(" ").append(String.format("%.4f", res)).append("\n");
		}

		String tree = treeList.get(i);
		int num = trees.get(tree);
		double res = (num * 100.0) / totalNum;
		sb.append(tree).append(" ").append(String.format("%.4f", res));

		System.out.print(sb);
	}
}
