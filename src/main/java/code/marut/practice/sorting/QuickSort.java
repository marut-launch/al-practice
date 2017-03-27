package code.marut.practice.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void quicksort(Integer[] data) {
		if (data != null) {
			quicksort(data, 0, data.length - 1);
		}
	}

	private static void quicksort(Integer[] data, int low, int high) {
		if (low < high) {
			int pivot = partition(data, low, high);
			quicksort(data, low, pivot - 1);
			quicksort(data, pivot + 1, high);
		}
	}

	private static int partition(Integer[] data, int low, int high) {
		int p = high;
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (data[j] <= data[p]) {
				i++;
				if (i != j) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		if (i + 1 != p) {
			int temp = data[p];
			data[p] = data[i + 1];
			data[i + 1] = temp;
		}
		return i + 1;
	}
	
	public static void main(String[] args) {
		Integer[] test1 = {4,66,1,5,55,90,22,1,87,64,0,1,4,9,3,5,11,76,31};
		Integer[] test = {9,20,1,11,12,90,7,3,5};
		System.out.println("Unsorted ARRAY ## "+ Arrays.asList(test));
		quicksort(test);
		System.out.println("Sorted ARRAY ## "+ Arrays.asList(test));
	}

}
