package code.marut.practice.dynamic_programming;

/*
	Consider a row of n coins of values v1 . . . vn, where n is even. 
	We play a game against an opponent by alternating turns. In each turn, 
	a player selects either the first or last coin from the row, removes it from 
	the row permanently, and receives the value of the coin. Determine the maximum 
	possible amount of money we can definitely win if we move first.
 */
public class OptimalStrategyForAGame {

	public static void main(String[] args) {
		long arr1[] = { 8, 15, 3, 7 };
		System.out.println(findOptimalStrategy(arr1));
		long arr2[] = { 2, 2, 2, 2 };
		System.out.println(findOptimalStrategy(arr2));
		long arr3[] = { 20, 30, 2, 2, 2, 10 };
		System.out.println(findOptimalStrategy(arr3));
	}

	public static long findOptimalStrategy(long[] numbers) {
		int n = numbers.length;
		return Math.max(numbers[0] + findMinSum(numbers, 1, n - 1), numbers[n - 1] + findMinSum(numbers, 0, n - 2));
	}

	public static long findMinSum(long[] numbers, int start, int end) {
		long sum = 0;
		int swtch = 0;
		while (end > start) {
			if (swtch == 1) {
				if (numbers[start] >= numbers[end]) {
					sum += numbers[start];
					start++;
				} else {
					sum += numbers[end];
					end--;
				}
			} else {
				if (numbers[start] >= numbers[end]) {
					start++;
				} else {
					end--;
				}
			}
			swtch = (swtch + 1) % 2;
		}
		return sum;
	}

}
