package code.marut.practice.level1;

/*
Validate if a given string is numeric.
Some examples:
"0"   > true 
"0.1" > true 
"abc" > false

A string could be divided into these four substrings in the order from left to right:
s1. Leading whitespaces (optional).
s2. Plus (+) or minus (–) sign (optional).
s3. Number.
s4. Optional trailing whitespaces (optional).

*/
public class IsValidNumber {

	public static boolean isValidNumber(String numStr) {

		int i = 0, n = numStr.length();
		while (i < n && Character.isWhitespace(numStr.charAt(i)))
			i++;
		if (i < n && (numStr.charAt(i) == '+' || numStr.charAt(i) == '-'))
			i++;
		boolean isNumeric = false;
		while (i < n && Character.isDigit(numStr.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && numStr.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(numStr.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < n && Character.isWhitespace(numStr.charAt(i)))
			i++;
		return isNumeric && i == n;
	}

	public static void main(String[] args) {
		String numStr = "12121";
		System.out.println(String.format("String %s is numeric # %s", numStr, isValidNumber(numStr)));
	}
}
