package code.marut.practice.linkedlist;

public class LinkedList {
	Node head;

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
		@Override
		public boolean equals(Object obj) {
			return this.data==((Node)obj).data;
		}
	}

	public void insertAtEnd(int newData) {
		if (head == null) {
			head = new Node(newData);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(newData);
		}
	}

	public void insertAtStart(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}

	public void insertAfter(Node prev_node, int newData) {
		boolean found = false;
		if (prev_node == null) {
			throw new IllegalArgumentException("Previous node is null/empty.");
		}
		Node current = head;
		while (current != null) {
			if (current.data == prev_node.data) {
				Node newNode = new Node(newData);
				newNode.next = current.next;
				current.next = newNode;
				found = true;
				break;
			}
		}
		if (found) {
			throw new IllegalArgumentException("can't find Node # " + prev_node.data);
		}
	}

	public Node getNode(int data) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		while (curr != null && curr.data != data) {
			curr = curr.next;
		}
		return curr;
	}

	public void deleteNode(Node start, Node delete) {
		if (start == null) {
			System.out.println("Start node is null.");
			return;
		}
		if (delete == null) {
			System.out.println("Delete node is null.");
			return;
		}
		if (start.data == delete.data) {
			if (start.next == null) {
				System.out.println("There is only one node in the list");
				return;
			}
			start.data = start.next.data;
			start.next = start.next.next;
			System.gc();
			return;
		}
		Node prev = start;
		while (prev.next != null && prev.next.data != delete.data) {
			prev = prev.next;
		}
		if (prev.next == null) {
			System.out.println("Given node is not present in list.");
			return;
		}
		prev.next = prev.next.next;
		System.gc();
		return;
	}
	

	public void printLinkedList() {
		Node current = head;
		System.out.println();
		System.out.print("Start->");
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print("null");
	}
}
