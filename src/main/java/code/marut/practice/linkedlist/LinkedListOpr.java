package code.marut.practice.linkedlist;

import java.util.Stack;

import code.marut.practice.linkedlist.LinkedList.Node;

public class LinkedListOpr {

	public static LinkedList insertOp() {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(20);
		ll.insertAtEnd(40);
		ll.insertAtEnd(50);
		ll.insertAtEnd(70);
		ll.insertAtEnd(10);
		ll.insertAtEnd(13);
		ll.insertAtEnd(19);
		ll.insertAtEnd(99);
		ll.printLinkedList();
		return ll;
	}

	public static long addTwoLinkedList(LinkedList first, LinkedList second) {
		String total = "";
		Stack<Node> fNodes = new Stack<LinkedList.Node>();
		Stack<Node> sNodes = new Stack<LinkedList.Node>();
		Node cur = null;
		if (first != null && first.head != null) {
			cur = first.head;
			while (cur != null) {
				fNodes.push(cur);
				cur = cur.next;
			}
		}
		if (second != null && second.head != null) {
			cur = second.head;
			while (cur != null) {
				sNodes.push(cur);
				cur = cur.next;
			}
		}
		int carry = 0;
		while (!fNodes.isEmpty() || !sNodes.isEmpty()) {
			int f = 0;
			int s = 0;
			if (!fNodes.isEmpty()) {
				f = fNodes.pop().data;
			}
			if (!sNodes.isEmpty()) {
				s = sNodes.pop().data;
			}
			int sum = s + f + carry;
			carry = sum / 10;
			total = (sum % 10) + total;
		}
		return Long.parseLong(total);
	}

	
	public static void testLoopInList(){
		LinkedList f = new LinkedList();
		f.insertAtEnd(1);
		f.insertAtEnd(2);
		f.insertAtEnd(3);
		f.insertAtEnd(4);
		f.insertAtEnd(5);
		f.insertAtEnd(6);
		f.insertAtEnd(7);
		f.insertAtEnd(8);
		f.getNode(8).next=f.getNode(4);
		System.out.println(detectLoopInList(f));
	}
	
	/*
	 * Detect loop and remove loop from linked list
	 */
	public static boolean detectLoopInList(LinkedList ll){
		Node meetPoint = meetPoint(ll.head);
		System.out.println("MEET POINT ## " + meetPoint.data);
		if (meetPoint == null) {
			return false;
		}else{
			return true;
		}
	}
	
	private static Node meetPoint(Node start){
		Node pt1 = start.next;
		Node pt2 = null;
		if(pt1!=null){
			pt2 = start.next.next;			
		}
		Node meetPoint = null;
		while(pt1!=null && pt2!=null){
			if(pt1.equals(pt2)){
				meetPoint=pt1;
				break;
			}
			pt1=pt1.next;
			if(pt2.next!=null){
				pt2=pt2.next.next;
			}else{
				pt2=null;
			}
		}
		
		if (meetPoint != null) {
			pt1 = pt1.next;
			pt2 = pt2.next.next;
			meetPoint = start.next;
			while (!pt1.equals(pt2)) {
				pt1 = pt1.next;
				pt2 = pt2.next.next;
				meetPoint = meetPoint.next;
			}
			pt1 = start;
			while (!pt1.equals(meetPoint)) {
				pt1 = pt1.next;
				meetPoint = meetPoint.next;
			}
		}
		return meetPoint;
	}
	
	/*
	 * Reverse input number of nodes only.
	 * example > LIST > 1->2->3->4->5->6->7->8->9->10
	 * Reverse count 3 >> 3->2->1->4->5->6->7->8->9->10
	 */
	public static void reverseLinkedListGivenNodes(LinkedList ll, int cnt) {
		Node curr = ll.head;
		Node linkNode = ll.head;
		Node prev = null;
		while (curr != null && cnt > 0) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			cnt--;
		}
		linkNode.next = curr;
		ll.head = prev;
	}

	public static void main(String[] args) {
		testLoopInList();
	}

	public static void testReverseList() {
		LinkedList f = new LinkedList();
		LinkedList s = null;
		f.insertAtEnd(2);
		f.insertAtEnd(5);
		f.insertAtEnd(9);
		f.insertAtEnd(11);
		f.insertAtEnd(17);
		f.insertAtEnd(6);
		f.insertAtEnd(89);
		f.printLinkedList();
		System.out.println();
		reverseLinkedListGivenNodes(f, 5);
		f.printLinkedList();
	}

	public static void testAddList() {
		LinkedList f = new LinkedList();
		// LinkedList s = new LinkedList();
		LinkedList s = null;
		f.insertAtEnd(2);
		f.insertAtEnd(5);
		f.insertAtEnd(9);
		// s.insertAtEnd(3);s.insertAtEnd(9);
		f.printLinkedList();
		s.printLinkedList();
		System.out.println();
		System.out.println("SUM ## " + addTwoLinkedList(f, s));
	}
}