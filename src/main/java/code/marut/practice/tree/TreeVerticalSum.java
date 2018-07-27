package code.marut.practice.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, how will you find the vertical sum of binary tree.
 */
public class TreeVerticalSum {

	public static void main(String[] args) {
		DTree test = new DTree(1);
		test.left = new DTree(2);
		test.left.left = new DTree(4);
		test.left.right = new DTree(5);

		test.right = new DTree(3);
		test.right.left = new DTree(7);
		test.right.right = new DTree(6);
		
		printVerticalSum(test);
	}

	public static void printVerticalSum(DTree root) {
		if (root == null) {
			return;
		}
		List<Integer> l = new ArrayList<>(), r = new ArrayList<>();
		int curIndex = 1;
		updateVerticalNodes(root, curIndex, l, r);
		int size = 1;
		for(int i=l.size()-1;i>=0;i--) {
			System.out.println(String.format("Sum at %d is %d",size++, l.get(i) ));
		}
		for(int i=0;i<r.size();i++) {
			System.out.println(String.format("Sum at %d is %d",size++, r.get(i) ));
		}
	}
	
	

	public static void updateVerticalNodes(DTree cur, int curIndex, List<Integer> l, List<Integer> r) {
		if (cur == null) {
			return;
		}
		if (curIndex <= 0) {
			int lIndex = curIndex * (-1);
			if (l.size() <= lIndex) {
				l.add(0);
			}
			l.set(lIndex,l.get(lIndex)+cur.data);
		} else {
			if (r.size() <= curIndex-1) {
				r.add(0);
			}
			r.set(curIndex-1,r.get(curIndex-1)+cur.data);
		}
		updateVerticalNodes(cur.left, curIndex-1, l, r);
		updateVerticalNodes(cur.right, curIndex+1, l, r);
	}

}
