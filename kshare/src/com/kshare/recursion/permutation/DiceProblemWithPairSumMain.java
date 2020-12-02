package com.kshare.recursion.permutation;

public class DiceProblemWithPairSumMain {
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6};
		DiceProblemWithPairSumMain diceProblemWithPairSumMain = new DiceProblemWithPairSumMain();
		diceProblemWithPairSumMain.helper(0, new StringBuilder(""), input, 2, 7);
		
		// Two Dices and sum of each dices values is equal to 7.
	}

	private  void helper(int i, StringBuilder partialSoln, int[] input, int constraintSize, int targetSum) {

		if (getSum(partialSoln) > targetSum) {
			return;
		} 
		else if (i == constraintSize) {
			if (getSum(partialSoln) == targetSum) {
				System.out.println(partialSoln);
			}
			return;
		} else {
			for (int j = 0; j < input.length; j++) {
				
				swap(input, i, j);
				partialSoln.append(input[i]);
				helper(i+1, partialSoln, input, constraintSize, targetSum);
				partialSoln.deleteCharAt(partialSoln.length()-1);
				swap(input, i, j);				

			}
		}
	}

	private  void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	private  int getSum(StringBuilder slate) {
		int sum = 0;
		for (int i = 0; i < slate.length(); i++) {
			int val = Character.getNumericValue(slate.charAt(i));
			sum += val;
		}
		return sum;
	}
}
