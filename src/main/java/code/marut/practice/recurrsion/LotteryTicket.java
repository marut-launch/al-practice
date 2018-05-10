package code.marut.practice.recurrsion;

/*
Nick likes to play the lottery. The cost of a single lottery ticket is price. Nick has exactly four banknotes with values b1, b2, b3 and b4 
(some of the values may be equal). He wants to know if it's possible to buy a single lottery ticket without getting any change back. 
In other words, he wants to pay the exact price of a ticket using any subset of his banknotes. Return "POSSIBLE" if it is possible or 
"IMPOSSIBLE" if it is not (all quotes for clarity).
 
Definition
    	
Class:	LotteryTicket
Method:	buy
Parameters:	int, int, int, int, int
Returns:	String
Method signature:	String buy(int price, int b1, int b2, int b3, int b4)
(be sure your method is public)

 */

public class LotteryTicket {

	public static boolean buy(int price, int b1, int b2, int b3, int b4) {
		if (price == 0)
			return false;
		int notes[] = { b1, b2, b3, b4 };
		return buy(notes.length - 1, price, notes);
	}

	private static boolean buy(int ind, int cur, int[] notes) {
		if (cur == 0)
			return true;
		if (ind < 0)
			return false;
		if (notes[ind] > cur) {
			return buy(ind - 1, cur, notes);
		} else {
			return (buy(ind - 1, cur, notes) || buy(ind - 1, cur - notes[ind], notes));
		}
	}

	public static void main(String[] args) {
		int[] ex1 = {10,1,5,10,50};
		execute(ex1);
		int[] ex2={15,1,5,10,50};
		execute(ex2);
		int[] ex3={65,1,5,10,50};
		execute(ex3);
		int[] ex4={66,1,5,10,50};
		execute(ex4);
		int[] ex5={1000,999,998,997,996};
		execute(ex5);
		int[] ex6={20,5,5,5,5};
		execute(ex6);
		int[] ex7={2,1,5,10,50};
		execute(ex7);
	}
	
	public static void execute(int[] ex) {
		System.out.println(String.format("INPUT ## PRICE %d NOTES %d, %d, %d, %d >>> FOUND MATCH >> %b ", ex[0], ex[1],
				ex[2], ex[3], ex[4], buy(ex[0], ex[1], ex[2], ex[3], ex[4])));
	}
}
