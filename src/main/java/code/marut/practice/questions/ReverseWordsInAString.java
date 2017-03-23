package code.marut.practice.questions;

public class ReverseWordsInAString {

	public static String reverseWords(String str) {
		StringBuilder reverse = new StringBuilder();
		int j = str.length();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || str.charAt(i - 1) == ' ') {
				if(reverse.length()!=0){
					reverse.append(' ');
				}
				reverse.append(str.substring(i,j));
			}
		}
		return reverse.toString();
	}
	
	public static char[] reverseWords_inplace(String str) {
		char[] str_ch = str.toCharArray();
		reverse(str_ch, 0, str.length());
		System.out.println("REVERSED INITIALLY ## "+ new String(str_ch));
		for(int i=0,j=0;i<=str_ch.length;i++){
			if(i==str_ch.length || str_ch[i]==' '){
				reverse(str_ch, j, i);
				j=i+1;
			}
		}
		return str_ch;
	}
	
	private static char[] reverse(char[] strs, int start, int end){
		System.out.println();
		for(int i=0;i<(end-start)/2;i++){
			char temp = strs[start + i];
			strs[start + i] = strs[end - i - 1];
			strs[end - i - 1] = temp;
		}
		System.out.println(String.format("DATA # %s, indices %d,%d", new String(strs), start, end));
		return strs;
	}
	
	public static void main(String[] args) {
		String str = "can u reverse me ?";
		System.out.println("STRING ## "+ str);
		System.out.println("REVERSE STRING ## "+ reverseWords(str));
		
		String str2 = "can u reverse me ?";
		System.out.println("STRING2 ## "+ str2);
		System.out.println("REVERSE STRING2 ## "+ new String(reverseWords_inplace(str2)));
		
		String str3 ="?";
		System.out.println("STRING3 ## "+ str3);
		System.out.println("REVERSE STRING3 ## "+ new String(reverse(str3.toCharArray(), 0, str3.length())));
	}
}
