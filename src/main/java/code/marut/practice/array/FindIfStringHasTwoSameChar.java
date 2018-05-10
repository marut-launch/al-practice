package code.marut.practice.array;

public class FindIfStringHasTwoSameChar {

	public static void main(String[] args) {
		String test = "abc";
		System.out.println(doesStringHasTwoDuplicateChar(test));
	}
	
	public static boolean doesStringHasTwoDuplicateChar(String in){
		int[] arr = new int[256];
		for (int i=0;i<in.length();i++){
			int charInt = Character.toLowerCase(in.charAt(i)); 
			if(arr[charInt]>0){
				return true;
			}else{
				arr[charInt]=1;
			}
		}
		return false;
	}
	
}
