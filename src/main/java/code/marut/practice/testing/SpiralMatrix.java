package code.marut.practice.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void printSpiral(Integer[][] vals){
		int x = vals[0].length;
		int level = x/2;
		int i=0,j=-1;
		for(int ll=0;ll<=level;ll++){
			int y=1;
			for(; y<=x;y++){
				j++;
				System.out.println("("+i+","+j+")");
				
			}
			x--;i++;
			y=1;
			for(; y<=x;y++){
				System.out.println("("+i+","+j+")");
				i++;
			}
			j--;
			y=1;
			for(; y<=x;y++){
				System.out.println("("+i+","+j+")");
				j--;
			}
			i--;x--;
			y=1;
			for(; y<=x;y++){
				System.out.println("("+i+","+j+")");
				i--;
			}
		}
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
		printSpiral(matrix);
	}
}
