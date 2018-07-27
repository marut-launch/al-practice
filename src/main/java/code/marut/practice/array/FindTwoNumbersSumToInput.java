package code.marut.practice.array;

public class FindTwoNumbersSumToInput {

	public static void main(String[] args) {
		int[] numbers = { 5, 12, 18, 21, 52, 88 };
		int target = 95;
		Solution1_SortedArray.printNumbersSum(numbers, target);
		Solution2_SortedArray.printNumbersSum(numbers, target);
	}

	// nlogn complexity
	public static class Solution1_SortedArray {
		public static String prefix = "SOLUTION1::";

		public static void printNumbersSum(int[] numbers, int target) {
			for (int i = 0; i < numbers.length - 1; i++) {
				int index = findNumber(numbers, target - numbers[i], i + 1, numbers.length - 1);
				if (index != -1) {
					System.out.println(prefix + "Numbers found ##" + numbers[i] + "," + numbers[index]);
					return;
				}
			}
			System.out.println(prefix + "Sum not found.");
		}

		public static int findNumber(int[] numbers, int num, int start, int end) {
			if (end <= numbers.length - 1 && start >= 0 && start <= end) {
				int mid = (start + end) / 2;
				if (numbers[mid] == num) {
					return mid;
				}
				int l = findNumber(numbers, num, start, mid - 1);
				int r = findNumber(numbers, num, mid + 1, end);
				return (l == -1 ? r : l);
			}
			return -1;
		}
	}

	// O(n)
	public static class Solution2_SortedArray {
		public static String prefix = "SOLUTION2::";

		public static void printNumbersSum(int[] numbers, int target) {
			int l = 0, r = numbers.length - 1;
			while (l < r) {
				int tSum = numbers[l] + numbers[r];
				if (tSum == target) {
					break;
				} else if (tSum > target) {
					r--;
				} else {
					l++;
				}
			}
			if (l < r) {
				System.out.println(prefix + "Numbers found ##" + numbers[l] + "," + numbers[r]);
			} else {
				System.out.println(prefix + "Sum not found.");
			}
		}
	}
}
