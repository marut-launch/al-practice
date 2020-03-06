package problem;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Integer[] input = {1, 3, 2, 5, 4, 7};

        System.out.println("Input:: " + Arrays.asList(input));
        int totalMoves = totalMove(input);
        System.out.println("output:: " + Arrays.asList(input));
        System.out.println("Total moves :: " + totalMoves);
    }

    private static int totalMove(Integer[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {

            }
        }
        int i = 1;
        int moves = 0;
        System.out.println(Arrays.asList(input));
        while (i < input.length - 1) {
            if (input[i - 1] > input[i]) {
                moveToFront(input, i);
                i = 1;
                moves++;
            } else {
                i++;
            }
        }
        return moves;
    }

    private static void moveToFront(Integer[] input, int cur) {
        int val = input[cur];
        for (int i = cur; i > 0; i--) {
            input[i] = input[i - 1];
        }
        input[0] = val;
    }
}
