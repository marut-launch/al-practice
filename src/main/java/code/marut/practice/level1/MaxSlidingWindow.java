package code.marut.practice.level1;

import java.util.LinkedList;

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.poll();
			}
			if (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
				deque.removeLast();
			}
			deque.offer(i);
			if (i + 1 >= k) {
				res[i + 1 - k] = nums[deque.peek()];
			}
		}
		return res;
	}
}
