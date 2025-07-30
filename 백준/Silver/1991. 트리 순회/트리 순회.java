import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder ans = new StringBuilder();
	static Map<String, TreeNode> nodes = new HashMap<>();
	static StringBuilder preorder = new StringBuilder();
	static StringBuilder inorder = new StringBuilder();
	static StringBuilder postorder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// 트리 세팅
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			TreeNode curr = findNode(st.nextToken());
			TreeNode left = findNode(st.nextToken());
			TreeNode right = findNode(st.nextToken());

			curr.left = left;
			curr.right = right;
		}

		TreeNode root = nodes.get("A");

		// 전위 순회
		preorder(root);
		inorder(root);
		postorder(root);
		
		System.out.println(preorder.toString());
		System.out.println(inorder.toString());
		System.out.println(postorder.toString());
	}

	private static void preorder(TreeNode curr) {
		preorder.append(curr.val);
		if (curr.left != null) {
			preorder(curr.left);
		}
		if (curr.right != null) {
			preorder(curr.right);
		}
	}

	private static void inorder(TreeNode curr) {
		if (curr.left != null) {
			inorder(curr.left);
		}
		inorder.append(curr.val);
		if (curr.right != null) {
			inorder(curr.right);
		}
	}

	private static void postorder(TreeNode curr) {
		if (curr.left != null) {
			postorder(curr.left);
		}
		if (curr.right != null) {
			postorder(curr.right);
		}
		postorder.append(curr.val);
	}

	private static TreeNode findNode(String curr) {
		if (curr.equals(".")) {
			return null;
		}
		if (nodes.containsKey(curr)) {
			return nodes.get(curr);
		}
		nodes.put(curr, new TreeNode(curr));
		return nodes.get(curr);
	}
}

class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;

	TreeNode(String x) {
		this.val = x;
	}
}
