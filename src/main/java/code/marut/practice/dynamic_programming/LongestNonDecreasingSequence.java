package code.marut.practice.dynamic_programming;

public class LongestNonDecreasingSequence {

	public static int longestNonDecreasingSequence(int[] nums){
		int[] longestSeq = new int[nums.length];
		int[] lastSeq = new int[nums.length];
		lastSeq[0]=0;
		longestSeq[0]=1;
		for(int i=1;i<nums.length;i++){
		}
		
		return longestSeq[nums.length-1];
	}
	
}
