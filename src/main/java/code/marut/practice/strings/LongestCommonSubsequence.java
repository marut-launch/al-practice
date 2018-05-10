package code.marut.practice.strings;

public class LongestCommonSubsequence {
	private static class Recursion {
		public static String lcs(String s1, String s2) {
			return lcs(s1, s2, 0, 0);
		}

		public static String lcs(String s1, String s2, int i1, int i2) {
			if (i1 >= s1.length() || i2 >= s2.length()) {
				return "";
			}
			if (s1.charAt(i1) == s2.charAt(i2)) {
				return s1.charAt(i1) + lcs(s1, s2, ++i1, ++i2);
			} else {
				String l1 = lcs(s1, s2, ++i1, i2);
				String l2 = lcs(s1, s2, i1, ++i2);
				if (l1.length() > l2.length()) {
					return l1;
				} else {
					return l2;
				}
			}
		}
	}
	
	private static class DP {
		public static String lcs(String s1, String s2){
			String[][] lcs = new String [s1.length()+1][s2.length()+1];
			for(int i=s1.length();i>=0;i--){
				for(int j=s2.length();j>=0;j--){
					if(i==s1.length()||j==s2.length()){
						lcs[i][j]="";
					}else if(s1.charAt(i)==s2.charAt(j)){
						lcs[i][j]=s1.charAt(i)+lcs[i+1][j];
					}else{
						lcs[i][j]=(lcs[i+1][j].length()>lcs[i][j+1].length()?lcs[i+1][j]:lcs[i][j+1]) ;
					}
				}
			}
			return lcs[0][0];
		}
	}
	
	public static void main(String[] args) {
		String s1="AACBE";
		String s2="ACDE";
		
		System.out.println(String.format("LCM of %s, %s ## %s", s1, s2, Recursion.lcs(s1, s2)));
		System.out.println(String.format("LCM of %s, %s ## %s", s1, s2, DP.lcs(s1, s2)));
	}
}
