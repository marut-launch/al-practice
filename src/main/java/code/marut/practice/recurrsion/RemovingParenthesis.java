package code.marut.practice.recurrsion;

/*
Correct parentheses sequences can be defined recursively as follows:
The empty string "" is a correct sequence.
If "X" and "Y" are correct sequences, then "XY" (the concatenation of X and Y) is a correct sequence.
If "X" is a correct sequence, then "(X)" is a correct sequence.
Each correct parentheses sequence can be derived using the above rules.
Examples of correct parentheses sequences include "", "()", "()()()", "(()())", and "(((())))".

You are given a String s that is guaranteed to be a correct parentheses sequence. A removal is an action that consists of two steps:
Remove the first opening parenthesis in s.
Remove one closing parenthesis in s. After you do so, s must again be a correct parentheses sequence.
Compute and return the number of distinct ways in which s can be reduced to an empty string by performing consecutive removals. Two ways are considered distinct if there is a step in which you remove a different closing parenthesis. (See Example 1 for clarification.) It is guaranteed that the correct return value will always fit into a 32-bit signed integer.

Class:	RemovingParenthesis
Method:	countWays
Parameters:	String
Returns:	int
Method signature:	int countWays(String s)
(be sure your method is public)
Constraints
-	s will have between 2 and 20 characters, inclusive.
-	s will be a correct parentheses sequence.
*/
public class RemovingParenthesis {

	public static int countWays(String s) {
		int buf = 0, cnt = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				buf++;
			} else {
				cnt *= buf;
				buf--;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		printExecute("()()()()()");
		printExecute("(((())))");
		printExecute("(())(())(())");
		printExecute("((()()()))");
		printExecute("((()))(()(()))((()))");
		printExecute("(((((((((())))))))))");
		printExecute("()()()()()()()()()()");
		printExecute("()");
		printExecute("()(())((()))(((())))");
		printExecute("()()()(())()()(())");
		printExecute("((()((()()))))");
		printExecute("()()()()()(()()()())");
		printExecute("()()()()(()()())");
		printExecute("()()()(())");
		printExecute("()()((()()()()))(())");
		printExecute("()()()(())()");
		printExecute("((()(((())(())))))");
		printExecute("(()(()()())())");
		printExecute("()()()()(())");
		printExecute("()()()()(()())(())");
	}

	public static void printExecute(String s) {
		System.out.println(String.format("%s >> %d", s, countWays(s)));
	}
}
