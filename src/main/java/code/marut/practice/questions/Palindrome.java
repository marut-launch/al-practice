package code.marut.practice.questions;

import org.junit.Assert;

public class Palindrome {

	public static boolean isValidPalindrome(String str) {
		if (str == null) {
			return false;
		}
		int i = 0, j = str.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(str.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(str.charAt(j))) {
				j--;
			}
			if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String test1 = "tet";
		String test2 = "t et";
		String test3 = "A man, a plan, a canal: Panama";
		String test4 = "race a car";
		
		Assert.assertTrue(isValidPalindrome(test1));
		Assert.assertTrue(isValidPalindrome(test2));
		Assert.assertTrue(isValidPalindrome(test3));
		Assert.assertFalse(isValidPalindrome(test4));
		System.out.println("ALL TESTED PASSED...");
	}
}
