package code.marut.leetcode.tree;

import java.util.Stack;

/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class FlattenBinaryTreeToLinkedList {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		new FlattenBinaryTreeToLinkedList().printRights(root);
		new FlattenBinaryTreeToLinkedList().flatten(root);
		new FlattenBinaryTreeToLinkedList().printRights(root);
	}
	
	public void flatten(TreeNode root) {
		if(root==null) {
			return;
		}
		Stack<TreeNode> s = new Stack<>();
		TreeNode marker = root;
		s.push(root);
		while(!s.isEmpty()) {
			System.out.println(s);
			TreeNode temp = s.pop();
			if(temp.right!=null) {
				s.push(temp.right);
			}
			if(temp.left!=null) {
				s.push(temp.left);
			}
			marker=updateMarker(marker, temp);
			
		}
    }
	
	private TreeNode updateMarker(TreeNode marker, TreeNode temp) {
		if(marker!=temp) {
			temp.left=null;
			temp.right=null;
			marker.right=temp;
			return temp;
		}else {
			marker.left=null;
		}
		return marker;
	}
	
	private void printRights(TreeNode n) {
		StringBuilder sb= null;
		while(n!=null) {
			if(sb==null) {
				sb=new StringBuilder();
				sb.append(n.val);
			}else {
				sb.append("->").append(n.val);
			}
			n = n.right;
		}
		System.out.println(sb.toString());
	}
}
