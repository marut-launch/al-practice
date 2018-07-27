package code.marut.crackingcodinginterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
	Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
	projects, where the second project is dependent on the first project). All of a project's dependencies
	must be built before the project is. Find a build order that will allow the projects to be built. If there
	is no valid build order, return an error.
	EXAMPLE
	Input:
	projects: a, b, c, d, e, f
	dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
	Output: f, e, a, b, d, c

*/
public class BuildDependencies {

	public static class Graph {
		Map<Character, List<Character>> members;

		public Graph() {
			members = new HashMap<>();
		}

		public void add(Character v, Character e) {
			if (!members.containsKey(v)) {
				members.put(v, new ArrayList<>());
			}
			if (e != null) {
				members.get(v).add(e);
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		// (a, d), (f, b), (b, d), (f, a), (d, c)
		graph.add('d', 'a');
		graph.add('b', 'f');
		graph.add('d', 'b');
		graph.add('a', 'f');
		graph.add('c', 'd');
		graph.add('e', null);

		System.out.println(new BuildDependencies().buildOrder(graph));
	}

	public List<Character> buildOrder(Graph g) {
		List<Character> order = new ArrayList<>();
		Set<Character> mark = new HashSet<>();
		Set<Character> cur = new HashSet<>();
		for (Character c : g.members.keySet()) {
			visit(g, c, mark, cur, order);
		}
		return order;
	}

	private void visit(Graph g, Character c, Set<Character> mark, Set<Character> cur, List<Character> order) {
		if (cur.contains(c)) {
			throw new RuntimeException("Cyclic dependency found");
		}
		if (!mark.contains(c)) {
			cur.add(c);
			System.out.println(c);
			if (g.members.get(c) != null) {
				for (Character e : g.members.get(c)) {
					visit(g, e, mark, cur, order);
				}
			}
			mark.add(c);
			cur.remove(c);
			order.add(c);
		}
	}

}
