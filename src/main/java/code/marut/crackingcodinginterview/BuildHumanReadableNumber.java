package code.marut.crackingcodinginterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BuildHumanReadableNumber {

	private final static long ten = 10l;
	private final static long one_hundred = ten * ten;
	private final static long one_thousand = one_hundred * ten;
	private final static long one_million = one_thousand * one_thousand;
	private final static long one_billion = one_million * one_thousand;

	public static void main(String[] args) {
		long num = 1013;
		System.out.println(Solution1.buildHumanReadableNumber(num, constructHumanreadables()));
		System.out.println(Solution2.buildHumanReadableNumber(num, constructHumanreadables()));
		System.out.println(Solution3.buildHumanReadableNumber(num, constructHumanreadables()));
	}

	private static Map<Long, String> constructHumanreadables() {
		Map<Long, String> humanReadables = new HashMap<>();
		humanReadables.put(1l, "one");
		humanReadables.put(2l, "two");
		humanReadables.put(3l, "three");
		humanReadables.put(13l, "thirteen");
		humanReadables.put(20l, "twenty");
		humanReadables.put(30l, "thirty");
		humanReadables.put(100l, "hundred");
		humanReadables.put(1000l, "thousand");
		humanReadables.put((1000l * 1000l), "million");
		return humanReadables;
	}

	private static class Solution1 {
		public static String buildHumanReadableNumber(long num, Map<Long, String> humanReadables) {
			return constructHumanReadable(humanReadables, num, one_billion);
		}

		private static String constructHumanReadable(Map<Long, String> humanReadables, long num, long divider) {
			long currReminder = num % divider;
			long currentDivider = divider;
			long currNum = num / divider;
			if (divider > one_thousand) {
				currentDivider = currentDivider / one_thousand;
			} else if (divider > ten) {
				currentDivider = currentDivider / ten;
			}
			if (num == 0) {
				return "";
			}
			if (divider == ten) {
				if (currReminder == 0) {
					return humanReadables.get(num);
				} else {
					System.out.println(currNum + " ##" + num + " ##  " + humanReadables.get(currNum * 10));
					return (currNum != 0 ? humanReadables.get(currNum * 10) : "") + " "
							+ humanReadables.get(currReminder);
				}
			}
			if (currNum == 0) {
				return constructHumanReadable(humanReadables, currReminder, currentDivider);
			} else {
				return constructHumanReadable(humanReadables, currNum, divider) + " " + humanReadables.get(divider)
						+ " " + constructHumanReadable(humanReadables, currReminder, currentDivider);
			}
		}
	}

	private static class Solution2 {
		public static String buildHumanReadableNumber(long num, Map<Long, String> humanReadables) {
			return constructHumanReadable(num, 0, humanReadables);
		}

		private static String constructHumanReadable(long num, int level, Map<Long, String> humanReadables) {
			if (num == 0) {
				return "";
			}
			String s = computeTenDigit(humanReadables, num % 100);
			num = num / 100;
			if (num > 0) {
				s = " " + computeTenDigit(humanReadables, num % 10) + " " + levelHumanReadable(level++) + " " + s;
				return constructHumanReadable(num / 10, level, humanReadables) + " " + s;
			}
			return s;
		}

		private static String levelHumanReadable(int level) {
			if (level == 0) {
				return "Hundred";
			} else if (level == 1) {
				return "thousand";
			} else if (level == 2) {
				return "million";
			} else if (level == 3) {
				return "billion";
			} else {
				return "";
			}
		}

		private static String computeTenDigit(Map<Long, String> humanReadables, long number) {
			if (number / 10 == 0 || humanReadables.containsKey(number)) {
				return humanReadables.get(number);
			} else {
				String s = humanReadables.get((number / 10) * 10);
				return s + " " + computeTenDigit(humanReadables, number % 10);
			}
		}

	}

	private static class Solution3 {
		public static String buildHumanReadableNumber(long num, Map<Long, String> humanReadables) {
			if (num > 0) {
				long temp = num;
				Stack<String> s = new Stack<>();
				int l = 1;
				long prev = -1;
				int level=0;

				while (temp > 0) {
					long digit = temp % 10;
					temp = temp / 10;
					if (digit > 0) {
						if (l % 3 == 1) {
							s.push(humanReadables.get(digit));
						} else if (l % 3 == 2) {
							long newDigit = digit * 10 + prev;
							if (humanReadables.containsKey(newDigit)) {
								System.out.println("REMOVED #" + s.pop());
								s.push(humanReadables.get(newDigit));
							} else {
								s.push(humanReadables.get(digit * 10));
							}
						} else {
							s.push(levelHumanReadable(level));
							s.push(humanReadables.get(digit));
						}
					}
					if(l%3==0) {
						level++;
					}
					prev = digit;
					l++;
				}
				String humanReadable = "";
				while (!s.isEmpty()) {
					humanReadable += s.pop();
					humanReadable += " ";
				}
				return humanReadable;
			} else {
				return humanReadables.get(num);
			}
		}

		private static String levelHumanReadable(int level) {
			if (level == 0) {
				return "Hundred";
			} else if (level == 1) {
				return "thousand";
			} else if (level == 2) {
				return "million";
			} else if (level == 3) {
				return "billion";
			} else {
				return "";
			}
		}
	}
}