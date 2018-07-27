package code.marut.ques;
//Given a string of 0s, 1s, and ?s (wildcards), generate all 0-1 strings that match a pattern.
//		E.g., 1?00?101 → [10000101, 10001101, 11000101, 11001101]. 
//You can generate the strings in any order that suits you. 

import java.util.ArrayList;
import java.util.List;

public class GG {
	public static void main(String[] args) {
		String input="???";
		List<String> strs = new GG().generateStrings(input);
		System.out.println("INPUT #"+input);
		System.out.println("OUTPUT#"+strs);
	}
	public List<String> generateStrings(String wildCardString) {
		int totalWildCardChars = countWildCardChars(wildCardString);
		System.out.println("totalWildCardChars ##" + totalWildCardChars);
		if (totalWildCardChars == 0) {
			return new ArrayList<String>();
		}
		List<String> perms = generatePerms(totalWildCardChars);
		return generateStrings(wildCardString, perms);
	}

	List<String> generateStrings(String wildCardString, List<String> perms) {
		List<String> allPerms = new ArrayList<>();
		for (String perm : perms) {
			int temp = 0;
			String tempString = "";
			for (char c : wildCardString.toCharArray()) {
				if (c == '?') {
					tempString += perm.charAt(temp++);
				} else {
					tempString += c;
				}
			}
			allPerms.add(tempString);
		}
		return allPerms;

	}

	int countWildCardChars(String wildCardString) {
		if (wildCardString == null || wildCardString.length() == 0) {
			return 0;
		}
		int cnt = 0;
		for (int i = 0; i < wildCardString.length() ; i++) {
			if (wildCardString.charAt(i) == '?')
				cnt++;
		}
		return cnt;
	}

	List<String> generatePerms(int cnt) {
		return perm("", cnt);
	}

	List<String> perm(String prefix, int index) {
		List<String> perm = new ArrayList<String>();
		if (index == 1) {
			perm.add(prefix + '0');
			perm.add(prefix + '1');
			return perm;
		}
		perm.addAll(perm(prefix + '0', index - 1));
		perm.addAll(perm(prefix + '1', index - 1));
		return perm;
	}

}
