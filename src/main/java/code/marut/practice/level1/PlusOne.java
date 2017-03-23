package code.marut.practice.level1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a number represented as an array of digits, plus one to the number.
 */
public class PlusOne {

	public static void addDigit(List<Integer> numbers, int digit){
		if(digit>9 || digit<1){
			throw new IllegalArgumentException(String.format("Digit %d should be between 0-9", digit));
		}
		int res = numbers.get(numbers.size()-1) + digit;
		numbers.set(numbers.size()-1, (res%10));
		for(int i=numbers.size()-2;i>=0;i--){
			if(numbers.get(i)<9 || (res/10==0)){
				numbers.set(i, numbers.get(i)+ (res/10));
				return;
			}else{
				numbers.set(i, 0);
			}
		}
		numbers.add(numbers.get(numbers.size()-1));
		numbers.set(numbers.get(numbers.size()-2),0);
		numbers.set(0,1);
	}
	
	public static void main(String[] args) {
		Integer[] numAr= {9,9,9,9,6};
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.addAll( Arrays.asList(numAr));
		Integer plusDigit = 3;
		addDigit(numbers, plusDigit);
		System.out.println(String.format("Number %s added digit %d = Number %s", Arrays.asList(numAr), plusDigit,numbers ));
		
	}
	
}
