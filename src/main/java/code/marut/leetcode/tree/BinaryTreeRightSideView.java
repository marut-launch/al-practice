package code.marut.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		
		root.right= new TreeNode(3);
		root.right.right= new TreeNode(4);
		
		System.out.println(new BinaryTreeRightSideView().rightSideView(root));

	}
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<Integer>();
        dfs(root, rightSideView, 0);
        return rightSideView;
    }
	
	private void dfs(TreeNode n, List<Integer> rightSideView, int depth) {
		if(n==null) {
			return;
		}
		if(rightSideView.size()==depth) {
			rightSideView.add(n.val);
		}
		dfs(n.right, rightSideView, depth+1);
		dfs(n.left, rightSideView, depth+1);
	}
}
