package code.marut.leetcode.tree;

import java.util.Stack;

/*
Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal 
sum of values after removing exactly one edge on the original tree.

Example 1:
Input:     
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation: 
    5
   / 
  10
      
Sum: 15

   10
  /  \
 2    3

Sum: 15
Example 2:
Input:     
    1
   / \
  2  10
    /  \
   2   20

Output: False
Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.

 */
public class EqualTreePartition {

	public static void main(String[] args) {
		
	}
	
	private static class DepthFirstSearchSolution {
		Stack<Integer> sums;

		public boolean canBePartitioned(TreeNode root) {
			if (root != null) {
				sums = new Stack<>();
				sum(root);
				int total = sums.pop();
				if (total % 2 == 0) {
					while (!sums.isEmpty()) {
						int curr = sums.pop();
						if (curr == total / 2) {
							return true;
						}
					}
				}
			}
			return false;
		}

		private int sum(TreeNode root) {
			if (root != null) {
				sums.push(root.val + sum(root.left) + sum(root.right));
				return sums.peek();
			}
			return 0;
		}
	}

}
