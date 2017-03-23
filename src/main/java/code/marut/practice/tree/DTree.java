package code.marut.practice.tree;

public class DTree {

	DTree left;
	DTree right;
	int data;
	
	public DTree(int data){
		this.data = data;
	}
	public DTree(DTree left, DTree right, int data){
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public DTree getLeft() {
		return left;
	}

	public void setLeft(DTree left) {
		this.left = left;
	}

	public DTree getRight() {
		return right;
	}

	public void setRight(DTree right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return new Integer(this.data).toString();
	}
}
