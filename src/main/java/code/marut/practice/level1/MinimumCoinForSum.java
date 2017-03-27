package code.marut.practice.level1;

/*
 * Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. 
 * Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want), 
 * or report that it’s not possible to select coins in such a way that they sum up to S.
 */
public class MinimumCoinForSum {

	public static int[] coinValues = { 2, 5 };

	public static int minCoinsForTotal(int sum) {
		int[] min = new int[sum + 1];
		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j < coinValues.length; j++) {
				if (coinValues[j] <= i && (i - coinValues[j]) >= 0 && (min[i - coinValues[j]] > 0 || coinValues[j] == i)
						&& (min[i] == 0 || min[i - coinValues[j]] + 1 < min[i])) {
					min[i] = min[i - coinValues[j]] + 1;
				}
			}
		}
		return min[sum];
	}

	public static void main(String[] args) {
		int sum = 17;
		System.out.println(String.format("SUM %d can be sumed up by %d minimum coins", sum, minCoinsForTotal(sum)));
	}
}
