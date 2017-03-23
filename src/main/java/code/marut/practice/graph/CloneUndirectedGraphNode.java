package code.marut.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneUndirectedGraphNode {

	public static UndirectedGraphNode clone_usingDFS(UndirectedGraphNode graph) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return cloneDFS(graph, map);
	}

	public static UndirectedGraphNode clone_usingBFS(UndirectedGraphNode graph) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return clone_usingBFS(graph, map);
	}

	public static UndirectedGraphNode clone_usingBFS(UndirectedGraphNode graph,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		Queue<UndirectedGraphNode> nodes = new LinkedList<UndirectedGraphNode>();
		if (graph == null) {
			return null;
		}
		UndirectedGraphNode cloneGraph = new UndirectedGraphNode(graph.label);
		map.put(graph, cloneGraph);
		nodes.add(graph);
		while (!nodes.isEmpty()) {
			UndirectedGraphNode temp = nodes.poll();
			for (UndirectedGraphNode neighbor : temp.getNeighbors()) {
				UndirectedGraphNode neighborCl = map.get(neighbor);
				if (neighborCl == null) {
					neighborCl = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, neighborCl);
					nodes.add(neighbor);
				}
				temp.addNeighbor(neighborCl);
			}
		}
		return cloneGraph;
	}

	private static UndirectedGraphNode cloneDFS(UndirectedGraphNode graph,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(graph)) {
			return map.get(graph);
		}
		UndirectedGraphNode cloneGraph = new UndirectedGraphNode(graph.label);
		map.put(graph, cloneGraph);
		for (UndirectedGraphNode neighbor : graph.getNeighbors()) {
			cloneGraph.addNeighbor(cloneDFS(neighbor, map));
		}
		return cloneGraph;
	}

	public static void main(String[] args) {
	}
}
