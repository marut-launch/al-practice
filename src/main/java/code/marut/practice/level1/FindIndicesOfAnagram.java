package code.marut.practice.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find the indices of all anagrams of a given word in a another word. 
For example: Find the indices of all the anagrams of AB in ABCDBACDAB 
*/

public class FindIndicesOfAnagram {

	public static void main(String[] args) {
		String in = "ABACDBACDAB";
		String search = "AB";
		List<Integer> indices = getIndices(in, search);
		System.out.println("INDICES ## "+ indices);
	}
	
	public static List<Integer> getIndices(String in, String search) {
		List<Integer> indices = new ArrayList<Integer>();
		int i = 0, j = 0;
		HashMap<Character, Integer> master = new HashMap<Character, Integer>();
		for (int ind = 0; ind < search.length(); ind++) {
			if (master.containsKey(search.charAt(ind))) {
				master.put(search.charAt(ind), master.get(search.charAt(ind)) + 1);
			} else {
				master.put(search.charAt(ind), 1);
			}
		}
		HashMap<Character, Integer> temp = (HashMap) master.clone();

		while (i < in.length() && j < in.length()) {
			if(temp.containsKey(in.charAt(j))){
				temp.put(in.charAt(j), temp.get(in.charAt(j))-1);
				if(temp.get(in.charAt(j))==0){
					temp.remove(in.charAt(j));
				}
				j++;
			}else{
				j++;
				i=j;
				temp = (HashMap) master.clone();
			}
			if(temp.isEmpty()){
				indices.add(i);
				i=j;
				temp = (HashMap) master.clone();
			}
		}
		return indices;
	}
}
