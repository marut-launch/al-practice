package code.marut.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class TripletSumToZeroInBalancedTree {

	public static boolean isTripletPresent(DTree root) {
		List<Integer> sortedLst = new ArrayList<Integer>();
		TreeTraversal.inorderRecursive(root, sortedLst);
		System.out.println("INORDER ## " + sortedLst);
		for (int i = 0; i < sortedLst.size() - 2; i++) {
			int curr = sortedLst.get(i);
			int l = i + 1;
			int r = sortedLst.size() - 1;
			while (l < r) {
				int sum = curr + sortedLst.get(l) + sortedLst.get(r);
				if (sum == 0) {
					System.out.println(String.format("Triplet indices # %d, %d, %d ", i, l, r));
					System.out.println(
							String.format("Triplet Numbers # %d, %d, %d ", curr, sortedLst.get(l), sortedLst.get(r)));
					return true;
				} else if (sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(6);
		bst.insert(-12);
		bst.insert(14);
		bst.insert(-8);
		bst.insert(15);
		bst.insert(13);
		bst.insert(-7);
		bst.insert(7);
		bst.insert(0);
		bst.insert(0);
		if (isTripletPresent(bst.root))
			System.out.println("Present");
		else
			System.out.println("Not Present");
	}
}
