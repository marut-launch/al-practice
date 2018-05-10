package code.marut.practice.recurrsion;
/*
    	
According to research conducted recently, listening to classical music increases one's mental abilities, while listening to metal decreases them. 
Now, yet another experiment is being conducted to try to prove or disprove this statement.
In this new experiment, a mouse is placed in a rectangular maze consisting of NxM squares. Each square either contains a wall or is empty. 
The maze is structured in such a way that for any two empty squares, there exists exactly one path between them. A path is a sequence of pairwise 
distinct empty squares such that every two consecutive squares are neighboring. Two squares are considered neighboring if they share a common edge.
One of the empty squares in the maze contains a piece of cheese, and the mouse's goal is to reach that square. The mouse can only move between 
neighboring empty squares. The mouse has been listening to metal for a week, so his mental abilities have become absolutely dull. Not only can he 
not smell the cheese, he can't even remember where he was heading a moment ago, so he is just wandering randomly. More precisely, from each square, 
the mouse will randomly choose one of the neighboring empty squares and move there. The probability of choosing each of the squares is equal. 
Each move takes one second.
You are given a String[] maze representing the maze. It contains N elements, each containing M characters. Empty squares are denoted by '.', 
walls are denoted by uppercase 'X', and the square containing the cheese is denoted by '*'. For each empty square, calculate the expected time 
required for the mouse to reach the cheese starting from that square. Return the arithmetical mean of all the expected times.
 
Definition
    	
Class:	MazeWandering
Method:	expectedTime
Parameters:	String[]
Returns:	double
Method signature:	double expectedTime(String[] maze)
(be sure your method is public)
    
 
Notes
-	The returned value must have an absolute or relative error less than 1e-9.
 
Constraints
-	maze will contain between 1 and 50 elements, inclusive.
-	Each element of maze will contain between 1 and 50 characters, inclusive.
-	Elements of maze will be of the same length.
-	maze will contain only '.', 'X', or '*' characters.
-	There will be exactly one '*' character in maze.
-	For every pair of empty squares in the maze, there will exist exactly one path between them.
 
Examples
0)	
    	
{"*",
 "."}
Returns: 0.5
The mouse will need 0 seconds to find the cheese if it is put in the cheese-square and 1 second otherwise.
1)	
    	
{"*.."}
Returns: 2.3333333333333335
The expectations for each square are 0.0, 3.0 and 4.0.
2)	
    	
{"...",
 "X*X",
 "..."}
Returns: 4.857142857142857
3)	
    	
{".*.",
 ".XX",
 "..."}
Returns: 13.714285714285714
4)	
    	
{"*........",
 "XXX.XXXX.",
 ".XX.X....",
 ".....XX.X"}
Returns: 167.2608695652174


*/
public class MazeWandering {
	char[][] f;
	boolean[][] mark;
	boolean[][] mark2;
	double[][] exp;
	int hei, wid, ci, cj;
	double answer = 0;
	int cells = 0;
	int[] dx = new int[] { 1, 0, -1, 0 };
	int[] dy = new int[] { 0, 1, 0, -1 };

	public double expectedTime(String[] maze) {
		hei = maze.length;
		wid = maze[0].length();
		f = new char[hei][];
		mark = new boolean[hei][wid];
		mark2 = new boolean[hei][wid];
		exp = new double[hei][wid];
		for (int i = 0; i < hei; i++) {
			f[i] = maze[i].toCharArray();
			for (int j = 0; j < wid; j++) {
				if (f[i][j] == '*') {
					ci = i;
					cj = j;
				}
			}
		}
		dfs(ci, cj);
		System.out.println("EXP ##");
		for(double[] v:exp){
			String s="";
			for(double vi:v){
				s+=vi+" ";
			}
			System.out.println(s);
		}
		dfs2(ci, cj, 0);
		System.out.println("ANSWER #" + answer+ ", cells #"+cells);
		return answer / cells;
	}

	private void dfs(int i, int j) {
		mark[i][j] = true;
		int kids = 0;
		double sum = 0;
		for (int d = 0; d < 4; d++) {
			int ii = i + dx[d];
			int jj = j + dy[d];
			if (ii < 0 || jj < 0 || ii >= hei || jj >= wid)
				continue;
			if (f[ii][jj] == 'X')
				continue;
			if (mark[ii][jj])
				continue;
			dfs(ii, jj);
			kids++;
			sum += exp[ii][jj];
		}
		if (kids == 0) {
			exp[i][j] = 1;
		} else {
			exp[i][j] = 1 + kids + sum;
		}
		if (f[i][j] == '*')
			exp[i][j] = 0;
	}

	private void dfs2(int i, int j, double e) {
		mark2[i][j] = true;
		cells++;
		answer += exp[i][j] + e;
		for (int d = 0; d < 4; d++) {
			int ii = i + dx[d];
			int jj = j + dy[d];
			if (ii < 0 || jj < 0 || ii >= hei || jj >= wid)
				continue;
			if (f[ii][jj] == 'X')
				continue;
			if (mark2[ii][jj])
				continue;
			dfs2(ii, jj, exp[i][j] + e);
		}
	}

	public static void main(String[] args) {
//		new MazeWandering().expectedTime(new String[] { "*.." });
		testing(new String []{"*.."});
		testing(new String []{"...", "X*X", "..."});
		testing(new String []{".*.", ".XX", "..."});
	}
	
	public static void testing(String in[]){
		
		Double expectedTime = new MazeWandering().expectedTime(in);
		System.out.println("=================== INPUT =============");
		for(String st:in){
			System.out.println(st);
		}
		System.out.println(String.format("Expected Time >> %f", expectedTime));
	}
}
