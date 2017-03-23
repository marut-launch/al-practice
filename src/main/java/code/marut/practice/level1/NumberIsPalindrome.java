package code.marut.practice.level1;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class NumberIsPalindrome {

	public static boolean isNumberPalindrome(int num){
		if(num<0){
			throw new IllegalArgumentException("Number can't be negative");
		}
		int div = 1;
		while(num/div >=10){
			div*=10;
		}
		while(num >9){
			int l= num/div;
			int r=num%10;
			if(l!=r){
				return false;
			}
			num=num%div;
			num=num/10;
			div/=100;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num = 00;
		System.out.println(String.format("Number %d is palindrome %b", num, isNumberPalindrome(num)));
	}
}
