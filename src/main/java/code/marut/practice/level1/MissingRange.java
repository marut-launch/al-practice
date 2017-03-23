package code.marut.practice.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Question:
Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]

 */
public class MissingRange {

	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList();
		int prev = start - 1;
		for (int i = 0; i <= vals.length; i++) {
			int curr = (i == vals.length) ? end + 1 : vals[i];
			if (curr - prev >= 2) {
				ranges.add(getRange(prev + 1, curr - 1));
			}
			prev = curr;
		}
		return ranges;
	}

	private static String getRange(int from, int to) {
		return (from == to) ? String.valueOf(from) : from + "->" + to;
	}

	public static List<String> missingRange(int[] nums) {
		List<String> missingRange = new ArrayList();
		if (nums != null && nums.length == 0) {
			missingRange.add("0=99");
		} else {
			for (int i = 0; i < nums.length; i++) {
				int next = 100;
				String range = null;
				if (i != nums.length - 1) {
					next = nums[i + 1];
				}
				if (next - nums[i] > 1) {
					range = "" + (nums[i] + 1);
					if (next - nums[i] > 2) {
						range += "-" + (next - 1);
					}
				}
				if (range != null) {
					missingRange.add(range);
				}
			}
		}
		return missingRange;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };
		System.out.println("NUMBERS ## " + Arrays.asList(nums));
		System.out.println("RANGE LIST ## " + missingRange(nums));
		
		System.out.println("RANGE LIST2 ## " + findMissingRanges(nums, 0, 99));
	}
}
