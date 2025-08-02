import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Map<Integer, TreeNode> tree = new HashMap<>();

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		int caseNum = 1;
		inputLoop: while (true) {

			Map<Integer, List<Integer>> treeMap = new HashMap<>();

			caseLoop: while (true) {
				String line = br.readLine();
				if (line.startsWith("-1")) {
					break inputLoop;
				}
				if (line.isEmpty() || line.isBlank()) {
					continue;
				}

				StringTokenizer st = new StringTokenizer(line);

				while (st.hasMoreTokens()) {
					int before = Integer.parseInt(st.nextToken());
					int next = Integer.parseInt(st.nextToken());

					if (before == 0 && next == 0) {
						boolean isTree = isTree(treeMap);
						sb.append("Case ").append(caseNum).append(" is ");
						if (isTree) {
							sb.append("a tree.\n");
						} else {
							sb.append("not a tree.\n");
						}
						caseNum++;
						break caseLoop;
					}

					List<Integer> nextNodes = treeMap.getOrDefault(before, new ArrayList<>());
					nextNodes.add(next);
					treeMap.put(before, nextNodes);
//					System.out.printf("case: %d, bef: %d, next: %d%n", caseNum, before, next);
				}
			}
		}

		System.out.println(sb);
	}

	private static boolean isTree(Map<Integer, List<Integer>> treeMap) {
		if (treeMap.isEmpty()) {
			return true;
		}

		Map<Integer, TreeNode> tree = new HashMap<>();
		for (int curr : treeMap.keySet()) {
			TreeNode rootNode = tree.getOrDefault(curr, new TreeNode(curr));
			tree.put(curr, rootNode);
			if (treeMap.get(curr) == null) {
				continue;
			}
			for (int next : treeMap.get(curr)) {
				TreeNode nextNode = tree.getOrDefault(next, new TreeNode(next));
				rootNode.addNext(nextNode);
				tree.put(next, nextNode);
				if (nextNode.hasBefore()) { // 들어오는 간선이 2개인 경우
					return false;
				}
				nextNode.addBefore(curr);
			}
		}

		TreeNode root = findRoot(treeMap, tree);
		if (root == null) {
			return false;
		}

		return bfs(root, tree);

	}

	private static boolean bfs(TreeNode root, Map<Integer, TreeNode> tree) {
		Set<Integer> visited = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (visited.contains(curr.value)) {
				return false; // 사이클이 있는 경우
			}

			visited.add(curr.value);

			List<Integer> nexts = curr.next;
			if (nexts.isEmpty()) {
				continue;
			}
			for (int next : nexts) {
				queue.add(tree.get(next));
			}
		}

		return visited.size() == tree.size();
	}

	private static TreeNode findRoot(Map<Integer, List<Integer>> treeMap, Map<Integer, TreeNode> tree) {
		List<TreeNode> roots = new ArrayList<>();
		for (TreeNode curr : tree.values()) {
			if (curr.isRoot()) {
				roots.add(curr);
			}
		}

		if (roots.size() != 1) {
			return null;
		}
		return roots.get(0);
	}
}

class TreeNode {
	int before = 0;
	int value;
	List<Integer> next = new ArrayList<>();

	public TreeNode(int value) {
		this.value = value;
	}

	public void addNext(TreeNode nextNode) {
		this.next.add(nextNode.value);
	}

	public boolean isRoot() {
		return before == 0;
	}

	public void addBefore(int root) {
		this.before = root;

	}

	public boolean hasBefore() {
		return before != 0;
	}
}
