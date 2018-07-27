package code.marut.crackingcodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PowerSet {
	
	public static class Set{
		List<Integer> val;
		Set(Integer[] v){
			val = Arrays.asList(v);
		}
		Set(){
			val=new ArrayList<>();
		}
		Set(Set copy){
			val=new ArrayList<>();
			if(copy.val!=null && copy.val.size()>0) {
				val.addAll(copy.val);
			}
		}
		public void add(Integer n) {
			val.add(n);
		}
		 
		@Override
		public String toString() {
			if(val.size()==0) {
				return "{}";
			}else {
				return val.toString();
			}
		}
	}
	
	public static void main(String[] args) {
		powerSet(new Integer[] {1, 2, 3, 4});
	}
	
	public static void powerSet(Integer[] vals) {
		List<Set> allSets = set(vals, vals.length-1);
		int cnt = 0;
		int t=0;
		while(t<=allSets.size()) {
			for(Set s: allSets) {
				if(cnt==s.val.size()) {
					System.out.print(s);
				}
			}
			System.out.println();
			cnt++;
			t++;
		}
	}
	
	private static List<Set> set(Integer[] vals, int index){
		if(index==0) {
			List<Set> sets = new ArrayList<>();
			sets.add(new Set());
			sets.add(new Set(new Integer[] {vals[index]}));
			return sets;
		}else {
			Integer curr = vals[index];
			List<Set> p_sets = set(vals, --index);
			return addToSet(p_sets, curr);
		}
	}
	
	private static List<Set> addToSet(List<Set> sets, Integer v){
		List<Set> allSets = new ArrayList<>();
		allSets.addAll(sets);
		for(Set s:sets) {
			Set temp = new Set(s);
			temp.add(v);
			allSets.add(temp);
		}
		return allSets;
	}
}
