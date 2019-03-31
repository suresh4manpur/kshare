import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import javax.management.Query;

public class GraphDFS {
	public static void main(String[] args) {
		GraphAdjacencyList graph = new GraphAdjacencyList(7);
		graph.addVertex(1, 2);
		graph.addVertex(2, 6);
		graph.addVertex(1, 3);
		graph.addVertex(3, 4);
		graph.addVertex(4, 2);
		graph.addVertex(4, 5);
		//graph.dfs(3);
		graph.bfs(1);
	}
}

class GraphAdjacencyList{
	int totalVertices;
	LinkedList[] adj ;
	Boolean visited[];
	int[] visitedVertex ;
	
	public GraphAdjacencyList(int vertexSize){
		this.totalVertices = vertexSize;
		adj = new LinkedList[vertexSize];
		visited = new Boolean[vertexSize];
		visitedVertex = new int[vertexSize];
		for(int i = 0 ; i< adj.length ; i++){
			adj[i] = new LinkedList<>();
			visited[i] = false;
		}
	}

	public void addVertex(int src, int dest){
		if(!adj[src].contains(dest)){
			adj[src].add(dest);
		}
	}
	public void bfs(int startVert){
		Queue<Integer> que = new LinkedBlockingQueue<>();
		
		que.add(startVert);
		System.out.println(startVert +" ");
		int current = 0 ;
		while(que.size() != 0){
		current = que.remove();
		 Iterator<Integer>  it = adj[current].listIterator();
		 int adjNeb = 0;
		 while(it.hasNext()){
			 adjNeb = it.next();
			 if(!visited[adjNeb]){
				System.out.println(adjNeb +" ");
				visited[adjNeb] = true;
				 que.add(adjNeb);
			 }
		 }
		}
		
	}
	public void dfs(int startVert){
		
		Stack<Integer> stack = new Stack<>();
		
		
		stack.push(startVert);
		visited[startVert] = true;
		System.out.println(startVert +" ");
		
		int current = 0;
		while( stack.size() != 0){
			current = stack.peek();
			
			if(adj[current].size() == 0){ //It does not have any adjacent vertex // Vertex does not have neighbors
				stack.pop();
				continue;
			}
			 Iterator<Integer> it = adj[current].listIterator();
			 
			 while(it.hasNext()){
				 current = it.next();
				 
				 if(!visited[current]){
					 visited[current] = true;
					 stack.push(current);
					 System.out.println(current +" ");
					 break;
				 }else if(visited[current] && !it.hasNext()){ // reached dead end.
					 stack.pop();
				 }else{
					 continue;
				 }

			 }
		}
	}	
}

