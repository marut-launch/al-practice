package code.marut.practice.array;

import java.util.Arrays;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
	bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateSquareMatrixBy90Degrees {

	public static void rotateMatrix90Degrees(Integer[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}

	public static void printMatrix(Integer[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.asList(mat[i]));
		}
	}

	public static void main(String[] args) {

		Integer[][] test = { { 1, 3, 5, 7 }, { 9, 0, 1, 3 }, { 8, 1, 2, 7 }, { 0, 4, 6, 8 } };
		printMatrix(test);
		rotateMatrix90Degrees(test);
		System.out.println("=================");
		printMatrix(test);

	}

}
