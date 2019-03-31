package com.kshare.graph;

import java.util.Stack;

public class BellmanFrodAlgo {
	
	public static int V = 6;
public static void main(String[] args) {
	int[][]graph = new int[][] {{0, 50, 45, 10, 0,0}, 
						        {0, 0, 10, 15, 0,0}, 
						        {0, 0, 0, 0, 30,0}, 
						        {0, 0, 0, 0, 15,0}, 
						        {0, 20, 35,0, 0,0},
						        {0, 0, 0, 0, 30,0}
						        }; 
						        
    BellmanFrodAlgo pa = new BellmanFrodAlgo();
    pa.prisMST(graph);
    
}

private void prisMST(int[][] graph) {
	int parent[] = new int[V];
	boolean isMST[] = new boolean[V];
	int key[] = new int[V];
	int u = -1;
	
	//init
	for(int i=0 ; i< V; i++){
		parent[i] = -1;
		isMST[i] = false;
		key[i] = Integer.MAX_VALUE;
	}
	key[0] = 0;
	parent[0] = -1;
	//extract min value from heap
	
	for(int count=0 ; count <V ; count++){
		 u = findMin(key, isMST);
		 System.out.println("u = "+u);
		 if(u == -1){
			 continue;
		 }
		isMST[u] = true;
		
		for(int v=0 ; v <V ; v++){
			if(graph[u][v] != 0 && isMST[v]== false && (key[u] + graph[u][v]) < key[v]){
				key[v] = key[u] + graph[u][v];
				parent[v] = u;
				
			}
		}
		
	}
	System.out.println("here");
	printShortestPaths(parent, graph, key); 

}

private void printShortestPaths(int[] parent, int[][] graph, int []key) {
	Stack<Integer> stack = new Stack<>();

	for(int v=1 ; v <V ; v++){
		//System.out.println(parent[v]+"-"+v+" --> "+graph[v][parent[v]]);
		System.out.println("Path p(0,"+v+") --:");
		int j = v;
		stack.push(j);
		while(key[0] != parent[j]){
			j = parent[j];
			stack.push(j);
		}
		stack.push(0);

		while(stack.size() > 0){
			if(stack.size() > 1){
				System.out.print(stack.pop()+"-->");
			}else{
				System.out.print(stack.pop());
			}
		}
		System.out.println("\n");
	}	
}
private void printPath(){
	
}

private int findMin(int[] key, boolean[] isMST) {
	int min = Integer.MAX_VALUE;
	int min_ind = -1;
	
	for(int i = 0 ; i< key.length ; i++){
		if(isMST[i] == false && key[i] < min){
			min = key[i];
			min_ind = i;
		}
	}
	return min_ind;
}

}
/**
 *   2   5
 * 0---1----4
 * |     \3
 * 3      4
 * 
 * 
 * 
 */
