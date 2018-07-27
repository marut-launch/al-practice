package code.marut.practice.level1;

/*
 * Given a list of people with their birth and death years,
 * Find the year with highest population.
 */

public class FindMaxPopulationYear {

	public static class Delta{
		public int year, delta;
		public Delta(int year, int delta) {
			this.year = year;
			this.delta = delta;
		}
	}
	
	public int findHighestPopulatedYear(int[] birthYears, int[] deathYears) {
		Delta[] yearwisePopulation = generatePopulationByYear(birthYears, deathYears);
		return maxPopulation(yearwisePopulation);
	}
	
	private Delta[] generatePopulationByYear(int[] birthYears, int[] deathYears) {
		Delta[] yearwisePopulation = new Delta[birthYears.length*2];
		for (int i=0;i<birthYears.length;i++) {
			
		}
		return yearwisePopulation;
	}
	
	private void insertedIntoSortedArray(Delta[] yearwisePopulation) {
		
	}
	
	private int maxPopulation(Delta[] yearwisePopulation) {
		return 0;
	}
	
}
