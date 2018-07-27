package code.marut.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Print all k-sum paths in a binary tree
 */
public class PrintKSumPaths {

	public static void main(String[] args) {
		DTree tree = new DTree(4);
		tree.left = new DTree(1);
		tree.right = new DTree(-1);
		
		tree.left.left = new DTree(2);
		tree.left.left.right = new DTree(2);
		tree.left.left.right.left = new DTree(1);
		tree.left.left.left = new DTree(0);
		tree.right.left = new DTree(6);
		
		printKSumPaths(tree, 5);
	}
	
	public static void printKSumPaths(DTree tree , long sum) {
		if(tree ==null) {
			return ;
		}
		printSum(tree, new ArrayList<>(), sum);
	}
	
	public static void printSum(DTree tree , List<Integer> prev, long target) {
		if(tree==null) {
			return;
		}
		List<Integer> nums = new ArrayList<>(prev);
		nums.add(tree.data);
		printPossiblePath(nums, target);
		printSum(tree.left, nums, target);
		printSum(tree.right, nums, target);
	}
	
	private static void printPossiblePath(List<Integer> nums, long target) {
		int i=nums.size()-1;
		long curr = 0;
		while(i>=0) {
			curr+=nums.get(i);
			if(curr==target) {
				for(int j=i;j<nums.size();j++) {
					System.out.print(nums.get(j)+" ");
				}
				System.out.println();
			}
			i--;
		}
	}
	
}
