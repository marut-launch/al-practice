package code.marut.practice.level1;
/*
	Check if given sequence is valid.
		0	1	2
		3	4	5
		6	7	8	
			
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DialPadValidSequence {

	public static void main(String[] args) {
		Solution1 sol1 = new Solution1();
		Solution2 sol2 = new Solution2();
		String pattern = "01538";
		System.out.println(sol1.getNeighbors(1));
		System.out.println(sol1.isValidSequence(pattern));
		System.out.println(sol2.isValidSequence(pattern));
	}

	private static class Solution1 {
		int[][] data = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };

		public boolean isValidSequence(String seq) {
			if (seq == null || seq.length() < 4) {
				return false;
			}
			return isValidSequence(seq, 0, new ArrayList<>());
		}

		private boolean isValidSequence(String seq, int index, List<Integer> visited) {
			if (index >= seq.length()) {
				return true;
			}
			Integer curr = Integer.parseInt("" + seq.charAt(index));
			if (curr >= 0 && curr <= 8) {
				if (index == 0) {
					visited.add(curr);
					return isValidSequence(seq, index + 1, visited);
				}
				if (visited.contains(curr)) {
					return false;
				}
				int prev = Integer.parseInt("" + seq.charAt(index - 1));
				List<Integer> neighbors = getNeighbors(prev);
				if (neighbors.contains(curr)) {
					visited.add(curr);
					return isValidSequence(seq, index + 1, visited);
				} else {
					for (Integer prevNum : visited) {
						neighbors = getNeighbors(prevNum);
						if (neighbors.contains(curr)) {
							visited.add(curr);
							return isValidSequence(seq, index + 1, visited);
						}
					}
				}
			}
			return false;
		}

		private List<Integer> getNeighbors(int n) {
			List<Integer> neighbors = new ArrayList<>();
			int r = n / 3;
			int c = n % 3;
			if (r - 1 >= 0) {
				neighbors.addAll(getColumn(r - 1, c, true));
			}
			if (r + 1 <= 2) {
				neighbors.addAll(getColumn(r + 1, c, true));
			}
			neighbors.addAll(getColumn(r, c, false));
			return neighbors;
		}

		private List<Integer> getColumn(int r, int c, boolean flag) {
			List<Integer> vals = new ArrayList<>();
			if (c - 1 >= 0) {
				vals.add(data[r][c - 1]);
			}

			if (c + 1 <= 2) {
				vals.add(data[r][c + 1]);
			}
			if (flag) {
				vals.add(data[r][c]);
			}
			return vals;
		}
	}

	private static class Solution2 {
		Map<Integer, List<Integer>> data;
		private void constructData() {
			data = new HashMap<>();
			data.put(0, Arrays.asList(new Integer[] {1,3,4}));
			data.put(1, Arrays.asList(new Integer[] {0,2,3,4,5}));
			data.put(2, Arrays.asList(new Integer[] {1,4,5}));
			data.put(3, Arrays.asList(new Integer[] {0,1,4,6,7}));
			data.put(4, Arrays.asList(new Integer[] {0,1,2,3,5,6,7,8}));
			data.put(5, Arrays.asList(new Integer[] {1,2,3,7,8}));
			data.put(6, Arrays.asList(new Integer[] {3,4,7}));
			data.put(7, Arrays.asList(new Integer[] {3,4,5,6,8}));
			data.put(8, Arrays.asList(new Integer[] {4,5,7}));
		}
		public boolean isValidSequence(String seq) {
			if(seq == null || seq.length()<4) {
				return true;
			}
			constructData();
			return isValidSequence(seq, 0, new ArrayList<>(), new HashSet<>());
		}
		
		private boolean isValidSequence(String seq, int index, List<Integer> existingnumbers, Set<Integer> allAvailablenumbers) {
			if(index>=seq.length()) {
				return true;
			}
			Integer curr = Integer.parseInt(""+seq.charAt(index));
			if(existingnumbers.contains(curr)) {
				return false;
			}
			if(!allAvailablenumbers.isEmpty() && !allAvailablenumbers.contains(curr)) {
				return false;
			}
			allAvailablenumbers.addAll(data.get(curr));
			existingnumbers.add(curr);
			return isValidSequence(seq, index+1, existingnumbers, allAvailablenumbers);
		}
	}
	
/*	private static class Solution3 {
		private boolean isValid(char[] pattern) {
			if(pattern ==null && pattern.length<4) {
				return false;
			}
			for(int i =0; i<pattern.length;i++) {
				String temp =pattern[i];
				for(int j=i+1;j<pattern.length;j++) {
					if(temp==pattern[j]) {
						return false;
					}
				}
			}
			Map<String, char[]> neighbors= new HashMap<>();
			for(int i=0;i<pattern.length;i++) {
				for(int x=0;x<3;x++) {
					for(int y=0;y<3;y++) {
						String key = pattern[i];
						if(key==dialPad[x][y]) {
							
						}
					}
				}
			}
		}
	}
*/
}
