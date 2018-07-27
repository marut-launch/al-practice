package code.marut.crackingcodinginterview;

import java.util.HashMap;
import java.util.Map;

public class Multiply {

	public static void main(String[] args) {
		long a = 11212323, b = 98928392;
		long start = System.currentTimeMillis();
		System.out.println(sol1.mul(a, b));
		long end = System.currentTimeMillis();
		System.out.println("Completed in " + (end - start) + " millis");
		start = System.currentTimeMillis();
		System.out.println(sol2.mul(a, b));
		end = System.currentTimeMillis();
		System.out.println("Completed in " + (end - start) + " millis");

	}

	public static class sol1 {
		public static long mul(long a, long b) {
			long smaller = a < b ? a : b;
			long bigger = a < b ? b : a;
			return multiple(smaller, bigger);
		}

		private static long multiple(long smaller, long bigger) {
			if (smaller == 0) {
				return bigger;
			} else if (smaller == 1) {
				return bigger;
			}
			long half = smaller >> 1;
			long l = multiple(half, bigger);
			long r = l;
			if (smaller % 2 == 1) {
				return l + r + bigger;
			}
			return l + r;
		}
	}

	public static class sol2 {
		public static long mul(long a, long b) {
			long smaller = a < b ? a : b;
			long bigger = a < b ? b : a;
			Map<Long, Long> store = new HashMap<>();
			return multiple(smaller, bigger, store);
		}

		private static long multiple(long smaller, long bigger, Map<Long, Long> store) {
			if (smaller == 0) {
				return bigger;
			} else if (smaller == 1) {
				return bigger;
			} else if (store.get(smaller) != null) {
				return store.get(smaller);
			}
			long half = smaller >> 1;
			long l = multiple(half, bigger, store);
			long r = l;
			if (smaller % 2 == 1) {
				store.put(smaller, l + r + bigger);
			} else {
				store.put(smaller, l + r);
			}
			return store.get(smaller);
		}
	}

}
