package code.marut.ques;
/*
Q: Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell. 
The distance between two adjacent cells is 1.

Example 1: 
Input: 
0 0 0
0 1 0
0 0 0
Output: 
0 0 0
0 1 0
0 0 0

Example 2: 
Input: 
0 0 0
0 1 0
1 1 1
Output: 
0 0 0
0 1 0
1 2 1

Input: 
1 0 1
1 1 1
1 1 0
*/

import java.util.ArrayList;
import java.util.List;

public class AMZ {

	public static void main(String[] args) {
//		int[][] data = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
//		int[][] data = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 0 } };
		int[][] data = { { 1, 1, 1 }, { 1, 1, 0 } };
		int[][] dist = calculateNearestDist(data);
		print(data);
		print(dist);
	}

	public static void print(int[][] data) {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[0].length; c++) {
				System.out.print(data[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static class Coord {
		public int r, c;

		public Coord(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int[][] calculateNearestDist(int[][] data) {
		int[][] dist = new int[data.length][data[0].length];
		int[][] visited = new int[data.length][data[0].length];
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[0].length; c++) {
				dist[r][c] = -1;
				visited[r][c]=0;
			}
		}
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[0].length; c++) {
				System.out.println("CALLING#(" + r + "," + c + ")");
				updateDist(data, dist,visited, r, c);
			}
		}

		return dist;
	}

	public static void updateDist(int[][] data, int[][] dist, int[][] visited, int r, int c) {
		if(visited[r][c]>0 || dist[r][c] >= 0) {
			return;
		}
		visited[r][c]=1;
		System.out.println("VISTING#(" + r + "," + c + ")");
		if (data[r][c] == 0) {
			dist[r][c] = 0;
			return;
		}
		boolean foundPath = false;
		List<Coord> childs = getCoords(r, c, data.length - 1, data[0].length - 1);
		for (Coord coord : childs) {
			if (data[coord.r][coord.c] == 0 || dist[coord.r][coord.c] == 0) {
				foundPath = true;
				break;
			}
		}
		if (foundPath) {
			dist[r][c] = 1;
		} else {
			for (Coord coord : childs) {
				if (dist[coord.r][coord.c] < 0 && visited[coord.r][coord.c]==0) {
					updateDist(data, dist, visited, coord.r, coord.c);
				}
			}
			int min = Integer.MAX_VALUE;
			for (Coord coord : childs) {
				if (min > dist[coord.r][coord.c]) {
					min = dist[coord.r][coord.c];
				}
			}
			dist[r][c] = 1 + min;
		}
	}

	private static List<Coord> getCoords(int r, int c, int rMax, int cMax) {
		List<Coord> coords = new ArrayList<>();
//		if (r - 1 >= 0) {
//			coords.add(new Coord(r - 1, c));
//		}
		if (r + 1 <= rMax) {
			coords.add(new Coord(r + 1, c));
		}
//		if (c - 1 >= 0) {
//			coords.add(new Coord(r, c - 1));
//		}
		if (c + 1 <= cMax) {
			coords.add(new Coord(r, c + 1));
		}
		return coords;
	}
}
