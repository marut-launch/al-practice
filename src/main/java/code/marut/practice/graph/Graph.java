package code.marut.practice.graph;

import java.util.LinkedList;

/*
 * This class represents a directed graph using adjacency list representation 
 */
public class Graph {
	private int vertexCnt;
	private LinkedList<Integer> adj[];
	
	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	public int getVertexCnt(){
		return this.vertexCnt;
	}
	
	public Graph (int vertexCnt){
		this.vertexCnt = vertexCnt;
		adj=new LinkedList[vertexCnt];
		for(int i =0;i<vertexCnt;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
}
