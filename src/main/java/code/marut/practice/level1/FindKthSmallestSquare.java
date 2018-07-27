package code.marut.practice.level1;

public class FindKthSmallestSquare {

	/*
	 * Given a sorted array of integers, find kth smallest square of the integer. k
	 * starts from 0
	 * 
	 * Example: {-9, -8, -4, -3, -1, 2, 5, 6, 10} k = 2 answer: (-3) * (-3) = 9
	 */

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		int[] test1 = { -9, -8, -4, -3, -1, 2, 5, 6, 10 };
		int[] test2 = { -9};
		int[] test3 = { -9, -8, -4, -3, -1};
		System.out.println("SQUARE #" + findKthSmallestSquare(test3, 1));

	}

	public static int findKthSmallestSquare(int[] nums, int k) {
		// Validate input arr

		int pivotIndex = searchPivotIndex(nums), l = -1, r = -1;
		if (pivotIndex == 0) {
			l = 0;
			r = 1;
		} else if (pivotIndex == nums.length - 1) {
			l = nums.length - 2;
			r = nums.length - 1;
		} else {
			if (nums[pivotIndex] < 0) {
				l = pivotIndex;
				r = pivotIndex + 1;
			} else {
				l = pivotIndex - 1;
				r = pivotIndex;
			}
		}
		int cnt = -1, curIndex = -1;
		while (true) {
			if (r < nums.length && l >= 0) {
				if (Math.abs(nums[l]) > Math.abs(nums[r])) {
					curIndex = r;
					r++;
				} else {
					curIndex = l;
					l--;
				}
			} else if (r < nums.length) {
				curIndex = r;
				r++;
			} else {
				curIndex = l;
				l--;
			}
			cnt++;
			if (cnt == k) {
				return nums[curIndex] * nums[curIndex];
			}
		}
	}

	public static int searchPivotIndex(int[] num) {
		int l = 0, r = num.length - 1;
		int mid = 0;
		while (l <= r) {
			mid = (l + r) / 2;
			System.out.println("" + l + r + mid);
			if (num[mid] > 0 && (mid - 1 > 0 && num[mid - 1] > 0) && (mid + 1 < num.length && num[mid + 1] > 0)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return mid;
	}
}
