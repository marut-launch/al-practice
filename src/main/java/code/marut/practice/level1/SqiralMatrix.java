package code.marut.practice.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqiralMatrix {

	public static List<Integer> spiralMatrix(Integer[][] matrix){
		List<Integer> spiralMatrix = new ArrayList<Integer>();
		int n=matrix[0].length, m=matrix.length;
		int row=0, col=-1;
		while(true){
			for(int i=0;i<n;i++){
				spiralMatrix.add(matrix[row][++col]);
			}
			if(--m==0) break;
			for(int i=0;i<m;i++){
				spiralMatrix.add(matrix[++row][col]);
			}
			if(--n==0) break;
			for(int i=0;i<n;i++){
				spiralMatrix.add(matrix[row][--col]);
			}
			if(--m==0) break;
			for(int i=0;i<m;i++){
				spiralMatrix.add(matrix[--row][col]);
			}
			if(--n==0) break;
		}
		return spiralMatrix;
	}
	
	public static void main(String[] args) {
		Integer[][] matrix = { 
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }
//				,
//				{ 21, 22, 23, 24, 25 } 
			};
		List<List<Integer>> matList = new ArrayList<List<Integer>>();
		for(int i=0;i<matrix.length;i++){
			matList.add(Arrays.asList(matrix[i]));
		}
		
		System.out.println("MATRIX ## ");
		System.out.println(matList);
		System.out.println("SPIRAL ## ");
		System.out.println(spiralMatrix(matrix));
	}

}
