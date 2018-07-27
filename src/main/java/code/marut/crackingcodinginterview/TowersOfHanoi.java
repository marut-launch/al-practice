package code.marut.crackingcodinginterview;

import java.util.Stack;

public class TowersOfHanoi {

	public static void main(String[] args) {
		Stack<Integer> origin = new Stack<>();
		Stack<Integer> buffer = new Stack<>();
		Stack<Integer> destination = new Stack<>();
		origin.push(4); origin.push(3);origin.push(2);origin.push(1);
		printStacks(origin, buffer, destination);
		System.out.println("==========");
		moveDisks(4, origin, buffer, destination);
		printStacks(origin, buffer, destination);
	}

	public static void printStacks(Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination){
		printStacks(origin, "origin");
		printStacks(buffer, "buffer");
		printStacks(destination, "destination");
	}
	public static void printStacks(Stack<Integer> s, String name) {
		int i = 0;
		if (s.isEmpty()) {
			System.out.println(name + " is empty");
		} else {
			String value = "";
			while (i < s.size()) {
				value += s.get(i) + "" + (i == s.size() - 1 ? "" : ",");
				i++;
			}
			System.out.println(name + " = {" + value + "}");
		}
	}

	public static void moveDisks(int disks, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination) {
		if (disks <= 0)
			return;
		moveDisks(disks - 1, origin, destination, buffer);
		destination.push(origin.pop());
		moveDisks(disks - 1, buffer, origin, destination);
	}
}
