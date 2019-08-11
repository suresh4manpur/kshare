package com.skill.backtracking;

public class QueensProblem {
	static int n = 0;

	public static void main(String[] args) {
		int size = 4;
		int[][] arr = new int[size][size];
		queenMove(0, arr);

	}

	public static void queenMove(int cols, int arr[][]) {
		int n = arr.length;
		if (cols == n) {
			System.out.println("found the solution!");
			print(arr);
			System.out.println("--------------------------");
			return;
			//queenMove();  
		}
		for (int i = 0; i < n; i++) {
			if (isSafe(i, cols, arr)) {
				arr[i][cols] = 1;
				System.out.println("("+i+","+cols+")");
				queenMove(++cols, arr);
				arr[i][--cols] = 0;
			}
		}
	}

	private static void print(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}

	}

	private static boolean isSafe(int row, int col, int[][] arr) {
		boolean isSafe = true;
		
		//check upward
		for (int i = row; i >= 0 ; i--) {
			if(arr[i][col] == 1){
				isSafe = false;
				break;
			}
		}
		//check left
		for (int i = col; i >= 0 ; i--) {
			if(arr[row][i] == 1){
				isSafe = false;
				break;
			}
		}
		//check diagonally left up
		for (int i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
			if(arr[i][j] == 1){
				isSafe = false;
				break;
			}
		}
		//check diagonally left down
		for (int i = row, j = col; i < arr.length && j >=0 ; i++, j--) {
			if(arr[i][j] == 1){
				isSafe = false;
				break;
			}
		}
		return isSafe;
	}
}
