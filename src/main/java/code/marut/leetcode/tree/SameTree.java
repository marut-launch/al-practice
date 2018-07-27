package code.marut.leetcode.tree;

import java.util.Stack;

/*
 Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
		boolean f1 = true, f2 = true;
		s1.push(p);
		s2.push(q);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if(f1) {
				addLeftNodes(s1);
			}
			if(f2) {
				addLeftNodes(s2);
			}
			TreeNode n1= s1.pop();
			TreeNode n2= s2.pop();
			if(n1.val!=n2.val) {
				return false;
			}
			f1 = addRightNodes(s1, n1);
			f2 = addRightNodes(s2, n2);
		}
		if (!s1.isEmpty() || !s2.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void addLeftNodes(Stack<TreeNode> s) {
		TreeNode t = s.peek();
		while(t.left!=null) {
			s.push(t.left);
			t=t.left;
		}
	}

	private boolean addRightNodes(Stack<TreeNode> s,TreeNode n) {
		if(n.right!=null) {
			s.push(n.right);
			return true;
		}
		return false;
	}
}
