package code.marut.practice.level1;

public class ReverseInteger {

	public static int reverseInteger(int number){
		int ret = 0;
		while(number!=0){
			if(Math.abs(ret)>214748364){
				return 0;
			}
			ret=ret*10 + (number%10);
			number /= 10;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int number = 213232344;
		System.out.println(String.format("NUMBER # %d <<<>>> REVERSE ## %d ", number , reverseInteger(number)));
		
		number = -213232344;
		System.out.println(String.format("NUMBER # %d <<<>>> REVERSE ## %d ", number , reverseInteger(number)));
		
		number = 1000000000;
		System.out.println(String.format("NUMBER # %d <<<>>> REVERSE ## %d ", number , reverseInteger(number)));
	}
}
