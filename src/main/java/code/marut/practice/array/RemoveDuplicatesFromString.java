package code.marut.practice.array;

public class RemoveDuplicatesFromString {

	public static String removeDuplicates(char[] str) {
		int tail = 1;
		for (int i = 1; i < str.length; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (str[i] == str[j])
					break;
			}
			if (tail == j) {
				str[tail] = str[i];
				tail++;
			}
		}
		String newStr = new String(str);
		if (tail <= str.length - 1) {
			newStr= newStr.substring(0, tail);
		}
		return newStr;
	}

	public static void printRemoveDuplicateResults(String str) {
		System.out.println(String.format("String %s is processed to %s", str, removeDuplicates(str.toCharArray())));
	}

	public static void main(String[] args) {
		String test1 = "testing";
		printRemoveDuplicateResults(test1);

		String test2 = "aaabb";
		printRemoveDuplicateResults(test2);

		String test3 = "agabttbc";
		printRemoveDuplicateResults(test3);
		
		String test4 = "abcde";
		printRemoveDuplicateResults(test4);

	}

}
