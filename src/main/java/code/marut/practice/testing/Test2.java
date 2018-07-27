package code.marut.practice.testing;

import java.util.Stack;

public class Test2 {

	private static class Tree {
		Tree left;
		Tree right;
		int data;

		public Tree(int data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return new String(""+data);
		}
	}

	public static void main(String[] args) {
		Tree t1 = new Tree(3);
		t1.left = new Tree(2);
		t1.left.left = new Tree(1);
		t1.right = new Tree(4);
		t1.right.right = new Tree(5);

		Tree t2 = new Tree(4);
		t2.left = new Tree(2);
		t2.left.left = new Tree(1);
		t2.left.right = new Tree(3);
		t2.right = new Tree(5);

		// Tree t1 = new Tree(3);
		// t1.left = new Tree(2);
		// t1.right = new Tree(4);
		//
		// Tree t2 = new Tree(2);
		// t2.right = new Tree(3);
		// t2.right.right = new Tree(4);

		System.out.println("T1 & T2 are same # " + isSameBST(t1, t2));
	}

	public static boolean isSameBST(Tree f, Tree s) {
		if (f == null && s == null) {
			return true;
		}
		if (f == null || s == null) {
			return false;
		}
		Stack<Tree> fStack = new Stack<>();
		Stack<Tree> sStack = new Stack<>();
		fStack.push(f);
		sStack.push(s);
		boolean fRightExists = true, sRightExists = true;
		while (!fStack.isEmpty() && !sStack.isEmpty()) {
			Tree fCurr = fStack.peek();
			Tree sCurr = sStack.peek();
			if (fRightExists)
				addAllLeftNodes(fStack, fCurr.left);
			if (sRightExists)
				addAllLeftNodes(sStack, sCurr.left);
			Tree ftData = fStack.pop();
			Tree stData = sStack.pop();
			System.out.println("POPED #F[" + ftData.data + "],S[" + stData.data + "]");
			if (ftData.data != stData.data) {
				return false;
			}
			fRightExists = addRightNodes(fStack, ftData.right);
			sRightExists = addRightNodes(sStack, stData.right);
		}

		if (fStack.isEmpty() && sStack.isEmpty()) {
			return true;
		}
		return false;
	}

	private static void addAllLeftNodes(Stack<Tree> s, Tree t) {
		while (t != null) {
			s.push(t);
			t = t.left;
		}
	}

	private static boolean addRightNodes(Stack<Tree> s, Tree t) {
		if (t != null && t.right != null) {
			s.push(t.right);
			return true;
		}
		return false;
	}
}
