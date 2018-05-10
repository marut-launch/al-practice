package code.marut.practice.strings;

/*
 * Write a method to decide if two strings are anagrams or not.
 */
public class CheckStringsAreAnagrams {

	public static boolean areStringAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] c1 = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			int ind = (int)s1.charAt(i);
			++c1[ind];
		}
		for (int i = 0; i < s2.length(); i++) {
			int ind = (int)s2.charAt(i);
			if (c1[ind] > 0) {
				--c1[ind];
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String test1 = "abcdCa#";
		String atest1 = "dacaCb#";
		System.out.println(String.format("String %s and %s are %s", test1, atest1,
				(areStringAnagram(test1, atest1) ? "Anagrams." : "Not Anagrams")));
	}
}
