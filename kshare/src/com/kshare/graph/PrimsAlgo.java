package com.kshare.graph;

public class PrimsAlgo {

	
	public static int V = 5;
public static void main(String[] args) {
	int[][]graph = new int[][] {{0, 2, 0, 6, 0}, 
						        {2, 0, 3, 8, 5}, 
						        {0, 3, 0, 0, 7}, 
						        {6, 8, 0, 0, 9}, 
						        {0, 5, 7, 9, 0}}; 
						        
						        PrimsAlgo prims = new PrimsAlgo();
						        prims.prisMST(graph);
    
}

private void prisMST(int[][] graph) {
	int parent[] = new int[V];
	boolean isMST[] = new boolean[V];
	int key[] = new int[V];
	
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
		int u = findMin(key, isMST);
		isMST[u] = true;
		
		for(int v=0 ; v <V ; v++){
			if(graph[u][v] != 0 && isMST[v]== false && graph[u][v] < key[v]){
				key[v] = graph[u][v];
				parent[v] = u;
				
			}
		}
		
	}
	printMST(parent, graph);

}

private void printMST(int[] parent, int[][] graph) {
	System.out.println("Edge \t Weight");

	for(int v=1 ; v <V ; v++){
		System.out.println(parent[v]+"-"+v+" --> "+graph[v][parent[v]]);
	}	
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
