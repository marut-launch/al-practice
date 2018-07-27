package code.marut.practice.bit_op;

public class BitOperationHandsOn {
	public static void main(String[] args) {
		numberNegation(3);
	}

	public static void numberNegation(Integer number) {
		int negation = (number >>> 1);
		System.out.println(String.format("Number %d --> Negation %d", number, negation));
	}
}