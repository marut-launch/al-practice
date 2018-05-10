package code.marut.practice.strings;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.AttributeSet.CharacterAttribute;

/*
 * Small String = abbc
 * big String= babcabbacaabcbabcacbb
 * babc, bcab, cabb, bbac,abcb,bcba,cbab, acbb
 */

public class FindPermutationsOfSmallStringInBigString {
	public static void main(String[] args) {
		// String smallString = "ab";
		// String bigString = "bab";
		String smallString = "abbc";
		String bigString = "babcabbacaabcbabcacbb";
		// String bigString = "babcb";
		findAllPerms(smallString, bigString);
	}

	public static void findAllPerms(String smallString, String bigString) {
		int start = 0, end = -1, len = smallString.length();

		Map<Character, Integer> search = new HashMap<>();
		Map<Character, Integer> currentSearch = new HashMap<>();
		smallString.chars().forEach(c -> {
			Character cur = new Character((char) c);
			if (!search.containsKey(cur)) {
				search.put(cur, 1);
			} else {
				search.put(cur, search.get(cur) + 1);
			}
		});
		for (Character c : bigString.toCharArray()) {
			if (currentSearch.containsKey(c)) {
				if (currentSearch.get(c) < search.get(c)) {
					currentSearch.put(c, currentSearch.get(c) + 1);
					end++;
				} else {
					while (start < end) {
						Character sChar = bigString.charAt(start);
						if (sChar == c) {
							start++;
							end++;
							break;
						} else {
							if (currentSearch.get(sChar) == 1) {
								currentSearch.remove(sChar);
							} else {
								currentSearch.put(sChar, currentSearch.get(sChar) - 1);
							}
							start++;
						}
					}
				}
			} else if (search.containsKey(c)) {
				currentSearch.put(c, 1);
				end++;
			} else {
				end++;
				start = end + 1;
				currentSearch.clear();
			}
			if (end - start == len - 1) {
				System.out.println(bigString.substring(start, start + len));
				Character cStart = bigString.charAt(start);
				if (currentSearch.get(cStart) == 1) {
					currentSearch.remove(cStart);
				} else {
					currentSearch.put(cStart, currentSearch.get(cStart) - 1);
				}
				start++;
			}
		}
	}
}
