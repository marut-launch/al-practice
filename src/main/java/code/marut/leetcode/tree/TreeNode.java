package code.marut.leetcode.tree;

public class TreeNode {

	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(Integer data) {
		this.val = data;
	}

	@Override
	public String toString() {
		return "" + val;
	}
}
