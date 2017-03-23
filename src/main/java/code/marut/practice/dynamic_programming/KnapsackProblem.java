package code.marut.practice.dynamic_programming;

public class KnapsackProblem {

	public static int knapSack_dp(int W, int wt[], int val[], int n) {
		int[][] k = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					k[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					k[i][j] = Math.max(val[i - 1] + k[i - 1][j - wt[i - 1]], k[i - 1][j]);
				} else {
					k[i][j] = k[i - 1][j];
				}
			}
		}
		return k[n][W];
	}

	public static void main(String args[]) {
		int val[] = new int[] { 60, 40, 20 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack_dp(W, wt, val, n));
	}
}
