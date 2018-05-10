package code.marut.practice.greedy;

import java.util.Arrays;

/*
    	
LYC is the pet dog of Emperor Zhangzj of Yali Empire. Zhangzj has a huge affluence. Besides his palace, he has multiple estates. One of them is 
the Long Mansion, a famous site in Yali. LYC loves to play. One day, he accidentally enters the labyrinthine Long Mansion.
The mansion can be seen as a grid of unit square cells. There are N rows, indexed from 0 to (N - 1). The number of columns is infinite in one direction.
The columns are indexed by nonnegative integers, starting from 0. You are given ints sX, sY, eX, eY. Initially LYC is standing on the cell on the sXth
 row, and the sYth column. The exit is at the cell on the eXth row, and the eYth column. LYC can walk to a cell that shares an edge with the cell he is at. He wished to reach the exit as soon as possible.
Unfortunately, each cell contains some obstacles that slow LYC down. For each cell we know the time LYC needs to spend there while passing through 
the cell. LYC also needs to spend that amount of time in the initial cell and in the exit cell as well. There is a pattern to the obstacles: each 
column of the mansion looks the same. In other words, all cells within any given row contain the same obstacle type, and therefore they delay LYC by 
the same amount of time. For example, the entire first row are some bushes, the entire second row contains some walls, and so on. You are given the 
times in the int[] t. More precisely, LYC will spend t[i] time in each cell he visits in row i.

You are given one int[] t and 4 ints sX, sY, eX, eY. Return the minimal time LYC needs to spend to reach the exit.

Method signature:	long minimalTime(int[] t, int sX, int sY, int eX, int eY)
Constraints
-N will be between 1 and 50, inclusive.
-t will contain exactly N elements.
-Each element of t will be between 1 and 1,000, inclusive.
-sX and eX will be between 0 and (N - 1), inclusive.
-sY and eY will be between 0 and 1,000,000,000 inclusive.

 Examples
0){5, 3, 10}
2
0
2
2
Returns: 29
The optimal path would be (2, 0) &rarr (1, 0) &rarr (1, 1) &rarr (1, 2) &rarr (2, 2). The total time would be 10 + 3 + 3 + 3 + 10 = 29.
 Note that you should count the time LYC spends on the inital cell and the cell of the exit as well.

1){5, 3, 10}
0
2
0
0
Returns: 15
This time the optimal path would be (0, 2) &rarr (0, 1) &rarr (0, 0).
2){137, 200, 184, 243, 252, 113, 162}
0
2
4
2
Returns: 1016
3){995, 996, 1000, 997, 999, 1000, 997, 996, 1000, 996, 1000, 997, 999, 996, 1000, 998, 999, 995, 995, 998, 995, 998, 995, 997, 998, 996, 998, 996, 997, 1000, 998, 997, 995, 1000, 996, 997, 1000, 997, 997, 999, 998, 995, 999, 999, 1000, 1000, 998, 997, 995, 999}
18
433156521
28
138238863
Returns: 293443080673
4){1}
0
0
0
0
Returns: 1
*/
public class LongMansionDiv1 {

	public static class Input {
		public int[] t;
		public int sX, sY, eX, eY;

		public Input(int[] t, int sX, int sY, int eX, int eY) {
			this.t = t;
			this.sX = sX;
			this.sY = sY;
			this.eX = eX;
			this.eY = eY;
		}

		@Override
		public String toString() {
			return "[t=" + Arrays.toString(t) + ", sX=" + sX + ", sY=" + sY + ", eX=" + eX + ", eY=" + eY + "]";
		}

	}

	public static void main(String[] args) {
		Input[] testcases = { new Input(new int[] { 137, 200, 184, 243, 252, 113, 162 }, 0, 2, 4, 2),
				new Input(new int[] { 5, 3, 10 }, 2, 0, 2, 2), new Input(new int[] { 5, 3, 10 }, 0, 2, 0, 0),
				new Input(new int[] { 995, 996, 1000, 997, 999, 1000, 997, 996, 1000, 996, 1000, 997, 999, 996, 1000,
						998, 999, 995, 995, 998, 995, 998, 995, 997, 998, 996, 998, 996, 997, 1000, 998, 997, 995, 1000,
						996, 997, 1000, 997, 997, 999, 998, 995, 999, 999, 1000, 1000, 998, 997, 995, 999 }, 18,
						433156521, 28, 138238863),
				new Input(new int[] { 1 }, 0, 0, 0, 0) };
		long[] results = { 1016, 29, 15, 293443080673l, 1 };
		new LongMansionDiv1().execute(testcases, results);
	}

	public void execute(Input[] testcases, long[] results) {
		for (int i = 0; i < testcases.length; i++) {
			long res = minimalTime(testcases[i].t, testcases[i].sX, testcases[i].sY, testcases[i].eX, testcases[i].eY);
			if (res != results[i]) {
				System.out.println(
						String.format("FAILED ## EXPECTED %d RESULT %d TESTCASE %s ", results[i], res, testcases[i]));
			} else {
				System.out.println(
						String.format("PASSED ## EXPECTED %d RESULT %d TESTCASE %s ", results[i], res, testcases[i]));
			}
			System.out.println("=============================================");
		}
	}

	public long minimalTime(int[] t, int sX, int sY, int eX, int eY) {
		long res = Long.MAX_VALUE;
		for (int i = 0; i < t.length; i++) {
			long cur = 0;
			for (int j = Math.min(i, sX); j <= Math.max(i, sX); j++) {
				cur += t[j];
			}
			for (int j = Math.min(i, eX); j <= Math.max(i, eX); j++) {
				cur += t[j];
			}
			cur += (long)(Math.max(sY, eY) - Math.min(sY, eY) - 1) * t[i];
			res = (long) Math.min(res, cur);
		}
		return res;
	}

}
