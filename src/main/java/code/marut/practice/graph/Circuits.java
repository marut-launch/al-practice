package code.marut.practice.graph;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
An essential part of circuit design and general system optimization is critical path analysis. On a chip, the critical path 
represents the longest path any signal would have to travel during execution. In this problem we will be analyzing chip designs 
to determine their critical path length. The chips in this problem will not contain any cycles, i.e. there exists no path from one 
component of a chip back to itself.

Given a String[] connects representing the wiring scheme, and a String[] costs representing the cost of each connection, your 
method will return the size of the most costly path between any 2 components on the chip. In other words, you are to find the 
longest path in a directed, acyclic graph. Element j of connects will list the components of the chip that can be reached directly 
from the jth component (0-based). Element j of costs will list the costs of each connection mentioned in the jth element of connects. As mentioned above, the chip will not contain any cyclic paths. For example:

connects = {"1 2",
            "2",
            ""}
costs    = {"5 3",
            "7",
            ""}
In this example, component 0 connects to components 1 and 2 with costs 5 and 3 respectively. Component 1 connects to component 2 
with a cost of 7. All connections mentioned are directed. This means a connection from component i to component j does not imply a 
connection from component j to component i. Since we are looking for the longest path between any 2 components, your method would 
return 12.
 
Definition
Class:	Circuits
Method:	howLong
Parameters:	String[], String[]
Returns:	int
Method signature:	int howLong(String[] connects, String[] costs)
(be sure your method is public)
 
Constraints
-	connects must contain between 2 and 50 elements inclusive
-	connects must contain the same number of elements as costs
-	Each element of connects must contain between 0 and 50 characters inclusive
-	Each element of costs must contain between 0 and 50 characters inclusive
-	Element i of connects must contain the same number of integers as element i of costs
-	Each integer in each element of connects must be between 0 and the size of connects-1 inclusive
-	Each integer in each element of costs must be between 1 and 1000 inclusive
-	Each element of connects may not contain repeated integers
-	Each element of connects must be a single space delimited list of integers, each of which has no extra leading zeros. There will be no leading or trailing whitespace.
-	Each element of costs must be a single space delimited list of integers, each of which has no extra leading zeros. There will be no leading or trailing whitespace.
-	The circuit may not contain any cycles

 */
public class Circuits {

	public void printLongestCircuit(String[] connects, String[] costs, int expected) {
		int longest = howLong(connects, costs);
		System.out.println(String.format("INPUT CONNECT ## %s", Arrays.asList(connects)));
		System.out.println(String.format("INPUT COSTS ## %s", Arrays.asList(connects)));
		System.out.println(String.format("LONGEST  ## %d", longest));
		System.out.println(String.format("RESULT  ## %s", (longest == expected ? "PASSED" : "FAILED")));
		System.out.println("=============================================");
	}

	public int howLong(String[] connects, String[] costs) {
		int res = 0;
		int n = connects.length;
		int[][] allCosts = new int[n][n];
		for (int i = 0; i < n; i++) {
			if (!connects[i].equals("")) {
				StringTokenizer cn = new StringTokenizer(connects[i], " ");
				StringTokenizer co = new StringTokenizer(costs[i], " ");
				while (cn.hasMoreTokens()) {
					allCosts[i][new Integer(cn.nextToken())] = new Integer(co.nextToken());
				}
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (allCosts[i][j] < allCosts[i][k] + allCosts[k][j] && allCosts[i][k] != 0
							&& allCosts[k][j] != 0) {
						allCosts[i][j] = allCosts[i][k] + allCosts[k][j];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (allCosts[i][j] > res) {
					res = allCosts[i][j];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] connects1 = { "1 2 3 4 5", "2 3 4 5", "3 4 5", "4 5", "5", "" };
		String[] costs1 = { "2 2 2 2 2", "2 2 2 2", "2 2 2", "2 2", "2", "" };
		new Circuits().printLongestCircuit(connects1, costs1, 10);

		String[] connects2 = { "1", "2", "3", "", "5", "6", "7", "" };
		String[] costs2 = { "2", "2", "2", "", "3", "3", "3", "" };
		new Circuits().printLongestCircuit(connects2, costs2, 9);

		String[] connects3 = { "", "2 3 5", "4 5", "5 6", "7", "7 8", "8 9", "10", "10 11 12", "11", "12", "12", "" };
		String[] costs3 = { "", "3 2 9", "2 4", "6 9", "3", "1 2", "1 2", "5", "5 6 9", "2", "5", "3", "" };
		new Circuits().printLongestCircuit(connects3, costs3, 22);

		String[] connects4 = {"","2 3","3 4 5","4 6","5 6","7","5 7",""};
		String[] costs4 = {"","30 50","19 6 40","12 10","35 23","8","11 20",""};
		new Circuits().printLongestCircuit(connects4, costs4, 105);
	}
}
