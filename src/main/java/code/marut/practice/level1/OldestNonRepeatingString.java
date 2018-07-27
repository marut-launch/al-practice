package code.marut.practice.level1;
/*
Stream of strings are pushed, you need to write two function put and get.
put will be called for each incoming string.
get will return oldest non repeating string.


Example: 

s1 -> get returns s1
s1,s2 -> get returns s1
s1,s2,s3 -> get returns s1
s1,s2,s3,s2 -> get returns s1
s1,s2,s3,s2,s1 -> get returns s3
s1,s2,s3,s2,s1,s3 -> get returns null
 */

import java.util.HashMap;
import java.util.Map;

public class OldestNonRepeatingString {

	private static class DoubleLinkedList{
		String data;
		DoubleLinkedList prev;
		DoubleLinkedList next;
		public DoubleLinkedList(String data) {
			this.data = data;
		}
	}
	
	DoubleLinkedList start;
	DoubleLinkedList last;
	Map<String, DoubleLinkedList> existingStrings;
	
	public OldestNonRepeatingString() {
		existingStrings = new HashMap<>();
	}
	
	public void put(String data) {
		if(start==null) {
			start = new DoubleLinkedList(data);
			last = start;
			existingStrings.put(data, start);
		}else {
			if(existingStrings.containsKey(data)) {
				removeFromOrder(existingStrings.get(data));
			}else {
				DoubleLinkedList node = new DoubleLinkedList(data);
				insertInOrder(node);
				existingStrings.put(data, node);
			}
		}
	}
	
	private void removeFromOrder(DoubleLinkedList node) {
		if(node.next==null) {
			last = node.prev;
		}
		if(node.prev!=null) {
			node.prev.next = node.next;
		}else {
			start = node.next;
		}
		if(node.next!=null) {
			node.next.prev = node.prev;
		}
	}

	private void insertInOrder(DoubleLinkedList node) {
		node.next = start;
		start.prev = node;
		start = node;
	}
	
	public String get() {
		if(last!=null) {
			return last.data;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DATA[");
		DoubleLinkedList temp = start;
		while(temp!=null) {
			sb.append(temp.data).append(" ");
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		OldestNonRepeatingString nonRepeat = new OldestNonRepeatingString();
		nonRepeat.put("s1");
		System.out.println(nonRepeat + " >>> GET "+ nonRepeat.get());
		nonRepeat.put("s2");
		System.out.println(nonRepeat + " >>> GET "+ nonRepeat.get());
		nonRepeat.put("s3");
		System.out.println(nonRepeat + " >>> GET "+ nonRepeat.get());
		nonRepeat.put("s1");
		System.out.println(nonRepeat + " >>> GET "+ nonRepeat.get());
		nonRepeat.put("s3");
		System.out.println(nonRepeat + " >>> GET "+ nonRepeat.get());

	}
}
