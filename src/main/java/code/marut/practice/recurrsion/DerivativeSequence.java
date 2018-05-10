package code.marut.practice.recurrsion;
/*
Given a sequence of K elements, we can calculate its difference sequence by taking the difference between 
each pair of adjacent elements.
For instance, the difference sequence of {5,6,3,9,-1} is {6-5,3-6,9-3,-1-9} = {1,-3,6,-10}. Formally, the difference sequence of 
the sequence a1, a2, ... , ak is b1, b2, ... , bk-1, where bi = ai+1 - ai.
The derivative sequence of order N of a sequence A is the result of iteratively applying the above process N times. 
For example, if A = {5,6,3,9,-1}, the derivative sequence of order 2 is: {5,6,3,9,-1} -> {1,-3,6,-10} -> {-3-1,6-(-3),-10-6} = {-4,9,-16}.
You will be given a sequence a as a Integer[] and the order n. Return a Integer[] representing the derivative sequence of order n of a.
    	
Class:	DerivativeSequence
Method:	derSeq
Parameters:	Integer[], Integer
Returns:	Integer[]
Method signature:	Integer[] derSeq(Integer[] a, Integer n)
(be sure your method is public)
    
 
Notes
-	The derivative sequence of order 0 is the original sequence. See example 4 for further clarification.
 
ConstraIntegers
-	a will contain between 1 and 20 elements, inclusive.
-	Each element of a will be between -100 and 100, inclusive.
-	n will be between 0 and K-1, inclusive, where K is the number of elements in a.
 */

import java.util.Arrays;

public class DerivativeSequence {

	public static Integer[] derSeq(Integer[] a, Integer n){
		if(n==0){
			return a;
		}
		if(a.length==1){
			return null;
		}
		Integer[] b = new Integer[a.length-1];
		for(Integer i=1;i<a.length;i++){
			b[i-1]=a[i]-a[i-1];
		}
		return derSeq(b, n-1);
	}
	
	public static void main(String[] args) {
		Integer[] ex1={5, 6, 3, 9, -1}; Integer ex1D= 1;
		prIntegerExecute(ex1, ex1D);
		Integer[] ex2={5, 6, 3, 9, -1}; Integer ex2D= 2;
		prIntegerExecute(ex2, ex2D);
		Integer[] ex3=	{5, 6, 3, 9, -1}; Integer ex3D= 4;
		prIntegerExecute(ex3, ex3D);
		Integer[] ex4={4, 4, 4, 4, 4, 4, 4, 4}; Integer ex4D= 3;
		prIntegerExecute(ex4, ex4D);
		Integer[] ex5={0, 3, 9, 18}; Integer ex5D= 3;
		prIntegerExecute(ex5, ex5D);
		Integer[] ex6=	{-100, 100}; Integer ex6D= 0;
		prIntegerExecute(ex6, ex6D);
		Integer[] ex7=	{-100, 100}; Integer ex7D= 1;
		prIntegerExecute(ex7, ex7D);
		Integer[] ex8=	{100, -100}; Integer ex8D= 1;
		prIntegerExecute(ex8, ex8D);
		Integer[] ex9=	{-100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100}; Integer ex9D= 19;
		prIntegerExecute(ex9, ex9D);
		Integer[] ex10=	{-100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100}; Integer ex10D= 15;
		prIntegerExecute(ex10, ex10D);
		Integer[] ex11=	{-94, 83, -100, -90, -99, 3, -97, 7, -15, -30, 74}; Integer ex11D= 10;
		prIntegerExecute(ex11, ex11D);
		Integer[] ex12=	{51, -86, -15, -24, 69, -72, -22, 16, 55, -55, -88, 46, 15, -53, -60, -40, -82, 7, -36, 31}; Integer ex12D= 19;
		prIntegerExecute(ex12, ex12D);
		Integer[] ex13=	{-21, 75, 67, 80, 66, 50, 70, -13, -47, -44, 7, 71, 6, 45, 16, 70, -23, -68, -84, -17}; Integer ex13D= 19;
		prIntegerExecute(ex13, ex13D);
		Integer[] ex14={87, 54, 15, 70, -20, -26, -58, -83, 97, -23, 9, 16, 92, -40}; Integer ex14D= 13;
		prIntegerExecute(ex14, ex14D);
	}
	
	public static void prIntegerExecute(Integer[] a, Integer n){
		System.out.println(String.format("IntegerIAL ARR %s, DER %d >> FINAL OUT >> %s", Arrays.asList(a), n, Arrays.asList(derSeq(a, n))));
	}
		
}
