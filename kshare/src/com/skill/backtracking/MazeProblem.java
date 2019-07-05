package com.skill.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazeProblem {
	static List<List<Point>> result = new ArrayList<>();
	public static void main(String[] args) {
		int[][] maze = new int[4][4];
		maze[2][0] = 1;
		maze[1][2] = 1;
		
	//	List<List<Point>> result = new ArrayList<>();
		List<Point> recList = new ArrayList();
		int r = 0;
		int c = 0;

		getPaths(maze, recList, r, c);
		System.out.println(result);
		System.out.println("Possible Path : "+result.size());
		

	}

	private static void getPaths(int[][] maze, List<Point> recList, int r, int c) {
		System.out.println("getPaths => ("+r+","+c+")");
		recList.add(new Point(r,c));
		
		if(r == maze.length-1 && c == maze.length-1){ //reached destination
			List<Point> path =new ArrayList(recList);
			result.add(path);
			recList.remove(recList.size()-1);
			return;
		}else{
			//only right
			//only left
			
			// currently we are on Point(r,c)
			
			//collection of possible moves from Point(r,c)
/*			for(Move move : moves){
				getPath(move);
				
			}*/
			
			//go right 
			if(c+1 < maze.length && maze[r][c+1] == 0)
			getPaths(maze, recList, r, c+1);
			
			//go down
			if(r+1 < maze.length && maze[r+1][c] == 0)
			getPaths(maze, recList, r+1, c);
			
			recList.remove(recList.size()-1);
		}
		
		return ;
	}


}
