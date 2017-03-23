package code.marut.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
In one mode of the grafix software package, the user blocks off portions of a masking layer using opaque rectangles. 
The bitmap used as the masking layer is 400 pixels tall and 600 pixels wide. Once the rectangles have been blocked off, 
the user can perform painting actions through the remaining areas of the masking layer, known as holes. To be precise, 
each hole is a maximal collection of contiguous pixels that are not covered by any of the opaque rectangles. Two pixels 
are contiguous if they share an edge, and contiguity is transitive.

You are given a String[] named rectangles, the elements of which specify the rectangles that have been blocked off in the 
masking layer. Each String in rectangles consists of four integers separated by single spaces, with no additional spaces 
in the string. The first two integers are the window coordinates of the top left pixel in the given rectangle, and the last 
two integers are the window coordinates of its bottom right pixel. The window coordinates of a pixel are a pair of integers 
specifying the row number and column number of the pixel, in that order. Rows are numbered from top to bottom, starting 
with 0 and ending with 399. Columns are numbered from left to right, starting with 0 and ending with 599. Every pixel within
 and along the border of the rectangle defined by these opposing corners is blocked off.

Return a int[] containing the area, in pixels, of every hole in the resulting masking area, sorted from smallest area to 
greatest.
 
Definition
Class:	grafixMask
Method:	sortedAreas
Parameters:	String[]
Returns:	int[]
Method signature:	int[] sortedAreas(String[] rectangles)
(be sure your method is public)
    
Notes
-	Window coordinates are not the same as Cartesian coordinates. Follow the definition given in the second paragraph of the problem statement.
Constraints
-	rectangles contains between 1 and 50 elements, inclusive
-	each element of rectangles has the form "ROW COL ROW COL", where: "ROW" is a placeholder for a non-zero-padded integer between 0 and 399, inclusive; "COL" is a placeholder for a non-zero-padded integer between 0 and 599, inclusive; the first row number is no greater than the second row number; the first column number is no greater than the second column number
 */

public class GrafixMask {

	public static boolean fill[][] = new boolean[400][600];

	public static class node {
		public int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		String[] rectangles1 = { "0 292 399 307" };
		sortedAreasPrint(rectangles1);

		String[] rectangles2 = { "48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547" };
		sortedAreasPrint(rectangles2);

		String[] rectangles3 = { "0 192 399 207", "0 392 399 407", "120 0 135 599", "260 0 275 599" };
		sortedAreasPrint(rectangles3);

		String[] rectangles4 = { "50 300 199 300", "201 300 350 300", "200 50 200 299", "200 301 200 550" };
		sortedAreasPrint(rectangles4);

		String[] rectangles5 = { "0 20 399 20", "0 44 399 44", "0 68 399 68", "0 92 399 92", "0 116 399 116",
				"0 140 399 140", "0 164 399 164", "0 188 399 188", "0 212 399 212", "0 236 399 236", "0 260 399 260",
				"0 284 399 284", "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380", "0 404 399 404",
				"0 428 399 428", "0 452 399 452", "0 476 399 476", "0 500 399 500", "0 524 399 524", "0 548 399 548",
				"0 572 399 572", "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599", "53 0 53 599",
				"69 0 69 599", "85 0 85 599", "101 0 101 599", "117 0 117 599", "133 0 133 599", "149 0 149 599",
				"165 0 165 599", "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599", "245 0 245 599",
				"261 0 261 599", "277 0 277 599", "293 0 293 599", "309 0 309 599", "325 0 325 599", "341 0 341 599",
				"357 0 357 599", "373 0 373 599", "389 0 389 599" };
		sortedAreasPrint(rectangles5);
	}

	public static void sortedAreasPrint(String[] rectangles) {
		List<Integer> results = sortedAreas(rectangles);
		System.out.println(String.format("INPUT ## %s", Arrays.asList(rectangles)));
		System.out.println(String.format("RESULT ## %s", results));
		System.out.println("=========================================");
	}

	public static List<Integer> sortedAreas(String[] rectangles) {
		for (int i = 0; i < fill.length; i++) {
			Arrays.fill(fill[i], true);
		}
		List<Integer> results = new ArrayList<Integer>();
		fill(rectangles);
		for (int i = 0; i < 600; i++) {
			for (int j = 0; j < 400; j++) {
				int cnt = doFill(i, j);
				if (cnt > 0) {
					results.add(cnt);
				}
			}
		}
		Collections.sort(results);
		return results;
	}

	public static void fill(String[] rectangles) {
		for (String s : rectangles) {
			String[] token = s.split(" ");
			fill(new Integer(token[0]), new Integer(token[1]), new Integer(token[2]), new Integer(token[3]));
		}
	}

	public static void fill(int leftRow, int leftCol, int rightRow, int rightCol) {
		for (int i = leftRow; i <= rightRow; i++) {
			for (int j = leftCol; j <= rightCol; j++) {
				fill[i][j] = false;
			}
		}
	}

	public static int doFill(int x, int y) {
		int result = 0;
		Stack<node> s = new Stack<GrafixMask.node>();
		s.push(new node(x, y));
		while (!s.isEmpty()) {
			node top = s.pop();
			if (top.x < 0 || top.x >= 400)
				continue;
			if (top.y < 0 || top.y >= 600)
				continue;
			if (fill[top.x][top.y] == false)
				continue;
			fill[top.x][top.y] = false;
			result++;
			s.push(new node(top.x, top.y - 1));
			s.push(new node(top.x, top.y + 1));
			s.push(new node(top.x - 1, top.y));
			s.push(new node(top.x + 1, top.y));
		}
		return result;
	}

}
