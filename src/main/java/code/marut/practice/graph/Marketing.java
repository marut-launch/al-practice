package code.marut.practice.graph;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
You work for a very large company that markets many different products. In some cases, one product you market competes with another. To help deal with this 
situation you have split the intended consumers into two groups, namely Adults and Teenagers. If your company markets 2 products that compete with each other, 
selling one to Adults and the other to Teenagers will help maximize profits. Given a list of the products that compete with each other, you are going to 
determine whether all can be marketed such that no pair of competing products are both sold to Teenagers or both sold to Adults. If such an arrangement is not 
feasible your method will return -1. Otherwise, it should return the number of possible ways of marketing all of the products.

The products will be given in a String[] compete whose kth element describes product k. The kth element will be a single-space delimited list of integers. 
These integers will refer to the products that the kth product competes with. For example:
compete = {"1 4",
            "2",
            "3",
            "0",
	    ""}
The example above shows product 0 competes with 1 and 4, product 1 competes with 2, product 2 competes with 3, and product 3 competes with 0. Note, competition 
is symmetric so product 1 competing with product 2 means product 2 competes with product 1 as well.
Ways to market:
1) 0 to Teenagers, 1 to Adults, 2 to Teenagers, 3 to Adults, and 4 to Adults
2) 0 to Adults, 1 to Teenagers, 2 to Adults, 3 to Teenagers, and 4 to Teenagers
Your method would return 2.

Definition
Class:	Marketing
Method:	howMany
Parameters:	String[]
Returns:	long
Method signature:	long howMany(String[] compete)
(be sure your method is public)
 
Constraints
-	compete will contain between 1 and 30 elements, inclusive.
-	Each element of compete will have between 0 and 50 characters, inclusive.
-	Each element of compete will be a single space delimited sequence of integers such that:
All of the integers are unique.
Each integer contains no extra leading zeros.
Each integer is between 0 and k-1 inclusive where k is the number of elements in compete.
-	No element of compete contains leading or trailing whitespace.
-	Element i of compete will not contain the value i.
-	If i occurs in the jth element of compete, j will not occur in the ith element of compete.
 */


public class Marketing {
	boolean adj[][] = new boolean[64][64];
	int visited[] = new int[64];
	int n;
	boolean oddcycle = false;

	public void printMarketingCount(String[] compete, int assertResult) {
		long cnt = howMany(compete);
		System.out.println(String.format("INPUT ## %s", Arrays.asList(compete)));
		System.out.println(String.format("COUNT ## %d", cnt));
		System.out.println(String.format("RESULT ## %s", (cnt == assertResult ? "PASSED" : "FAILED")));
		System.out.println("=================================");
		oddcycle = false;
	}

	public long howMany(String[] compete) {
		long res = 1;
		int cnt = 0;
		n = compete.length;
		Arrays.fill(visited, 0);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(compete[i], " ");
			while (st.hasMoreTokens()) {
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = adj[j][i] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				cnt++;
				dfs(i, 1);
			}
			if (oddcycle) {
				return -1;
			}
		}
		while (cnt-- > 0)
			res *= 2;
		return res;
	}

	void dfs(int ind, int c) {
		if (visited[ind] != 0) {
			if (visited[ind] != c) {
				oddcycle = true;
			}
			return;
		}
		visited[ind] = c;
		for (int i = 0; i < n; i++) {
			if (adj[ind][i]) {
				dfs(i, 3 - c);
			}
		}
	}

	public static void main(String[] args) {
		String[] compete1 = { "1 4", "2", "3", "0", "" };
		new Marketing().printMarketingCount(compete1, 2);

		String[] compete2 = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "" };
		new Marketing().printMarketingCount(compete2, 1073741824);

		String[] compete3 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "" };
		new Marketing().printMarketingCount(compete3, 2);

		String[] compete4 = { "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20",
				"2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", "3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20",
				"4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", "5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20",
				"6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", "7 8 9 10 11 12 13 14 15 16 17 18 19 20",
				"8 9 10 11 12 13 14 15 16 17 18 19 20", "9 10 11 12 13 14 15 16 17 18 19 20",
				"10 11 12 13 14 15 16 17 18 19 20", "11 12 13 14 15 16 17 18 19 20", "12 13 14 15 16 17 18 19 20",
				"13 14 15 16 17 18 19 20", "14 15 16 17 18 19 20", "15 16 17 18 19 20", "16 17 18 19 20", "17 18 19 20",
				"18 19 20", "19 20", "20", "", "", "", "", "" };
		new Marketing().printMarketingCount(compete4, -1);

		String[] compete5 = { "1", "2", "3", "0", "5", "6", "4" };
		new Marketing().printMarketingCount(compete5, -1);
		String[] compete6 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "0" };
		new Marketing().printMarketingCount(compete6, 2);
		String[] compete7 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "5" };
		new Marketing().printMarketingCount(compete7, -1);
		String[] compete8 = { "1 2 3 4", "", "", "", "", "1 15", "2 15", "3 15", "4 15", "10", "11", "12", "13", "14",
				"9", "" };
		new Marketing().printMarketingCount(compete8, 4);
	}
}
