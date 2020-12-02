package com.kshare.recursion;

public class NQueen {
	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		int n = 8;
		nQueen.helper(0, new int[n][n], n);
	}

	public void helper(int col, int[][] slate, int size) {
		if (col == size) {
			print(slate);
			System.out.println("");
			return;
		} else {
			for (int row = 0; row < slate.length; row++) {
				if (validEntry(slate, row, col)) {
					slate[row][col] = 1;
					helper(col+1, slate, size);
					slate[row][col] = 0;
				}
			}
		}
	}

	private boolean validEntry(int[][] slate, int row, int col) {
		//check left entry
		for(int i = col ; i >=0 ; i--) {
			if(1 == slate[row][i]){
				return	false;
			}
		}
		// Check diagonally left upward entry
		for (int i = row, j = col ; i >= 0 && j >= 0; i--, j--) {
			if(slate[i][j] == 1) {
				return false;
			}
		}
		//Check diagonally left downward entry
		for (int  i = row, j = col; j >= 0 && i < slate.length; j--, i++) {
			if(slate[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	private void print(int[][] slate) {
		for (int row = 0; row < slate.length; row++) {
			for (int col = 0; col < slate[row].length; col++) {
				System.out.print(" " + slate[row][col]);
			}
			System.out.println("");
		}

	}
}
