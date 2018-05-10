package code.marut.practice.testing;

public class LamdaFunc {

	public static void main(String[] args) {
		getTest().test();
	}
	
	public static MyTest getTest() {
		String myString = "This is getTest function.";
		MyTest f = () -> System.out.println("PPP ## "+ myString);
		return f;
	}
}