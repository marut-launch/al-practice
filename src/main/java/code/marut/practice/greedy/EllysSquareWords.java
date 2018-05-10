package code.marut.practice.greedy;

import java.util.Arrays;

/*
Elly has a String S containing uppercase letters from the English alphabet. The girl can either do nothing, or she can take exactly one action: 
she can change all occurrences of one letter into another letter (e.g., change all 'T's into 'C's). The "score" of the resulting word is defined
 as the sum of the squared number of occurrences of each letter. 
For example, let's S = "TOPCODERROCKS". It has one 'T', three 'O's, one 'P', two 'C's, one 'D', one 'E', two 'R's, one 'K', and one 'S'. Thus,
 if the girl doesn't change any letter the score of the word would be 1*1 + 3*3 + 1*1 + 2*2 + 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 23. However, if the
  girl chooses to change the 'R's into 'S's she would get "TOPCODESSOCKS" with score 27. Even better, if she changes the 'C's into 'O's she would
   get "TOPOODERROOKS" with score 35. 
Now the girl wonders what is the maximal score that can be achieved for various words. Help her by writing a program, that given the String S
 returns the maximal score after at most one change of letters.
Method signature:	int getScore(String S)
Constraints
-	S will contain between 1 and 50 characters, inclusive.
-	Each character of S will be an uppercase letter from the English alphabet ('A'-'Z').
Examples
0) "TOPCODERROCKS"
Returns: 35
The sample from the problem statement.
1) "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
Returns: 28
This time S contains each letter of the English alphabet exactly once. Elly should change any letter into any other letter.
2) "AWOIDUIWAHCSZNGAIOWIAWEWIUYTIUEAXKLMFCAWMAWVAWUBVA"
Returns: 374
Random keystrokes on the keyboard.
3)"ROVERWANDERERNOMADVAGABOND"
Returns: 108
4) "WITHOUTITIMJUSTESPR"
Returns: 65
*/

public class EllysSquareWords {

	public static void main(String[] args) {
		String[] testcases = { "TOPCODERROCKS", "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"AWOIDUIWAHCSZNGAIOWIAWEWIUYTIUEAXKLMFCAWMAWVAWUBVA", "ROVERWANDERERNOMADVAGABOND",
				"WITHOUTITIMJUSTESPR", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
				"AWOIDUIWAHCSZNGAIOWIAWEWIUYTIUEAXKLMFCAWMAWVAWUBVA",
				"ABCDEFGHIJKLMNOPQRSTUVWXYABCDEFGHIJKLMNOPQRSTUVWXY", "XKKIWZQYARSWCUJGJOVTPOVOIHVLXLZZJGCM" };
		Integer[] expectedResult = { 35, 28, 374, 108, 65, 2500, 374, 108, 92 };
		new EllysSquareWords().executeTests(testcases, expectedResult);
	}

	public void executeTests(String[] testcases, Integer[] expectedResult) {
		for (int i = 0; i < testcases.length; i++) {
			int res = getScore(testcases[i]);
			if (res != expectedResult[i]) {
				System.out.println(String.format("%s score # expected %d generated %d INCORRECT ", testcases[i],
						expectedResult[i], res));
			} else {
				System.out.println(String.format("%s score # expected %d generated %d CORRECT ", testcases[i],
						expectedResult[i], res));
			}
			System.out.println("============================================================");
		}
	}

	public int getScore(String str) {
		int[] data = new int[26];
		int i = 0;
		for (; i < 26; i++) {
			data[i] = 0;
		}
		for (i = 0; i < str.length(); i++) {
			data[str.charAt(i) - 'A']++;
		}
		Arrays.sort(data);
		i = 0;
		while (data[i] == 0 && i < 26) {
			i++;
		}
		if (i >= 25) {
			return data[25] * data[25];
		}
		int res = 0;
		for (; i < 24; i++) {
			res += data[i] * data[i];
		}
		res += (data[24] + data[25]) * (data[24] + data[25]);
		return res;
	}
}
