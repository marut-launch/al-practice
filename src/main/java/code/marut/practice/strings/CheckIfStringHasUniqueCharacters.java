package code.marut.practice.strings;

/*
 * Implement an algorithm to determine if a string has all unique characters. What if you
can not use additional data structures?
 */
public class CheckIfStringHasUniqueCharacters {

	public static boolean isAllCharacterUnique(String arg) {
		int checker = 0;
		for (int i = 0; i < arg.length(); ++i) {
			int val = arg.charAt(i) - 'a';
			System.out.println("$$$$ CHAR $$$$"+(arg.charAt(i)));
			System.out.println("$$$$ SUBS $$$$"+(char)(arg.charAt(i) - 'a') + " %%% VAL %%%" + val + "##  checker ## "+ checker);
			System.out.println("$$$$ 1 $$$$"+(1 << val));
			System.out.println("$$$$ 2 $$$$" + (checker & (1 << val)));
			System.out.println("===========");
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test1 = "tesing";
		System.out.println(String.format("isAllCharacterUnique for %s # %b", test1, isAllCharacterUnique(test1)));
	}

}
