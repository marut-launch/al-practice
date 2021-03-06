package code.marut.practice.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
	Given a input string and list of search string BOLD the search string in input string;
	For example: 
	1) IN >> "abccsddtty123fg"
	   Search Strings >>> ["cc", "123"]
	   RESULT >> "ab<b>cc</b>sddtty<b>123</b>fg"
	
	2) IN >> "askajsccccc299njdnc"
	   Search Strings >>> ["ccc"]
	   RESULT >> "askajs<b>ccccc</b>299njdnc"
 */
public class BoldTheSearchString {
	public static class Range implements Comparable<Range> {
		public int start, end;

		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Range o) {
			if (o.start == this.start && o.end == this.end) {
				return 0;
			} else if (o.start > this.start) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	private void addRange(Set<Range> ranges, int start, int end) {
		if (ranges.isEmpty()) {
			ranges.add(new Range(start, end));
		} else {
			Iterator<Range> itr = ranges.iterator();
			List<Range> toBeRemoved = new ArrayList<BoldTheSearchString.Range>();
			int nStart = -1, nEnd = -1;
			while (itr.hasNext()) {
				Range cur = itr.next();
				if (start < cur.start && end < cur.start) {
					if (nStart == -1) {
						nStart = start;
					}
					nEnd = end;
					break;
				} else if (start < cur.start && end > cur.start) {
					toBeRemoved.add(cur);
					if (nStart == -1) {
						nStart = start;
					}
					if (end > cur.end) {
						nEnd = end;
					} else if (end < cur.end) {
						nEnd = cur.end;
					}
					break;
				} else if (start > cur.start && end < cur.end) {
					nStart = cur.start;
					nEnd = cur.end;
					toBeRemoved.add(cur);
					break;
				} else if (cur.start < start && end > cur.end) {
					nStart = cur.start;
					toBeRemoved.add(cur);
					break;
				}
			}
			ranges.removeAll(toBeRemoved);
			ranges.add(new Range((nStart == -1 ? start : nStart), (nEnd == -1 ? end : nEnd)));
		}
	}

	public String boldSearchStrings(String in, List<String> searches) {
		if (searches == null || searches.isEmpty() || in == null || in.isEmpty()) {
			return in;
		}
		Set<Range> ranges = new TreeSet<BoldTheSearchString.Range>();
		for (String s : searches) {
			for (int j = 0; j < in.length(); j++) {
				int index = in.indexOf(s, j);
				if (index == -1) {
					break;
				}
				addRange(ranges, index, index + s.length());
				j = index;
			}
		}
		if (ranges == null || ranges.isEmpty()) {
			return in;
		}
		String up = "";
		int lInd = 0;
		for (Range range : ranges) {
			up += in.substring(lInd, range.start) + "<b>" + in.substring(range.start, range.end) + "</b>";
			lInd = range.end;
		}
		up += in.substring(lInd);
		return up;
	}

	public static void main(String[] args) {
//		String in = "sdaaaatyt";
		String in = "sdabababctyt";
		List<String> searches = Arrays.asList(new String[] { "abab" });
		String up = new BoldTheSearchString().boldSearchStrings(in, searches);
		System.out.println("INPUT ## " + in + "\nUPDATED ##" + up);
		boldSearchStr2(in, searches);
	}
	
	// Second solution here
	
	public static void boldSearchStr2(String in, List<String> searches){
		TreeSet<Range> ranges  = new TreeSet<BoldTheSearchString.Range>();
		for(String search:searches){
			int preprocessed = preProcessed(search);
			int j=0, last=0;
			Range lastRange = null;
			while((j=in.indexOf(search, last))!=-1){
				if(lastRange!=null && lastRange.end+1>=j){
					lastRange.end = j+search.length();
				}else{
					lastRange = new Range(j, j+search.length());
					ranges.add(lastRange);
				}
				last=j+preprocessed;
			}
		}
		String up = boldStr2(in, ranges);
		System.out.println("INPUT 2 # "+in);
		System.out.println("UPDATED 2 # "+up);
	}
	
	public static String boldStr2(String in, TreeSet<Range> ranges){
		String up = "";
		int lInd = 0;
		for (Range range : ranges) {
			up += in.substring(lInd, range.start) + "<b>" + in.substring(range.start, range.end) + "</b>";
			lInd = range.end;
		}
		up += in.substring(lInd);
		return up;
	}
	public static int preProcessed (String search){
		int preprocessed = 0, l=0,r=search.length()-1;
		while(l<r){
			if(search.charAt(l)==search.charAt(r)){
				preprocessed++;
			}
			l++;r--;
		}
		preprocessed=(preprocessed>0?preprocessed:search.length());
		return preprocessed;
	}
	
}
