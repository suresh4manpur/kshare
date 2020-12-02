package com.kshare.recursion.subset;

public class CombinationOfKNumbersOutOfN {
	public static void main(String[] args) {
		CombinationOfKNumbersOutOfN combinationOfKNumbersOutOfN = new CombinationOfKNumbersOutOfN();
		combinationOfKNumbersOutOfN.getAllSolutions(4, 2);
	}

	/**
	 * Given two integers n & k, return all possible combination of k numbers out of
	 * n [solution is nCk]
	 * OR
	 * How to calculate nCk problem
	 * @param i
	 * @param partialSoln
	 * @param input
	 */

	private void getAllSolutions(int n, int k) {
		helper(0, new StringBuilder(""), k, n);
	}

	private void helper(int i, StringBuilder partialSoln, int constraintSize, int inputSize) {
		// Backtracking case applicable on all nodes
		if (partialSoln.length() == constraintSize) {
			System.out.println(partialSoln);
			return;
		}

		// Base case leaf worker
		else if (i == inputSize) {
			if(partialSoln.length() == constraintSize) {
				System.out.println(partialSoln);	
			}
			return;
		} 
		// normal recursive case
		else {
			helper(i + 1, partialSoln, constraintSize, inputSize);
			
			partialSoln.append(i + 1);
			helper(i + 1, partialSoln, constraintSize, inputSize);
			partialSoln.deleteCharAt(partialSoln.length() - 1);

		}
	}
}
