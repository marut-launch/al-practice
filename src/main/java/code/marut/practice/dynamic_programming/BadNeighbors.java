package code.marut.practice.dynamic_programming;

import java.util.Arrays;

/*
Problem Statement
    	
The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart. Every resident hates his next-door 
neighbors on both sides. Nobody is willing to live farther away from the town's well than his neighbors, so the town has been arranged in a big circle around 
the well. Unfortunately, the town's well is in disrepair and needs to be restored. You have been hired to collect donations for the Save Our Well fund.
Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations, which is listed in clockwise order around the well. 
However, nobody is willing to contribute to a fund to which his neighbor has also contributed. Next-door neighbors are always listed consecutively in donations,
except that the first and last entries in donations are also for next-door neighbors.
You must calculate and return the maximum amount of donations that can be collected.

Definition    	
Class:	BadNeighbors
Method:	maxDonations
Parameters:	int[]
Returns:	int
Method signature:	int maxDonations(int[] donations)
(be sure your method is public)
    
Constraints
-	donations contains between 2 and 40 elements, inclusive.
-	Each element in donations is between 1 and 1000, inclusive.
 
Examples
0) { 10, 3, 2, 5, 7, 8 }
Returns: 19
The maximum donation is 19, achieved by 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations are from neighbors.
1) { 11, 15 }
Returns: 15
2) { 7, 7, 7, 7, 7, 7, 7 }
Returns: 21
3)	{ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }
Returns: 16
4)	{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }
Returns: 2926

DP Solution
=====
don(i) = max donation when considering first i elements and ith
element is surely taken in it.
don(0) = donations[0];
don(1) = donations[1];
don(2) = donations[0] + donations[2];

Now general recurrence :
don(i) = max ( don(i - 2) , don(i - 3) ) + donations[i]

handling 0 and n-1 as neighbors>> max( don(0 to N-2), don(1 to N-1)) 

 */
public class BadNeighbors {
	public static void printmaxDonations(Integer[] donations) {
		System.out.println(String.format("DONATIONS : %s \n MAX TOTAL DONATIONS: %d", Arrays.asList(donations),
				maxDonations(donations)));
		System.out.println("===========================");
	}

	public static int maxDonations(Integer[] donations) {
		if (donations == null || donations.length == 0) {
			return 0;
		}
		if (donations.length == 1) {
			return donations[0];
		}
		return Math.max(maxDonation(donations, 0, donations.length - 2),
				maxDonation(donations, 1, donations.length - 1));
	}

	public static int maxDonation(Integer[] donations, int start, int end) {
		if (end - start == 0) {
			return donations[start];
		}
		if (end - start == 1) {
			return Math.max(donations[start], donations[end]);
		}
		int[] maxDonation = new int[donations.length];
		int cur = start;
		maxDonation[cur] = donations[cur];
		cur++;
		maxDonation[cur] = donations[cur];
		cur++;
		maxDonation[cur] = maxDonation[cur - 2] + donations[cur];
		cur++;
		while (cur <= end) {
			maxDonation[cur] = Math.max(maxDonation[cur - 2], maxDonation[cur - 3]) + donations[cur];
			cur++;
		}
		return maxDonation[end];
	}

	public static void main(String[] args) {
		Integer[] test1 = { 10, 3, 2, 5, 7, 8 };
		Integer[] test2 = { 7, 7, 7, 7, 7, 7, 7 };
		Integer[] test3 = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		Integer[] test4 = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35,
				47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		Integer[] test5 = { 347, 49, 608, 460, 67, 856, 21, 526, 552, 412, 761, 286, 481, 441, 598, 933, 462, 328, 92 };
		Integer[] test6 = { 965, 850, 698, 178, 936, 112, 944, 46, 288, 741, 23, 903, 454, 448, 539, 578, 469, 579, 32,
				703, 424, 61, 488, 178, 902, 797, 933, 55, 380, 209, 791, 226, 739, 474, 431, 388, 614, 745 };

		printmaxDonations(test1);
		printmaxDonations(test2);
		printmaxDonations(test3);
		printmaxDonations(test4);
		printmaxDonations(test5);
		printmaxDonations(test6);

	}
}
