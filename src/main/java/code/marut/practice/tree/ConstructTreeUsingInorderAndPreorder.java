package code.marut.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructTreeUsingInorderAndPreorder {

	/*
	 * Assuming all numbers are unique
	 */
	public static DTree constructTree(List<Integer> preorder, List<Integer> inorder) {
		return constructTree(preorder, inorder, 0, inorder.size() - 1, 0);
	}

	public static DTree constructTree(List<Integer> preorder, List<Integer> inorder, int start, int end, int next) {
		if (start > end) {
			return null;
		}
		DTree node = new DTree(preorder.get(next));
		int inorderInd = findIndexInInorder(inorder, preorder.get(next));
		node.left = constructTree(preorder, inorder, start, inorderInd - 1, next+1);
		node.right = constructTree(preorder, inorder, inorderInd + 1, end, next+(inorderInd-start+1));
		return node;
	}

	public static int findIndexInInorder(List<Integer> inorder, int number) {
		int l = 0, r = inorder.size() - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (inorder.get(mid) == number) {
				return mid;
			} else if (number > inorder.get(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main1(String[] args) {
		List<Integer> inorder = new ArrayList<Integer>();
		TreeTraversal.inorderRecursive(TreeUtils.exValidBST1(), inorder);
		System.out.println("INORDER (RECURSIVE) >> " + inorder);

		List<Integer> preorder = new ArrayList<Integer>();
		TreeTraversal.preorderRecursive(TreeUtils.exValidBST1(), preorder);
		System.out.println("PREORDER (RECURSIVE) >> " + preorder);

		DTree node = constructTree(preorder, inorder);

		List<Integer> newOrder = new ArrayList<Integer>();
		TreeTraversal.inorderRecursive(node, newOrder);
		System.out.println("NEW INORDER (RECURSIVE) >> " + newOrder);
	}
	
}
