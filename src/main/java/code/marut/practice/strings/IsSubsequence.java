package code.marut.practice.strings;

public class IsSubsequence {

	private static class Recurrsive {

		public static boolean isSequence(String s1, String s2, int i1, int i2) {
			if (i2 > s2.length() - 1) {
				return true;
			}
			if (i1 >= s1.length()) {
				return false;
			}
			if (s1.charAt(i1) == s2.charAt(i2)) {
				return isSequence(s1, s2, ++i1, ++i2);
			} else {
				return isSequence(s1, s2, ++i1, i2);
			}
		}

	}
	
	private static class Iterative{
		public static boolean isSequence(String s1, String s2) {
			int j=0;
			for (int i =0;i<s1.length() && j<s2.length();i++){
				if(s1.charAt(i)==s2.charAt(j)){
					j++;
				}
			}
			return (j==s2.length());
		}
	}

	public static void main(String[] args) {

		String input = "geeksforgeeks";
		String search = "gksreks";

		System.out.println(String.format("RECURSIVE >>> %s is subsequence of %s : %b", search, input,
				Recurrsive.isSequence(input, search, 0, 0)));
		System.out.println(String.format("ITERATIVE >>> %s is subsequence of %s : %b", search, input,
				Iterative.isSequence(input, search)));
	}
}
