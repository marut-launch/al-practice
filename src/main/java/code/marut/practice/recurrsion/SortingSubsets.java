package code.marut.practice.recurrsion;

import java.util.Arrays;

/*
You are given a Integer[] a. The elements of a are not necessarily distinct.
You want to rearrange the elements of a into a non-decreasing order. What is the smallest possible number of elements you have to move?
Formally, the operation looks as follows:
You select some set of positions in a.
You permute the elements on the chosen positions arbitrarily.
Compute and return the smallest possible size of the set of selected positions.

Class:	SortingSubsets
Method:	getMinimalSize
Parameters:	Integer[]
Returns:	int
Method signature:	int getMinimalSize(Integer[] a)
(be sure your method is public)
 */
public class SortingSubsets {
	public static int getMinimalSize(Integer[] a) {
		int size = 0;
		Integer[] sorted = Arrays.copyOf(a, a.length);
		Arrays.sort(sorted);
		for (int i = 0; i < a.length; i++) {
			if (sorted[i] != a[i]) {
				size++;
			}
		}
		return size;
	}

	public static void main(String[] args) {
		printExecute(new Integer[] { 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52,
				52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52 });
		printExecute(new Integer[] { 96, 96, 96, 34, 96, 34, 34, 34, 96 });
		printExecute(new Integer[] { 91, 37, 37, 37, 37, 91, 91, 29, 37, 91, 37, 29, 29, 37, 91, 29, 91, 37, 37, 29, 37, 91,
				91, 91, 29, 29, 37, 37, 37, 91, 29, 37, 37, 91, 29, 91, 29 });
		printExecute(new Integer[] { 11, 11, 49, 7, 11, 11, 7, 7, 11, 49, 11 });
		printExecute(new Integer[] { 90, 95, 95, 73, 95, 21, 89, 90, 73, 21, 95, 90, 73, 95, 21, 89, 89, 73, 95, 73, 90, 90,
				21, 73, 73, 95, 89, 90, 73, 89, 90, 89, 90, 89, 89, 73, 95, 89, 90 });
		printExecute(new Integer[] { 67, 18, 54, 54, 54, 54, 38, 54, 71, 13, 18, 38, 38, 62, 21, 54, 7, 21 });
		printExecute(new Integer[] { 99, 78, 19, 84, 34, 34, 100, 72, 4, 78, 38, 99, 84, 90, 38, 72, 84, 50, 34, 19, 84, 72,
				72, 50, 50, 40, 34, 54, 57, 100, 38, 16, 60, 84, 72, 57, 50, 38, 19, 78 });
		printExecute(new Integer[] { 98, 85, 61, 92, 83 });
		printExecute(new Integer[] { 4, 81, 22, 33, 91, 54, 22, 84, 67, 16, 95, 100, 6, 71, 77, 97, 94, 35, 39, 36, 67, 4,
				3, 3, 95, 28, 49, 98, 34, 95, 13, 73, 4, 72, 95, 50, 58, 4, 6, 36, 28, 36, 22, 4, 44, 95, 33, 71, 99,
				50 });
		printExecute(new Integer[] { 1, 1, 1, 3, 3, 3, 8, 14, 18, 20, 21, 22, 22, 25, 26, 27, 31, 32, 36, 45, 45, 47, 48,
				49, 49, 49, 50, 50, 51, 53, 53, 54, 56, 65, 66, 68, 75, 75, 76, 79, 81, 81, 81, 81, 81, 84, 89, 90, 98,
				99 });
		printExecute(new Integer[] { 1, 3, 20, 20, 23, 23, 24, 24, 32, 32, 32, 34, 38, 39, 39, 42, 45, 45, 47, 47, 54, 54,
				56, 57, 57, 57, 58, 67, 67, 67, 67, 70, 70, 71, 71, 71, 74, 81, 87, 95, 99 });
		printExecute(new Integer[] { 13, 18, 38, 54, 54, 54, 54, 54, 67, 71 });
		printExecute(new Integer[] { 36, 65, 31, 54, 79, 90, 48, 66, 15, 80, 73, 1, 75, 91, 27, 86, 85, 41, 45, 26, 56, 14,
				89, 96, 51, 98, 39, 25, 68, 72, 8, 76, 22, 99, 83, 10, 3, 32, 84, 50, 81, 49, 100, 20, 18, 21, 47, 40,
				53, 52 });
		printExecute(new Integer[] { 100, 14, 3, 64, 79, 70, 91, 30, 72, 28, 25, 89, 2, 5, 78, 37, 40, 73, 81, 23, 9, 57,
				93, 4, 82, 41, 98, 80, 67, 11, 94, 44, 1, 50, 52, 18, 22, 15, 16 });
		printExecute(new Integer[] { 40, 16, 19, 84, 72, 50, 99, 10, 1, 4, 100, 60, 57, 34, 78, 93, 54, 38, 81, 90 });
		printExecute(new Integer[] { 91, 37, 87 });
	}

	public static void printExecute(Integer[] e) {
		System.out.println(String.format("ARRAY >> %s << MIN SUBSET SIZE >> %d", Arrays.asList(e), getMinimalSize(e)));
	}
}
