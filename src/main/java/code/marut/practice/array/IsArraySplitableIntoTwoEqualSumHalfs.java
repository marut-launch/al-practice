package code.marut.practice.array;

import java.util.Arrays;

public class IsArraySplitableIntoTwoEqualSumHalfs {

	public static void main(String[] args) {
		Integer[] test1 = { 1, 2, 1, 3, 1 };
		Integer[] test2 = {4, 7, 3, 14};
		Integer[] test3 = {5, 6, 10};
		System.out.println(String.format("ARRAY %s  is splitable # %b", Arrays.asList(test1), isSplitable(test1)));
		System.out.println(String.format("ARRAY %s  is splitable # %b", Arrays.asList(test2), isSplitable(test2)));
		System.out.println(String.format("ARRAY %s  is splitable # %b", Arrays.asList(test3), isSplitable(test3)));
	}

	public static boolean isSplitable(Integer[] arr) {
		if (arr == null || arr.length <= 1) {
			return false;
		}
		int l = 0, r = arr.length - 1, diff = 0;
		while (l <= r) {
			if (diff == 0) {
				diff = (arr[l] - arr[r]);
				l++;
				r--;
			} else if (diff < 0) {
				diff += arr[l];
				l++;
			} else {
				diff -= arr[r];
				r--;
			}
		}

		if (diff == 0) {
			return true;
		}
		return false;
	}
}
