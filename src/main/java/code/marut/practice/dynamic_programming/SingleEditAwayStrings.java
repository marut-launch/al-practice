package code.marut.practice.dynamic_programming;

/*
Given two strings S and T, determine if they are both one edit distance apart.
*/
public class SingleEditAwayStrings {

	public static boolean isSingleEdit(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (m > n) {
			return isSingleEdit(t, s);
		}
		if (n - m > 1)
			return false;
		int i = 0, shift = n - m;
		while (i < m && s.charAt(i) == t.charAt(i))
			i++;
		if (i == m)
			return shift > 0;
		if (shift == 0)
			i++;
		while (i < m && s.charAt(i) == t.charAt(i + shift))
			i++;
		return i == m;
	}

	public static void main(String[] args) {
		String test_part1 = "AEBCF";
		String test_part2 = "ABCEF";

		System.out.println(String.format("Strings %s, %s is at single edit distance # %s", test_part1, test_part2,
				isSingleEdit(test_part1, test_part2)));
	}
}
