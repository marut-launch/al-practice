package code.marut.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeMoreThanTwoLists {

	public static List<Integer> mergeAllLists(List<List<Integer>> lists){
		int end=lists.size()-1;
		while(end>0){
			int start=0;
			while(end>start){
				lists.set(start, mergeLists(lists.get(start), lists.get(end)));
				start++;
				end--;
			}
		}
		return lists.get(0);
	}
	
	private static List<Integer> mergeLists(List<Integer> left, List<Integer> right){
		List<Integer> merged = new ArrayList<Integer>();
		int l=0,r=0;
		while(l<left.size() && r<right.size()){
			if(left.get(l)>right.get(r)){
				merged.add(right.get(r));
				r++;
			}else if(left.get(l)<right.get(r)){
				merged.add(left.get(l));
				l++;
			}else{
				merged.add(left.get(l));
				merged.add(right.get(r));
				l++;r++;
			}
		}
		while(l<left.size()){
			merged.add(left.get(l));
			l++;
		}
		while(r<right.size()){
			merged.add(right.get(r));
			r++;
		}
		return merged;
	}
	
	public static void main(String[] args) {
		Integer[] arr1 = {1,7,12,19,25,32,39,48};
		Integer[] arr2 = {2,6,17,33,39,76,89};
		Integer[] arr3 = {7,23,36,77,91,97,100};
		Integer[] arr4 = {0,13,93,109,121};
		Integer[] arr5 = {5,25,27,28,29,31,41,43};
		
//		Integer[] arr1 = {1,7,12};
//		Integer[] arr2 = {2,6,17};
//		Integer[] arr3 = {7,23,36};
//		Integer[] arr4 = {0,13,93};
//		Integer[] arr5 = {5,25,27};
		
		List<List<Integer>> allLists = new ArrayList<List<Integer>>();
		allLists.add(Arrays.asList(arr1));
		allLists.add(Arrays.asList(arr2));
		allLists.add(Arrays.asList(arr3));
		allLists.add(Arrays.asList(arr4));
		allLists.add(Arrays.asList(arr5));

		System.out.println("ALL LISTS # ");
		System.out.println(allLists);
		
		System.out.println("MERGED LIST # ");
		System.out.println(mergeAllLists(allLists));
		
	}
}
