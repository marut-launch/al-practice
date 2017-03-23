package code.marut.practice.level1;

import java.util.Arrays;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

	public static int singleNumber(Integer[] A) {
		int num = 0;
		for (Integer x : A) {
			num ^= x;
		}
		return num;
	}

	public static void main(String[] args) {
		Integer[] A = { 2,4,2,2,4,5,4,4,5,2,5,1,5,1,1 };
		System.out.println(String.format("Array %s single value out %d", Arrays.asList(A), singleNumber(A)));
	}
}
