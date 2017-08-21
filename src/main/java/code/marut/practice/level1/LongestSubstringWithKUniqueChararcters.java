package code.marut.practice.level1;

import java.util.HashMap;
import java.util.Map;

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

	public String longestSubstring_2(String in, int uniqueChars) {
		String longestSubstring = "";
		int uniqueCharCnt = 0, currSubStringlen = 0, curr = 0, max = 0;
		Map<Character, Integer> currMap = new HashMap<Character, Integer>();
		while (curr < in.length()) {
			Character c = in.charAt(curr);
			if (!currMap.containsKey(c)) {
				currMap.put(c, 1);
				uniqueCharCnt++;
			} else {
				currMap.put(c, currMap.get(c) + 1);
			}
			currSubStringlen++;
			if (currSubStringlen - 1 > max) {
				longestSubstring = in.substring(curr - currSubStringlen + 1, curr);
				max = longestSubstring.length();
			}
			while (uniqueChars < uniqueCharCnt) {
				int start = curr - currSubStringlen + 1;
				c = in.charAt(start);
				Integer cnt = currMap.get(c);
				cnt--;
				if (cnt == 0) {
					currMap.remove(c);
					uniqueCharCnt--;
				} else {
					currMap.put(c, cnt);
				}
				currSubStringlen--;
			}
			curr++;
		}
		if (currSubStringlen > max) {
			longestSubstring = in.substring(curr - currSubStringlen);
		}
		return longestSubstring;
	}

	public static void main(String[] args) {
		String in = "abccbdaadcafcdbegc";
		int uniqueChars = 3;
		String lSubs = new LongestSubstringWithKUniqueChararcters().longestSubstring(in, uniqueChars);
		System.out.println(String.format("Input String ## %s", in));
		System.out.println(String.format("Longest Substring with %d unquie chars## %s", uniqueChars, lSubs));

		lSubs = new LongestSubstringWithKUniqueChararcters().longestSubstring_2(in, uniqueChars);
		System.out.println(String.format("2_ Input String ## %s", in));
		System.out.println(String.format("2_ Longest Substring with %d unquie chars## %s", uniqueChars, lSubs));
		
		int lSubs_size = longestSubstring_EXPERIMENT(in, uniqueChars);
		System.out.println(String.format("3_ Input String ## %s", in));
		System.out.println(String.format("3_ Longest Substring with %d unquie chars## %s", uniqueChars, lSubs_size));
	}

	public static int longestSubstring_EXPERIMENT(String in, int k) {
		int cur=0,last=0,max=0, aStart=0, aEnd=0; 
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(;cur<in.length();cur++){
			Character curChar = in.charAt(cur);
			if(map.containsKey(curChar)){
				map.put(curChar, map.get(curChar)+1);
			}else{
				map.put(curChar, 1);
			}
			if(map.size()>k){
				if(cur-last>max){
					max =cur-last;
					aStart=last;aEnd=cur;
				}
				while(map.size()>k){
					if(map.get(in.charAt(last))>1){
						map.put(in.charAt(last), map.get(in.charAt(last))-1);
					}else{
						map.remove(in.charAt(last));
					}
					last++;
				}
			}
		}
		System.out.println(String.format("Longest Substring in %s with %d unique chars # %s", in, k, in.substring(aStart, aEnd)));
		
		return max;
	}
}
