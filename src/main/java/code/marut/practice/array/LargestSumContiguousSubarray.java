package code.marut.practice.array;

import java.util.Arrays;

public class LargestSumContiguousSubarray {

	public static int largestSumContiguousSubarray(Integer[] in) {
		int max = 0, maxEndHere = 0, negMax = Integer.MIN_VALUE;
		for (int cur : in) {
			if (cur < 0 && negMax != 0 && negMax < cur)
				negMax = cur;
			else if (cur > 0)
				negMax = 0;

			maxEndHere += cur;
			if (maxEndHere < 0)
				maxEndHere = 0;
			if (max < maxEndHere)
				max = maxEndHere;
		}
		return (max == 0 ? negMax : max);
	}

	public static void printLargestSum(Integer[] in) {
		System.out.println("INPUT ## " + Arrays.asList(in));
		System.out.println("MAX SUM ## " + largestSumContiguousSubarray(in));
	}

	public static void main(String[] args) {
		printLargestSum(new Integer[] { -2, -3, 4, -1, -2, 1, 5, -3 });
		printLargestSum(new Integer[] { -2, -3, -1, -2 });
	}
}
