package code.marut.practice.search;

import java.util.ArrayList;
import java.util.List;

public class SearchNumberInRangeOfNonOverlappingList {

	public List<Range> ranges;

	public static class Range {
		public int start, end;

		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "(" + start + "," + end + ")";
		}
	}

	private int rangeInIndex(Range n) {
		int l = 0, r = ranges.size() - 1;
		int m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			if (n.start < ranges.get(m).start && n.end < ranges.get(m).start) {
				r = m - 1;
			} else if (n.start > ranges.get(m).end && n.end > ranges.get(m).start) {
				l = m + 1;
			} else {
				return -1;
			}
		}
		if (l <= 0) {
			return 0;
		} else {
			return l;
		}
	}

	public boolean addRange(int start, int end) {
		Range n = new Range(start, end);
		if (ranges == null) {
			ranges = new ArrayList<SearchNumberInRangeOfNonOverlappingList.Range>();
			ranges.add(n);
		} else {
			int newInd = rangeInIndex(n);
			if (newInd != -1) {
				ranges.add(newInd, n);
			} else {
				return false;
			}
		}
		return true;
	}

	public int searchRangeNumber(int n) {
		int l = 0, r = ranges.size() - 1;
		int m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			if (n < ranges.get(m).start) {
				r = m - 1;
			} else if (n > ranges.get(m).end) {
				l = m + 1;
			} else {
				return m;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchNumberInRangeOfNonOverlappingList l = new SearchNumberInRangeOfNonOverlappingList();
		l.addRange(2, 10);
		System.out.println(l.ranges);
		l.addRange(20, 30);
		System.out.println(l.ranges);
		l.addRange(50, 80);
		System.out.println(l.ranges);
		l.addRange(100, 130);
		System.out.println(l.ranges);
		l.addRange(90, 95);
		System.out.println(l.ranges);
		l.addRange(0, 1);
		System.out.println(l.ranges);
		int n = 11;
		int ind = l.searchRangeNumber(n);
		System.out.println(String.format("Number %d %s", n,
				(ind == -1 ? " Not found." : " found at ind " + ind + " Range " + l.ranges.get(ind))));
	}
}