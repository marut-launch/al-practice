package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FindClosestAncestorColor {

    public static class Node {
        private int data;
        private int color;
        private List<Node> nodes;

        public Node(final int data, final int color) {
            this.data = data;
            this.color = color;
        }

        public void addChild(Node n) {
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(n);
        }

        public int getColor() {
            return color;
        }

        public int getData() {
            return data;
        }

        public List<Node> getNodes() {
            return nodes;
        }
    }

    public static void main(String[] args) {
        final int totalVertex = 10;
        final int totalColors = 4;
//        final int[] parents = {1, 1, 2, 2, 9, 3, 7, 7, 4};
//        final int[] colors = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        final int[] parents = {1, 1, 2, 2, 9, 3, 7, 7, 4};
        final int[] colors = {1, 2, 3, 4, 5, 1, 1, 3, 4, 5};

        final Node tree = constructTree(totalVertex, parents, colors);
        final Integer[] closestAncestorColor = findClosestAncestorColor(tree, totalVertex);
        System.out.println("Closest parent colors:: " + Arrays.asList(closestAncestorColor));
    }

    private static Node constructTree(final int totalVertex,
                                      final int[] parents,
                                      final int[] colors) {
        final Node[] allNodes = new Node[totalVertex];
        for (int i = 1; i <= totalVertex; i++) {
            allNodes[i - 1] = new Node(i, colors[i - 1]);
        }
        for (int i = 0; i < parents.length; i++) {
            final Node parentNode = allNodes[parents[i] - 1];
            parentNode.addChild(allNodes[i + 1]);
        }
        return allNodes[0];
    }

    private static Integer[] findClosestAncestorColor(final Node root, final int totalVertex) {
        final Integer[] closestAncestorColors = new Integer[totalVertex];
        for (int i = 0; i < totalVertex; i++) {
            closestAncestorColors[i] = -1;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        pushAndUpdateAncestor(stack, closestAncestorColors);

        return closestAncestorColors;
    }

    private static void pushAndUpdateAncestor(final Stack<Node> stack, final Integer[] closestAncestorColors) {
        if (stack.isEmpty()) {
            return;
        }
        final Node cur = stack.peek();
        System.out.println("Current ::" + cur.getData());
        if (cur.getNodes() != null) {
            for (Node temp : cur.getNodes()) {
                stack.push(temp);
                pushAndUpdateAncestor(stack, closestAncestorColors);
            }
        }
        stack.pop();
        for (int i = stack.size()-1; i >=0; i--) {
            Node searched = stack.get(i);
            if (cur.getColor() == searched.getColor()) {
                closestAncestorColors[cur.getData() - 1] = searched.getData();
                break;
            }
        }
    }
}
