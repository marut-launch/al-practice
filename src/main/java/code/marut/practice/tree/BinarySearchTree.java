package code.marut.practice.tree;

public class BinarySearchTree {

	DTree root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int item) {
		root = insertRec(root, item);
	}

	public DTree insertRec(DTree node, int item) {
		if (node == null) {
			node = new DTree(item);
			return node;
		}
		if (item < node.data) {
			node.left = insertRec(node.left, item);
		} else {
			node.right = insertRec(node.right, item);
		}
		return node;
	}
	
}
