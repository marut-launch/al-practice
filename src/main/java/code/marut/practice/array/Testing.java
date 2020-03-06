package code.marut.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Minimum time required to rot all oranges
Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges
*/
public class Testing {

    private static class Dim {
        public int r;
        public int c;

        public Dim(final int r, final int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            final Dim dim = (Dim) o;

            if (r != dim.r)
                return false;
            return c == dim.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }
    }

    public static void main(String[] args) {

        final int[][] data = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        findResutl(data);
    }

    private static void findResutl(final int[][] data) {
        final Map<Dim, Boolean> visited = new HashMap<>();
        final Dim marker = new Dim(-1, -1);
        final Queue<Dim> rotten = new LinkedList<Dim>();
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                final Dim current = new Dim(r, c);
                if (data[r][c] == 2) {
                    rotten.add(current);
                    visited.put(current, true);
                } else {
                    visited.put(current, false);
                }
            }
        }

        int result = markRottenOranges(rotten, marker, visited, data);
        boolean failed = false;
        for (Dim key : visited.keySet()) {
            if (!visited.get(key)) {
                failed = true;
                break;
            }
        }
        if (failed) {
            System.out.println("RESULT :: all oranges can't be rotten");
        } else {
            System.out.println("RESULT ::" + (result - 1));
        }
    }

    private static int markRottenOranges(final Queue<Dim> rotten,
                                         final Dim marker,
                                         final Map<Dim, Boolean> visited,
                                         final int[][] data) {
        if (rotten.isEmpty()) {
            return 0;
        }
        rotten.add(marker);
        while (!rotten.isEmpty() && !rotten.peek().equals(marker)) {
            final Dim current = rotten.remove();
            final List<Dim> neighbors = findNeighbors(current.r, current.c, data);
            for (Dim d : neighbors) {
                if (!visited.get(d)) {
                    visited.put(d, true);
                    if (data[d.r][d.c] == 1) {
                        rotten.add(d);
                    }
                }
            }
        }
        rotten.remove();
        return 1 + markRottenOranges(rotten, marker, visited, data);
    }

    private static List<Dim> findNeighbors(final int r, int c, final int[][] data) {
        final List<Dim> neighbors = new ArrayList<Dim>();
        int maxR = data.length - 1;
        int maxC = data[0].length - 1;
        addIfValid(neighbors, r - 1, c, maxR, maxC);
        addIfValid(neighbors, r + 1, c, maxR, maxC);
        addIfValid(neighbors, r, c - 1, maxR, maxC);
        addIfValid(neighbors, r, c + 1, maxR, maxC);
        return neighbors;
    }

    private static void addIfValid(final List<Dim> neighbors,
                                   final int r,
                                   final int c,
                                   final int maxR,
                                   final int maxC) {
        if (r >= 0 && r <= maxR && c >= 0 && c <= maxC) {
            neighbors.add(new Dim(r, c));
        }
    }
}
