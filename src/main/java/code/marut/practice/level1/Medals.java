package code.marut.practice.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The Olympic Games in Athens end tomorrow. Given the results of the olympic disciplines, generate and return the medal table.
The results of the disciplines are given as a String[] results, where each element is in the format "GGG SSS BBB".
 GGG, SSS and BBB are the 3-letter country codes (three capital letters from 'A' to 'Z') of the countries winning 
 the gold, silver and bronze medal respectively.
The medal table is a String[] with an element for each country appearing in results. Each element has to be in the format 
"CCO G S B" (quotes for clarity), where G, S and B are the number of gold, silver and bronze medals won by country CCO,
 e.g. "AUT 1 4 1". The numbers should not have any extra leading zeros. 
Sort the elements by the number of gold medals won in decreasing order. If several countries are tied, sort the tied countries 
by the number of silver medals won in decreasing order. If some countries are still tied, sort the tied countries by the number
 of bronze medals won in decreasing order. If a tie still remains, sort the tied countries by their 3-letter code in ascending 
 alphabetical order.

Definition
Class:	MedalTable
Method:	generate
Parameters:	String[]
Returns:	String[]
Method signature:	String[] generate(String[] results)
(be sure your method is public)    
 
Constraints
-	results contains between 1 and 50 elements, inclusive.
-	Each element of results is formatted as described in the problem statement.
-	No more than 50 different countries appear in results.
 
Examples
0)	
    	
{"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"}
Returns: 
{ "KOR 3 1 0",
 "ITA 1 0 0",
 "TPE 0 1 1",
 "CHN 0 1 0",
 "JPN 0 1 0",
 "AUS 0 0 1",
 "GBR 0 0 1",
 "UKR 0 0 1" }
These are the results of the archery competitions.
1)	
    	
{"USA AUT ROM"}
Returns: { "USA 1 0 0",  "AUT 0 1 0",  "ROM 0 0 1" }
2)	
    	
{"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"}
Returns: { "AUT 1 1 1",  "GER 1 1 1",  "SUI 1 1 1" }

 */
public class Medals {
	private class CountryMedals implements Comparable {
		public String cCode;
		public int g, s, b;

		public CountryMedals(String cCode) {
			this.cCode = cCode;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cCode == null) ? 0 : cCode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CountryMedals other = (CountryMedals) obj;
			if (cCode == null) {
				if (other.cCode != null)
					return false;
			} else if (!cCode.equals(other.cCode))
				return false;
			return true;
		}

		public int compareTo(Object o) {
			CountryMedals c = (CountryMedals) o;
			if (g != c.g)
				return c.g - g;
			if (s != c.s)
				return c.s - s;
			if (b != c.b)
				return c.b - b;
			return cCode.compareTo(c.cCode);
	}

	@Override
	public String toString() {
		return cCode + " " + g + " " + s + " " + b;
	}

	}

	public void printCountryWiseResult(String[] results) {
		String[] finalResult = generate(results);
		System.out.println(String.format("INPUT #### %s", Arrays.asList(results)));
		System.out.println(String.format("OUTPUT #### %s", Arrays.asList(finalResult)));
		System.out.println(" ================================================================================");
	}

	public String[] generate(String[] results) {
		Map<String, CountryMedals> finalResultMp = new HashMap<String, CountryMedals>();
		for (String res : results) {
			String[] tok = res.split(" ");
			CountryMedals cm = finalResultMp.get(tok[0]);
			if (cm == null) {
				cm = new CountryMedals(tok[0]);
				finalResultMp.put(tok[0], cm);
			}
			cm.g++;
			cm = finalResultMp.get(tok[1]);
			if (cm == null) {
				cm = new CountryMedals(tok[1]);
				finalResultMp.put(tok[1], cm);
			}
			cm.s++;
			cm = finalResultMp.get(tok[2]);
			if (cm == null) {
				cm = new CountryMedals(tok[2]);
				finalResultMp.put(tok[2], cm);
			}
			cm.b++;
		}
		List<CountryMedals> finalResult = new ArrayList<CountryMedals>(finalResultMp.values());
		Collections.sort(finalResult);
		if (finalResult.size() > 0) {
			String[] strRes = new String[finalResult.size()];
			int i = 0;
			for (CountryMedals med : finalResult) {
				strRes[i++] = med.toString();
			}
			return strRes;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		String[] test1 = { "ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE" };
		new Medals().printCountryWiseResult(test1);
		String[] test2 ={"SOL MOZ BOT", "JOR CUB GUA", "TPE MRI BLR", "KEN NRU KSA", "PAK BLR TPE", "MLT CZE BRA", "KAZ TLS NCA", "TLS ECU GBS", "NRU ECU TAN", "ANG PAR CAF", "KGZ KUW PLE", "NRU AZE ANT", "BEL YUG NCA", "CHA KGZ GRE", "PUR CUB KGZ", "PAK THA PUR", "TLS GUA NRU", "KUW GBS ANT", "UGA ARG GBS", "SRI ARG BOT", "ANT MOZ PAK", "SOL EST PUR", "THA GRN RSA", "MLT MRI GBS", "UGA GUY MRI", "KEN CGO KSA", "GBS BOT UGA", "AZE PAK EST", "BOT NGR GRN", "KAZ KUW GUY", "NCA MLT AZE"};
		new Medals().printCountryWiseResult(test2);
	}
}
