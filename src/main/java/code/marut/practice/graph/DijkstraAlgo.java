package code.marut.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DijkstraAlgo {
	int[][] graph;
	int max = 7;

	private class Min<T> implements Comparator<DijkstraAlgo.Node> {
		public int compare(Node o1, Node o2) {
			if (o1.min > o2.min) {
				return 1;
			} else if (o1.min < o2.min) {
				return -1;
			}
			return 0;
		}
	}

	public static class Node {
		public int src, min;
		public String path;

		public Node(int src, int min, String path) {
			this.src = src;
			this.min = min;
			this.path = path;
		}

		@Override
		public String toString() {
			return "Node [src=" + src + ", min=" + min + ", path=" + path + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + src;
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
			Node other = (Node) obj;
			if (src != other.src)
				return false;
			return true;
		}
	}

	public List<Node> getNeighbors(Node node, Set<Node> visited) {
		List<Node> neighbors = new ArrayList<DijkstraAlgo.Node>();
		Node newNode = null;
		for (int i = 0; i < max; i++) {
			newNode = new Node(i, node.min + graph[node.src][i], node.path + "," + i);
			if (graph[node.src][i] != -1 && !visited.contains(newNode)) {
				neighbors.add(newNode);
			}
		}
		return neighbors;
	}

	/*
	 * allPaths format ["start end weight", ....]
	 */
	public int lowest(String[] allPaths, int searchX, int searchY) {
		graph = new int[max][max];
		constructGraph(graph, allPaths);
		int lowest = -1;
		Heap<Node> minHeap = new Heap<DijkstraAlgo.Node>(new Min<Node>());
		Set<Node> visited = new HashSet<DijkstraAlgo.Node>();
		minHeap.add(new Node(0, 0, "0"));
		Node curr = null;
		while ((curr = minHeap.getTop()) != null) {
			if (curr.src == max - 1) {
				System.out.println("PATH ## " + curr.path);
				lowest = curr.min;
				break;
			}
			visited.add(curr);
			System.out.println();
			List<Node> neighbors = getNeighbors(curr, visited);
			for (Node neighbor : neighbors) {
				Node minNode = minHeap.getNode(neighbor);
				if (minNode==null || neighbor.min < minNode.min) {
					minHeap.add(neighbor);
				}
			}
		}
		return lowest;
	}

	public static void main(String[] args) {
		String[] allPaths = { "0 1 4", "0 2 3", "0 4 7", "1 3 5", "1 2 6", "2 3 11", "2 4 8", "3 4 2", "3 6 2",
				"3 5 10", "4 5 5", "5 6 3" };
		System.out.println("LOWEST ## " + new DijkstraAlgo().lowest(allPaths, 6, 6));
	}

	public void constructGraph(int[][] graph, String[] allPaths) {
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], -1);
		}
		for (String path : allPaths) {
			String[] token = path.split(" ");
			graph[new Integer(token[0])][new Integer(token[1])] = new Integer(token[2]);
			graph[new Integer(token[1])][new Integer(token[0])] = new Integer(token[2]);
		}
	}

}
