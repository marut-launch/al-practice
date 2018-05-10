package code.marut.practice.recurrsion;

/*
We have a pile of crates at our warehouse that we want to load onto trucks. Our plan is to divide the pile in half forming two smaller piles, 
then continuing dividing each of the small piles in half until we get piles that will fit on a truck. (Of course, when we divide an odd number of crates 
in "half", one of the resulting piles will have one more crate than the other.) Our problem is to determine how many trucks we will need to ship the crates.
Create a class Truckloads that contains a method numTrucks that is given numCrates (the number of crates at the warehouse) and loadSize (the maximum number 
of crates that will fit in a truck) and that returns the number of trucks required.

Class:	Truckloads
Method:	numTrucks
Parameters:	int, int
Returns:	int
Method signature:	int numTrucks(int numCrates, int loadSize)
(be sure your method is public) 
Constraints
-	numCrates will be between 2 and 10,000, inclusive.
-	loadSize loadSize will be be between 1 and (numCrates - 1), inclusive.
 */
public class Truckloads {

	static int[] load = null;

	public static int numTrucks(int numCrates, int loadSize) {
		if (numCrates == 0) {
			return 0;
		}
		if (load == null) {
			load = new int[numCrates];
			for(int i=0;i<numCrates;i++){
				load[i]=-1;
			}
		}
		if (load[numCrates - 1] < 0) {
			if (loadSize >= numCrates) {
				load[numCrates - 1] = 1;
			}else{
				load[numCrates - 1] = numTrucks((numCrates / 2), loadSize)
						+ numTrucks(numCrates - (numCrates / 2), loadSize);
			}
		}
		return load[numCrates - 1];
	}

	public static void main(String[] args) {
		printExecute(new int[]{14, 3});
		printExecute(new int[]{15, 1});
		printExecute(new int[]{	1024, 5});
		printExecute(new int[]{10000, 79});
		printExecute(new int[]{894, 22});
		printExecute(new int[]{10000, 1});
		printExecute(new int[]{	15, 5});
		printExecute(new int[]{	21, 5});
		printExecute(new int[]{12, 5});
		printExecute(new int[]{11, 5});
		printExecute(new int[]{2, 1});
		printExecute(new int[]{3, 2});
		printExecute(new int[]{10000, 9999});
		printExecute(new int[]{	7777, 1});
		printExecute(new int[]{9999, 1111});
	}
	
	public static void printExecute(int[] a){
		load = null;
		System.out.println(String.format("Crates # %d, LoadSize # %d >>> TRUCKS NEEDED %d ", a[0], a[1], numTrucks(a[0], a[1])));
	}
}
