package com.kshare.graph;


/**
 * 5
 * 4
 * 0
 * 2
 * 3
 * 1
 */
		
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortGraph {

	Stack<Integer> stack;
	LinkedList<Integer> adjList[];
	int V;
	boolean isVisited[];
	//boolean isPushed[];

	public static void main(String[] args) {
		TopologicalSortGraph graph = new TopologicalSortGraph(6);

		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		//graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 1);
		
		graph.topologicalSort();
		graph.printSorteOrder();
	}

	public TopologicalSortGraph(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		isVisited = new boolean[V];
		//isPushed = new boolean[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>();
			isVisited[i] = false;
			stack = new Stack<>();
			//isPushed[i] = false;
		}
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}

	public void topologicalSort() {

		for (int u = 0; u < V; u++) {
			if (!isVisited[u])
			toplogicalSortUtil(u);
		}
	}

	public void toplogicalSortUtil(int u) {
		//adjacent vertices
		Iterator<Integer> it = adjList[u].iterator();
		isVisited[u] = true;
		while (it.hasNext()) {
			int v = it.next();
			// adjacent vertex which was not visited.
			if (!isVisited[v]) {
				//isVisited[v] = true;
					toplogicalSortUtil(v);
			}
		}
		// since every adjacent vertices are visited and pushed so will pushed u
		stack.push(u);
/*			isVisited[u] = true;
			
			if(!isPushed[u]){
				isPushed[u] = true;
				stack.push(u);
			}*/
			
	}

	public void printSorteOrder() {
		
		while (!stack.isEmpty()) {
			System.out.println(" " + stack.pop());
		}
	}
}
