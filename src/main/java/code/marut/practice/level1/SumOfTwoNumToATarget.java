package code.marut.practice.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
 */
public class SumOfTwoNumToATarget {

	public static void printNumIndices_bruteforce_n2_complexity(int[] numbers, int target) {
		boolean found = false;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					System.out.println(String.format("Found numbers at indexes %s, %s", i, j));
					found = true;
					break;
				}
				if (found) {
					break;
				}
			}
		}
		if (!found) {
			System.out.println("Target not found.");
		}
	}

	public static void printNumIndices_usingMap_n_complexity(int[] numbers, int target) {
		Map<Integer, Integer> ind = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (ind.containsKey(target - numbers[i])) {
				System.out.println(String.format("Found numbers at indices %s, %s", i, ind.get(target - numbers[i])));
				break;
			}
			ind.put(numbers[i], i);
		}
	}

	public static void printNumIndices_usingBSearch_n_complexity(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			int targetInd = binarySearch(numbers, i + 1, target - numbers[i]);
			if (targetInd != -1) {
				System.out.println(String.format("Found numbers at indices %s, %s", i, targetInd));
				break;
			}
		}
	}

	public static void printNumIndices_sortedArr_n_complexity(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (l < r) {
			if (numbers[l] + numbers[r] > target) {
				r--;
			} else if (numbers[l] + numbers[r] < target) {
				l++;
			} else {
				System.out.println(String.format("Found numbers at indices %s, %s", l, r));
				break;
			}
		}
	}

	public static int binarySearch(int[] numbers, int start, int search) {
		int L = start, R = numbers.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (numbers[M] < search) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (L == R && numbers[L] == search) ? L : -1;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 5, 6, 2, 9, 7 };
		printArray(numbers);
		printNumIndices_bruteforce_n2_complexity(numbers, 7);
		printNumIndices_usingMap_n_complexity(numbers, 7);
		Arrays.sort(numbers);
		printArray(numbers);
		printNumIndices_usingBSearch_n_complexity(numbers, 7);
		printNumIndices_sortedArr_n_complexity(numbers, 7);
	}

	public static void printArray(int[] numbers) {
		if (numbers != null) {
			System.out.print("[");
			for (int num : numbers) {
				System.out.print(num + ",");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}