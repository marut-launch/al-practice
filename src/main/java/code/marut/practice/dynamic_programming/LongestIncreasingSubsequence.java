package code.marut.practice.dynamic_programming;

public class LongestIncreasingSubsequence {

	private static int max = 1;

	public static int _lis(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}
		int curr = 1;
		for (int i = 0; i < n - 1; i++) {
			int sub = _lis(arr, i);
			if (arr[i] < arr[n - 1] && curr < (1 + sub)) {
				curr = sub + 1;
			}
		}
		if (max < curr) {
			max = curr;
		}
		return curr;
	}

	public static int lis(int[] arr) {
		max = 1;
		max = _lis(arr, arr.length);
		return max;
	}

	public static void main(String[] args) {
//		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
//		int arr[] = { 10};
		int arr[] = { 10, 9};

		System.out.println("LIS size ## " + lis(arr));
	}

}
