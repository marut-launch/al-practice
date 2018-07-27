package code.marut.practice.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

	public static int editDistanceDP(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void printEditDistanceDP(String s1, String s2) {
		System.out.println(String.format("S1 # %s, S2 # %s, Edit Distance # %d", s1, s2, editDistanceDP(s1, s2)));
	}

	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturday";
		printEditDistanceDP(s1, s2);
		editDistanceRecursive(s1, s2);
	}

	private static void editDistanceRecursive(String s1, String s2) {
		Map<String, Integer> mem = new HashMap<>();
		int editDistance = editDistanceRecursive(s1, s2, s1.length() - 1, s2.length() - 1, mem);
		System.out.println(String.format("RECURSIVE --> S1 # %s, S2 # %s, Edit Distance # %d", s1, s2, editDistance));
	}

	private static int editDistanceRecursive(String s1, String s2, int index1, int index2, Map<String, Integer> mem) {
		String key = index1 + "-" + index2;
		int value = 0;
		if (mem.containsKey(key)) {
			System.out.println(String.format("RECURSIVE --> Found value for key [%s] -- [%d]", key, mem.get(key)));
			return mem.get(key);
		} else if (index1 < 0) {
			value = index2 + 1;
		} else if (index2 < 0) {
			value = index1 + 1;
		} else if (s1.charAt(index1) == s2.charAt(index2)) {
			value = editDistanceRecursive(s1, s2, index1 - 1, index2 - 1, mem);
		} else {
			value = 1 + Math.min(
					Math.min(editDistanceRecursive(s1, s2, index1 - 1, index2, mem),
							editDistanceRecursive(s1, s2, index1, index2 - 1, mem)),
					editDistanceRecursive(s1, s2, index1 - 1, index2 - 1, mem));
		}
		mem.put(key, value);
		return mem.get(key);

	}

}
