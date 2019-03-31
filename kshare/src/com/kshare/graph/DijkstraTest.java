package com.kshare.graph;

public class DijkstraTest {
	int size = 5;
	public static void main(String[] args) {
		int[][] graph = new int[][] { 
			{ 0, 4, 1, 0, 0 }, 
			{ 0, 0, 0, 0, 4 }, 
			{ 0, 2, 0, 4, 0 }, 
			{ 0, 0, 0, 0, 4 },
			{ 0, 0, 0, 0, 0 }
			};
		DijkstraTest dTest = new DijkstraTest();
		dTest.findShortestPath(graph);
	}

	private void findShortestPath(int[][] graph) {
		// TODO Auto-generated method stub
		int[] parent = new int[size];
		int[] dist = new int[size];
		//assigning
		for(int i = 0 ; i < size ; i++){
			parent[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		// for each vertex
		for(int u = 0 ; u < size ; u++){
			//for loop n-1
			//do the relaxation for all adjacent vertex
			for(int v = 1 ; v < size ; v++){
				if( graph[u][v]>0 && (dist[u] + graph[u][v]) < dist[v] ){
					dist[v] = dist[u] + graph[u][v]; // update the minimum distance
					parent[v] = u;
				}
			}
		}
		
		for(int k = 1 ; k < size ; k++){
			int u = k;
			while(parent[u] != -1){
				System.out.print("-- "+u);
				u = parent[u];
			}
			System.out.println("---------");
		}
	}

}
