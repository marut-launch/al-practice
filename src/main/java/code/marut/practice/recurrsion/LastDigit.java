package code.marut.practice.recurrsion;
/*
Limak chose a positive integer X and wrote it on a blackboard. After that, every day he erased the last digit of the current number. 
He stopped when he erased all digits. 
After the process was over, Limak computed the sum of all numbers that appeared on the blackboard, including the original number X. 
For example, if the original number was 509, the numbers that appeared on the blackboard were the numbers 509, 50, and 5. Their sum is 564. 
You are given a long S. Limak wants you to find a number X such that the above process produces the sum S. It can be shown that for any positive S 
there is at most one valid X. If there is a valid X, find and return it. Otherwise, return -1.
 Class:	LastDigit
Method:	findX
Parameters:	long
Returns:	long
Method signature:	long findX(long S)
(be sure your method is public)
Constraints
-	S will be between 1 and 10^18, inclusive.
 */
public class LastDigit {
/*
 * TODO >> Understand the logic, something not clear for me right now!!
 */
	public static long check(long X) {
	    long sum = 0;
	    while (X > 0) {
	      sum += X;
	      X /= 10;
	    }
	    return sum;
	  }
	 
	  public static long findX(long S) {
	    long high = S;
	    long low = 0L;
	    while (high - low > 1L) {
	      long mid = (high + low) / 2;
	      if (check(mid) > S) {
	        high = mid;
	      } else {
	        low = mid;
	      }
	    }
	 
	    for (long i = Math.max(low - 10, 0L); i < high + 10L; i++) {
	      if (check(i) == S) return i;
	    }
	    return -1;
	  }
	  
	  public static void main(String[] args) {
		System.out.println(String.format("SUM %d >> DIGIT >> %d", 564, findX(564l)));
	}
}
