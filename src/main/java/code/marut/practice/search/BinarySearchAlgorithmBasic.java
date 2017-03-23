package code.marut.practice.search;

import java.util.Arrays;

public class BinarySearchAlgorithmBasic {

	public static void main(String[] args) {
		Integer[] sortedNums1 = { 18, 17, 32, 36, 37, 41, 45, 49, 57, 69, 73, 85, 86, 99, 10000 };
		printSearchRes(100, sortedNums1);
	}

	public static void printSearchRes(int number, Integer[] sortedNums) {
		System.out.println(String.format("SORTED ARRAY : %s", Arrays.asList(sortedNums)));
		int ind = binarySearch(number, sortedNums);
		System.out.println(String.format("SEARCHED NUMBER : %d %s", number,
				(ind == -1 ? "NOT FOUND" : "FOUND AT " + ind + " INDEX.")));
	}

	public static int binarySearch(int number, Integer[] sortedNums) {
		int low = 0, high = sortedNums.length - 1;
		while (low <= high) {
			int mid = (high + low )/ 2;
			System.out.println(String.format("%d, %d, %d", low, high, mid));
			if (sortedNums[mid] == number) {
				return mid;
			}
			if (number > sortedNums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
