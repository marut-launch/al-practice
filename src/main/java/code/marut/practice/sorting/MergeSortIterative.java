package code.marut.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortIterative {

	public static void main(String[] args) {
		Integer[] test1 = {4,66,1,5,4,9,3,5,11,76,31};
		Integer[] test2 = {4,66,1,5,55,90,22,1,87,64,0,1,4,9,3,5,11,76,31};
		Integer[] test = {9,20,1,11,12,90,7,3,5};
		System.out.println("Unsorted ARRAY ## "+ Arrays.asList(test2));
		List<Integer> sorted = mergeSort(Arrays.asList(test2));
		System.out.println("Sorted ARRAY ## "+ sorted);

	}
	public static List<Integer> mergeSort(List<Integer> in) {
		System.out.println("SIZE #  " + in.size());
		for(int level=1;level<in.size();level=(level*2)){
			System.out.println("LEVEL #  " + level + " -----------------");
			for(int start=0;start<in.size();start=(start+(level*2))){
				int mid = Math.min(start + level - 1, in.size()-1);
		        int end = Math.min(start + 2*level - 1, in.size()-1);
		        
				System.out.println(String.format("Start # %d, End # %d, mid # %d", start, end, mid));
				mergeParts(start, mid, end, in);
			}
		}
		return in;
	}
	
	private static void mergeParts(int start, int mid, int end, List<Integer> in){
		int k=start, l=0, r=0;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		int temp = start;
		while(temp<=mid){
			left.add(in.get(temp));
			temp++;
		}
		temp=mid+1;
		while(temp<=end){
			right.add(in.get(temp));
			temp++;
		}
		while(l<left.size() && r<right.size()){
			if(left.get(l)<right.get(r)){
				in.set(k, left.get(l));
				l++;
			}else{
				in.set(k, right.get(r));
				r++;
			}
			k++;
		}
		while(l<left.size()){
			in.set(k, left.get(l));
			l++;
			k++;
		}
		while(r<right.size()){
			in.set(k, right.get(r));
			r++;
			k++;
		}
	}
}
