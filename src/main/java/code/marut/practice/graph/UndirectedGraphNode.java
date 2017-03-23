package code.marut.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

	String label;
	List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void addNeighbor(UndirectedGraphNode neighbor){
		if(neighbors==null){
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
		neighbors.add(neighbor);
	}
	
	public List<UndirectedGraphNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<UndirectedGraphNode> neighbors) {
		this.neighbors = neighbors;
	}
}