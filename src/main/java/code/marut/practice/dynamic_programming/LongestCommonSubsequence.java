package code.marut.practice.dynamic_programming;

public class LongestCommonSubsequence {

	public static int recursiveLcs(char[] data1, char[] data2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (data1[m - 1] == data2[n - 1]) {
			return 1 + recursiveLcs(data1, data2, m - 1, n - 1);
		} else {
			return max(recursiveLcs(data1, data2, m - 1, n), recursiveLcs(data1, data2, m, n - 1));
		}
	}

	public static int[][] dynamicProgTabularLCS(char[] data1, char[] data2, int m, int n) {
		int[][] track = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				track[i][j] = 0;
			}
		}
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					track[i][j] = 0;
				} else if (data1[i - 1] == data2[j - 1]) {
					track[i][j] = 1 + track[i - 1][j - 1];
				} else {
					track[i][j] = max(track[i][j - 1], track[i - 1][j]);
				}
			}
		}
		return track;
	}

	public static void printLCS(char[] data1, char[] data2, int[][] lcsInx, int m, int n) {
		int i = m, j = n;
		int index = lcsInx[m][n];
		char[] lcs = new char[index + 1];
		while (i > 0 && j > 0) {
			if (data1[i - 1] == data2[j - 1]) {
				lcs[index - 1] = data1[i - 1];
				i--;j--;index--;
			} else if (lcsInx[i - 1][j] > lcsInx[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(String.format("LCS for %s and %s is ## %s",String.copyValueOf(data1),String.copyValueOf(data2), String.copyValueOf(lcs)));
	}

	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		char data1[] = "AGGTAB".toCharArray();
		char data2[] = "GXTXAYB".toCharArray();

		System.out.println(
				"Length of LCS using Recurrsive ## " + recursiveLcs(data1, data2, data1.length - 1, data2.length - 1));

		int[][] track = dynamicProgTabularLCS(data1, data2, data1.length - 1, data2.length - 1);

		System.out
				.println("Length of LCS using dynamic programming ## " + track[(data1.length - 1)][(data2.length - 1)]);

		printLCS(data1, data2, track, data1.length - 1, data2.length - 1);
	}
}
