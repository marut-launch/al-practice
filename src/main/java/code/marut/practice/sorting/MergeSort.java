package code.marut.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] test1 = {4,66,1,5,55,90,22,1,87,64,0,1,4,9,3,5,11,76,31};
		Integer[] test = {9,20,1,11,12,90,7,3,5};
		System.out.println("Unsorted ARRAY ## "+ Arrays.asList(test1));
		List<Integer> sorted = mergeSort(Arrays.asList(test1));
		System.out.println("Sorted ARRAY ## "+ sorted);

	}
	public static List<Integer> mergeSort(List<Integer> in) {
		return sortList(0, in.size()-1, in); 
	}

	public static List<Integer> sortList(int start, int end, List<Integer> in) {
		List<Integer> sorted = new ArrayList();
		if (end - start == 0) {
			sorted.add(in.get(start));
		} else if (end - start == 1) {
			if (in.get(start) < in.get(end)) {
				sorted.add(in.get(start));
				sorted.add(in.get(end));
			}else{
				sorted.add(in.get(end));
				sorted.add(in.get(start));
			}
		} else if (start < end) {
			int mid = (start + end) / 2;
			List<Integer> left = sortList(start, mid, in);
			List<Integer> right = sortList(mid+1, end, in);
			sorted = merge(left, right);
		}
		return sorted;
	}

	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		int l = 0, r = 0;
		List<Integer> out = new ArrayList();
		while (l < left.size() && r < right.size()) {
			if(left.get(l)<right.get(r)){
				out.add(left.get(l));
				l++;
			}else{
				out.add(right.get(r));
				r++;
			}
		}
		while(l < left.size()){
			out.add(left.get(l));
			l++;
		}
		while(r < right.size()) {
			out.add(right.get(r));
			r++;
		}
		return out;
	}
}