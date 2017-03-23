package code.marut.practice.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	private static final Set<String> OPERATORS = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

	public static Integer evalRPN(String[] tokens) {
		Stack<Integer> operands = new Stack<Integer>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				operands.push(eval(operands.pop(), operands.pop(), token));
			} else {
				operands.push(Integer.valueOf(token));
			}
		}
		return operands.pop();
	}

	public static Integer eval(Integer x, Integer y, String operator) {
		if (operator.equals("+")) {
			return y + x;
		} else if (operator.equals("-")) {
			return y - x;
		} else if (operator.equals("*")) {
			return y * x;
		} else {
			return y / x;
		}
	}

	public static void main(String[] args) {
		String[] rpn = new String[]{"8", "1", "2", "+", "12", "*", "-"};
		Integer value = evalRPN(rpn);
		System.out.println(String.format("RPN # %s Evaluated to %d", Arrays.asList(rpn), value));
	}
}
