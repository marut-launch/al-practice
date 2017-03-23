package code.marut.practice.dynamic_programming;

/*
Question:
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
Hint:
First, make sure you understand what a palindrome means. A palindrome is a string which reads the same in both directions. 
For example, “aba” is a palindome, “abc” is not.
*/
public class LongestPalindromicSubstring {

	public static String longestPalindrome(String str) {
		if(str==null || str.length()==0 || str.length()==1){
			return str;
		}
		int start = 0, end = 0;
		for (int i = 0; i < str.length(); i++) {
			int len = expand(str, i, i);
			int len2 = expand(str, i, i + 1);
			int maxLen = Math.max(len, len2);
			if (maxLen > (end - start)) {
				start = i - (maxLen - 1) / 2;
				end = i + (maxLen / 2);
			}
		}
		return str.substring(start, end + 1);
	}

	private static int expand(String str, int left, int right) {
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static void main(String[] args) {
		String test1 = "bbaccbcaacb";
		System.out.println(String.format("%s has longest palindromic subString # %s", test1, longestPalindrome(test1)));
		String test2 = "";
		System.out.println(String.format("%s has longest palindromic subString # %s", test2, longestPalindrome(test2)));
	}

}
