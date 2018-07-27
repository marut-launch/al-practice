package code.marut.practice.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	private static int max = 0;
	private static int maxIndex = 0;
	private static List<Integer>[] maxArr;

	public static void _lis(int[] arr, int n) {
		if (maxArr[n] != null) {
			return;
		}
		if (n == 0) {
			if (maxArr[n] == null)
				maxArr[n] = new ArrayList<>();
			maxArr[n].add(arr[n]);
			return;
		}
		
		maxArr[n] = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			_lis(arr, i);
			if (arr[i] < arr[n] && maxArr[n].size() < (1 + maxArr[i].size())) {
				maxArr[n] = new ArrayList<>();
				maxArr[n].addAll(maxArr[i]);
				maxArr[n].add(arr[n]);
			}
		}
		if(maxArr[n].size()==0) {
			maxArr[n].add(arr[n]);
		}
		if (max < maxArr[n].size()) {
			maxIndex =n ;
			max = maxArr[n].size();
		}
	}

	public static int lis(int[] arr) {
		max = 0;
		maxArr = new List[arr.length];
		_lis(arr, arr.length - 1);
		System.out.println("LIS ##" + maxArr[maxIndex]);
		return max;
	}

	public static void main(String[] args) {
		 int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
//		 int arr[] = { 10, 22, 9, 33};
		// int arr[] = { 10};
//		int arr[] = { 10, 9 };

		System.out.println("LIS size ## " + lis(arr));
	}

}
