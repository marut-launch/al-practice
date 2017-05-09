package code.marut.practice.level1;

/*
	Given a input string and integer k (representing k characters) return longest substring with K unique character.
	Solution >> Keep sliding window to calculate max unique characters.
	Assumption >> 
		1) input string will contain only characters not numbers or special character
		2) All characters will be lower case.
 */
public class LongestSubstringWithKUniqueChararcters {
	public String longestSubstring(String in, int uniqueChars) {
		int start = 0, i = 0;
		Integer curUniqueCnt = 0;
		String longestSubstring = "";
		int[] cSet = new int[26];
		for (; i < in.length(); i++) {
			int cInd = (int) in.charAt(i) - 'a';
			if (curUniqueCnt < uniqueChars) {
				if (cSet[cInd] == 0) {
					curUniqueCnt = curUniqueCnt + 1;
				}
				cSet[cInd] = cSet[cInd] + 1;
			} else if (cSet[cInd] != 0) {
				if (cSet[cInd] == 0) {
					curUniqueCnt = curUniqueCnt + 1;
				}
				cSet[cInd] = cSet[cInd] + 1;
			} else {
				if ((i - start) > longestSubstring.length()) {
					longestSubstring = in.substring(start, i);
				}
				while (true) {
					int sInd = (int) in.charAt(start) - 'a';
					start++;
					cSet[sInd] = cSet[sInd] - 1;
					if (cSet[sInd] == 0) {
						curUniqueCnt = uniqueChars;
						if (cSet[cInd] == 0) {
							curUniqueCnt++;
						}
						cSet[cInd] = cSet[cInd] + 1;
						break;
					}
				}
			}
		}
		if ((i - start) > longestSubstring.length()) {
			longestSubstring = in.substring(start, i);
		}
		return longestSubstring;
	}

	public static void main(String[] args) {
		String in = "abccbdaadcafcdbegc";
		int uniqueChars = 4;
		String lSubs = new LongestSubstringWithKUniqueChararcters().longestSubstring(in, uniqueChars);
		System.out.println(String.format("Input String ## %s", in));
		System.out.println(String.format("Longest Substring with %d unquie chars## %s", uniqueChars, lSubs));
	}
}
