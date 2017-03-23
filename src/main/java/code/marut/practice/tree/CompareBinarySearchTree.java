package code.marut.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompareBinarySearchTree {

	public static boolean compareBst(DTree t1, DTree t2) {
		Stack<DTree> s1 = new Stack<DTree>();
		Stack<DTree> s2 = new Stack<DTree>();
		s1.push(t1);
		s2.push(t2);
		boolean ld1 = false, ld2 = false;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (s1.isEmpty() || s2.isEmpty()) {
				System.out.println("STEP1");
				return false;
			}
			DTree temp1 = null, temp2 = null;
			if (!ld1) {
				addLeftsubTree(s1);
			}
			if (!ld2) {
				addLeftsubTree(s2);
			}
			temp1 = s1.pop();
			temp2 = s2.pop();
			System.out.println(String.format("T1 data %s, t2 data %s", temp1.data, temp2.data));
			if (temp1 == null || temp2 == null || temp1.data != temp2.data)
				return false;

			ld1=addForRightsubTree(s1, temp1);
			ld2=addForRightsubTree(s2, temp2);
		}
		return true;
	}

	private static void addLeftsubTree(Stack<DTree> s) {
		DTree t = s.peek();
		while (t.left != null) {
			s.push(t.left);
			t = t.left;
		}
	}

	private static boolean addForRightsubTree(Stack<DTree> s, DTree current) {
		if (current.right != null) {
			s.push(current.right);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		DTree t1 = new DTree(3);
		t1.left = new DTree(2);
		t1.left.left = new DTree(1);
		t1.right = new DTree(4);
		t1.right.right = new DTree(5);
		

		DTree t2 = new DTree(4);
		t2.left = new DTree(2);
		t2.left.left = new DTree(1);
		t2.left.right = new DTree(3);
		t2.right = new DTree(5);

//		DTree t1 = new DTree(3);
//		t1.left = new DTree(2);
//		t1.right = new DTree(4);
//
//		DTree t2 = new DTree(2);
//		t2.right = new DTree(3);
//		t2.right.right = new DTree(4);

		List<Integer> l = new ArrayList<Integer>();
		TreeTraversal.inorderRecursive(t1, l);
		System.out.println("T1 INORDER ## " + l);

		l = new ArrayList<Integer>();
		TreeTraversal.inorderRecursive(t2, l);
		System.out.println("T2 INORDER ## " + l);

		System.out.println("T1 & T2 are same # " + compareBst(t1, t2));
	}
}
