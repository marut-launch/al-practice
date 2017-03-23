package code.marut.practice.questions;

public class Testinggggggggg {
	
	public static boolean is_numeric_palindrome(long number) {
		number=Math.abs(number);
	    long div=1;
	    while(number/div>=10){
	        div*=10;
	    }
	    while(number>=10){
	        long r=number%10;
	        long l=number/div;
	        if(l!=r){
	            return false;
	        }
	        number%=div;
	        number/=10;
	        div/=100;
	    }
	    return true;
	  }
	
	public static void main(String[] args) {
		System.out.println(is_numeric_palindrome(9999999999999999l));
	}
}
