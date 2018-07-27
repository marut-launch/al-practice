package code.marut.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
For a undirected graph with tree characteristics, we can choose any node as the root. 
The result graph is then a rooted tree. Among all possible rooted trees, those with 
minimum height are called minimum height trees (MHTs). Given such a graph, write a 
function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given 
the number n and a list of undirected edges (each edge is a pair of labels).
You can assume that no duplicate edges will appear in edges. Since all 
edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear 
together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]
Example 2 :
Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 
Output: [3, 4]
 */
public class MinimumHeightTrees {
	public static void main(String[] args) {
		int [][] edges1 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, edges1));
		int [][] edges2 =  {{1, 0}, {1, 2}, {1, 3}};
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, edges2));
		int [][] edges3 =  {{0,1},{0,2},{0,3},{3,4},{4,5}};
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, edges3));
	}
	
	Map<Integer, Set<Integer>> graph;

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		constructGraph(edges);
		if(graph==null || graph.isEmpty()) {
			return null;
		}
		Set<Integer> result = new HashSet<>();
		for(Integer key:graph.keySet()) {
			if(graph.get(key).size()==1) {
				result.addAll(graph.get(key));
			}
		}
		return Arrays.asList(result.toArray(new Integer[0]));
	}

	private void constructGraph(int[][] edges) {
		if (edges != null && edges.length > 0) {
			graph = new HashMap();
			for (int i = 0; i < edges.length; i++) {
				if (edges[i].length == 2) {
					Integer e1 = edges[i][0];
					Integer e2 = edges[i][1];
					addToGraph(e1, e2);
					addToGraph(e2, e1);
				}
			}
		}
	}

	private void addToGraph(Integer k, Integer v) {
		if (!graph.containsKey(k)) {
			graph.put(k, new HashSet<>());
		}
		graph.get(k).add(v);
	}
}
