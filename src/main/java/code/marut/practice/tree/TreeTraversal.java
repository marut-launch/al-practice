package code.marut.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Inorder Traversal >> Left - root - right elements 
 * Preorder Traversal >> root - Left - right  elements 
 * Postorder Traversal >> Left - right - root elements 
 */
public class TreeTraversal {

	public static void inorderRecursive(DTree root, List<Integer> lst) {
		if (root == null) {
			return;
		}
		inorderRecursive(root.left, lst);
		lst.add(root.data);
		inorderRecursive(root.right, lst);
	}

	public static void inorderIterative(DTree root, List<Integer> lst) {
		Stack<DTree> st = new Stack<DTree>();
		st.push(root);
		while (!st.isEmpty()) {
			DTree temp = st.peek();
			while (temp.left != null) {
				st.push(temp.left);
				temp = temp.left;
			}
			temp = st.pop();
			lst.add(temp.data);
			while (temp.right == null) {
				if(st.isEmpty()){
					temp=null;
					break;
				}
				temp = st.pop();
				lst.add(temp.data);
			}
			if(temp!=null){
				st.push(temp.right);
			}
		}
	}

	public static void preorderRecursive(DTree root, List<Integer> lst) {
		if (root == null) {
			return;
		}
		lst.add(root.data);
		preorderRecursive(root.left, lst);
		preorderRecursive(root.right, lst);
	}

	public static void preorderIterative(DTree root, List<Integer> lst) {
		Stack<DTree> st = new Stack<DTree>();
		st.push(root);
		while(!st.isEmpty()){
			DTree temp = st.pop();
			lst.add(temp.data);
			if(temp.right!=null){
				st.push(temp.right);
			}
			if(temp.left!=null){
				st.push(temp.left);
			}
		}
		
	}

	public static void postorderRecursive(DTree root, List<Integer> lst) {
		if (root == null) {
			return;
		}
		postorderRecursive(root.left, lst);
		postorderRecursive(root.right, lst);
		lst.add(root.data);
	}

	public static void postorderIterative(DTree root, List<Integer> lst) {
		Stack<DTree> st = new Stack<DTree>();
		st.push(root);
		while(!st.isEmpty()){
			DTree temp = st.pop();
			lst.add(temp.data);
			if(temp.left!=null){
				st.push(temp.left);
			}
			if(temp.right!=null){
				st.push(temp.right);
			}
		}
		
		for(int l=0, r=lst.size()-1;l<r;l++,r--){
			int temp = lst.get(l);
			lst.set(l,lst.get(r));
			lst.set(r,temp);
		}
	}

	public static void main(String[] args) {
		List<Integer> res = new ArrayList<Integer>();
		inorderRecursive(TreeUtils.exValidBST1(), res);
		System.out.println("INORDER (RECURSIVE) >> " + res);

		res = new ArrayList<Integer>();
		inorderIterative(TreeUtils.exValidBST1(), res);
		System.out.println("INORDER (ITERATIVE) >> " + res);

		res = new ArrayList<Integer>();
		preorderRecursive(TreeUtils.exValidBST1(), res);
		System.out.println("PREORDER (RECURSIVE) >> " + res);

		res = new ArrayList<Integer>();
		preorderIterative(TreeUtils.exValidBST1(), res);
		System.out.println("PREORDER (ITERATIVE) >> " + res);
		
		res = new ArrayList<Integer>();
		postorderRecursive(TreeUtils.exValidBST1(), res);
		System.out.println("POSTORDER (RECURSIVE) >> " + res);
		
		res = new ArrayList<Integer>();
		postorderIterative(TreeUtils.exValidBST1(), res);
		System.out.println("POSTORDER (RECURSIVE) >> " + res);
	}
}