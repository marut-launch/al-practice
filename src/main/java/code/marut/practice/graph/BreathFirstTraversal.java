package code.marut.practice.graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Breadth First Traversal for a Graph
 */
public class BreathFirstTraversal {

	public static void bfs(Graph graph, int data) {
		boolean[] visited = new boolean[graph.getVertexCnt()];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[data] = true;
		queue.add(data);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			data = queue.poll();
			System.out.print(data + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = graph.getAdj()[data].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal (starting from vertex 2)");

		bfs(g, 2);
	}
}
