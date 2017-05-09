package code.marut.practice.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Write a function which will return all symmetric combination possible for input number of digits.
	 Example >> 
	 1) function (1 digit) >> { "0", "1", "8" }
	 2) function (2 digit) >> { "0", "1", "8", "00", "11", "88", "96", "69" }
	 3) function (3 digit) >> { "0", "1", "8", "00", "11", "88", "96", "69", 000, 010, 080, 101, 111, 181, 808, 818, 888, 906, 916, 986, 609, 619, 689 }
 */
public class PrintSymmetricComb {
	public static void main(String[] args) {
		int digits = 3;
		List<String> finalLst = new PrintSymmetricComb().allSymmetricComb(digits);
		System.out.println("FINAL LIST for " + digits + " digits ## " + finalLst);
		System.out.println(" CNT ## " + finalLst.size());

	}

	public List<String> allSymmetricComb(int digits) {
		Map<Integer, List<String>> functionMap = new HashMap<Integer, List<String>>();

		functionMap.put(1, Arrays.asList(new String[] { "0", "1", "8" }));
		functionMap.put(2, Arrays.asList(new String[] { "00", "11", "88", "96", "69" }));
		calculateFunction(functionMap, digits);
		List<String> finalLst = new ArrayList<String>();
		while (digits > 0) {
			finalLst.addAll(functionMap.get(digits--));
		}
		return finalLst;
	}

	private void calculateFunction(Map<Integer, List<String>> functionMap, int digits) {
		if (digits < 3) {
			return;
		}
		if (!functionMap.containsKey(digits - 1)) {
			calculateFunction(functionMap, digits - 1);
		}
		List<String> multiplier = functionMap.get(digits - 2);
		List<String> res = new ArrayList<String>();
		for (String s : functionMap.get(2)) {
			for (String cn : multiplier) {
				res.add(s.charAt(0) + cn + s.charAt(1));
			}
		}
		functionMap.put(digits, res);
	}
}
