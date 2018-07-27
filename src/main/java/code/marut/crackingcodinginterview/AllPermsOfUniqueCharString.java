package code.marut.crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

public class AllPermsOfUniqueCharString {

	
	public static void main(String[] args) {
		String str = "abcde";
		List<char[]> allPerms = perms(str);
		
		for(char[] c: allPerms) {
			System.out.println(String.copyValueOf(c));	
		}
		System.out.println("LENGTH #"+allPerms.size());	
	}
	public static List<char[]> perms(String s){
		char[] inputChars = s.toCharArray();
		return perms(inputChars, inputChars.length-1);
	}
	
	public static List<char[]> perms(char[] inputChars, int index){
		if(index==0) {
			List<char[]> allPerms = new ArrayList<>();
			allPerms.add(new char[] {inputChars[index]});
			return allPerms;
		}else {
			return updatePerms(perms(inputChars, index-1), inputChars[index]);
		}
	}
	
	public static List<char[]> updatePerms( List<char[]> currPerms, char addition){
		 List<char[]> allPerms = new ArrayList<>();
		 for(char[] set: currPerms) {
			 int i=0;
			 while(i<=set.length) {
				 char[] build = new char[set.length+1];
				 int buildIndex=0 ;
				 for(int setIndex=0;setIndex<set.length;setIndex++) {
					 if(setIndex==i) {
						 build[buildIndex++]= addition;
					 }
					 build[buildIndex++]= set[setIndex];
				 }
				 if(i==set.length) {
					 build[buildIndex]= addition;
				 }
				 allPerms.add(build);
				 i++;
			 }
		 }
		 
		 
		 return allPerms;
	}
}
