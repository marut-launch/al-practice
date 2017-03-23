package code.marut.practice.dynamic_programming;

public class LongestSubstringWithoutRepeatingChars {

	public static int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int[] marker = new int[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if(marker[s.charAt(j)]>=i){
				i = marker[s.charAt(j)]+1;
			}
			marker[s.charAt(j)]=j;
			maxLen= Math.max(j-i+1, maxLen);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String test1 = "abcbbbbbacdbbbefg";
		System.out.println("LONGEST SUBSTRING LEN ##" + lengthOfLongestSubstring(test1));
		System.out.println("LONGEST SUBSTRING LEN ##" + lengthOfLongestSubstring2(test1));
	}
}
