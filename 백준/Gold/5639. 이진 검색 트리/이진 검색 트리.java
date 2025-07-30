import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> nodes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String next;
		while (true) {
			next = br.readLine();
			if (next == null || next.equals("") || next.equals("END"))
				break;
			nodes.add(Integer.parseInt(next));
		}

		Tree root = constructTree(0, nodes.size());

		postOrder(root);
	}

	private static void preOrder(Tree node) {
		if (node == null)
			return;
		System.out.println(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void postOrder(Tree node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.val);
	}

	private static Tree constructTree(int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return null;
		}

		Tree root = new Tree(nodes.get(startIndex));

		int mid = endIndex;
		for (int i = startIndex; i < endIndex; i++) {
			int currValue = nodes.get(i);
			if (root.val < currValue) {
				mid = i;
				break;
			}
		}

		root.left = constructTree(startIndex + 1, mid);
		root.right = constructTree(mid, endIndex);

		return root;
	}
}

class Tree {
	int val;
	Tree left, right;

	public Tree(int val) {
		this.val = val;
	}
}

//50
//30
//24
//5
//28
//45
//98
//52
//60
//END