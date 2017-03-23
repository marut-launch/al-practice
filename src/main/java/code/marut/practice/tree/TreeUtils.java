package code.marut.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

	public static DTree exValidBST1() {
		DTree t = new DTree(null, null, 50);
		t.left = new DTree(null, new DTree(new DTree(null, null, 38), null, 47), 35);
		t.right = new DTree(new DTree(null, null, 78), new DTree(new DTree(null, null, 110), null, 130), 100);
		return t;
	}

	public static DTree exInvalidBST1() {
		DTree t = new DTree(null, null, 50);
		t.left = new DTree(null, new DTree(new DTree(null, null, 38), null, 47), 35);
		t.right = new DTree(new DTree(null, null, 78), new DTree(new DTree(null, null, 140), null, 130), 100);
		return t;
	}

	public static int maxDepth(DTree root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static int minDepth(DTree root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static int minDepth_BFS(DTree root) {
		if (root == null)
			return 0;
		int depth = 1;
		Queue<DTree> nodes = new LinkedList<DTree>();
		nodes.add(root);
		DTree rightMost = root;
		while (!nodes.isEmpty()) {
			DTree node = nodes.poll();
			if (node.left == null && node.right == null)
				break;
			if (node.left != null)
				nodes.add(node.left);
			if (node.right != null)
				nodes.add(node.right);
			if (rightMost == node) {
				depth++;
				rightMost = (node.right != null) ? node.right : node.left;
			}
		}
		return depth;
	}

	public static boolean isBalanced(DTree root) {
		return isBalanced(root, 0);
	}

	private static boolean isBalanced(DTree node, Integer ht) {
		if (node == null) {
			ht = 0;
			return true;
		}

		Integer lht = 0, rht = 0;
		boolean l = isBalanced(node.left, lht);
		boolean r = isBalanced(node.left, rht);

		ht = (lht > rht ? lht : rht) + 1;
		if (Math.abs(lht - rht) > 1) {
			return false;
		}
		return l && r;
	}

	public static void treeBalanceTest() {
		BinaryTree tree = new BinaryTree();
		tree.root = new DTree(1);
		tree.root.left = new DTree(2);
		tree.root.right = new DTree(3);
		tree.root.left.left = new DTree(4);
		tree.root.left.right = new DTree(5);
		tree.root.right.right = new DTree(6);
		tree.root.left.left.left = new DTree(7);

		if (isBalanced(tree.root, 0))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}

	public static void main(String[] args) {
		DTree t = TreeUtils.exValidBST1();
		System.out.println("Max Depth T# " + maxDepth(t));
		System.out.println("(Recursive) Min Depth T# " + minDepth(t));
		System.out.println("(BFS) Min Depth T# " + minDepth_BFS(t));
		
		treeBalanceTest();
	}
}
