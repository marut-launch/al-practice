package code.marut.practice.dynamic_programming;

import java.util.Arrays;

public class maximumApplesCollection {

	public static void printMaxApples(Integer[][] apples) {
		System.out.println("APPLES # " + Arrays.asList(apples));
		System.out.println("MAX COLLECTION # " + maxApplesCollection(apples));
	}

	public static int maxApplesCollection(Integer[][] apples) {
		int n = apples.length;
		int m = apples[0].length;
		int[][] max = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max[i][j] = apples[i][j] + Math.max((i == 0 ? 0 : max[i - 1][j]), (j == 0 ? 0 : max[i][j - 1]));
			}
		}
		return max[n - 1][m - 1];
	}

	public static void main(String[] args) {
		Integer[][] applesTest1 = { { 7, 2, 7, 2 }, { 1, 9, 2, 0 }, { 1, 8, 5, 11 } };
		printMaxApples(applesTest1);
	}
}
