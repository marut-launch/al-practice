package code.marut.practice.level1;

import java.util.Arrays;

public class MaximumSumSubarray {

	public static int maxSubArrSum(Integer[] arr) {
		int maxSoFar = arr[0];
		int maxEndHere = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEndHere = Math.max(maxEndHere + arr[i], arr[i]);
			maxSoFar = Math.max(maxEndHere, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		Integer[] arr = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(String.format("Array %s max sum of sub array # %d", Arrays.asList(arr), maxSubArrSum(arr)));
	}
}
