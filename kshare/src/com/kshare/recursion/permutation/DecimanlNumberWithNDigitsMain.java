package com.kshare.recursion.permutation;

public class DecimanlNumberWithNDigitsMain {
	public static void main(String[] args) {
		DecimanlNumberWithNDigits decimanlNumberWithNDigits = new DecimanlNumberWithNDigits();
		decimanlNumberWithNDigits.helper(0, new StringBuilder(""), 2);
	}
}
// This problem is based on permutation and followed by backtracking

class DecimanlNumberWithNDigits {

	public void helper(int i, StringBuilder partialSolSB, int constraintSize) {

		if (partialSolSB.length() == constraintSize) {
			System.out.println(partialSolSB.toString());
			return;
		} else if (i == 10 ) {
			if( partialSolSB.length() == constraintSize)
				System.out.println(partialSolSB.toString());
			return;
		} else {
			for (int j = 0; j < 10; j++) {
				partialSolSB.append(j);
				helper(i + 1, partialSolSB, constraintSize);
				partialSolSB.deleteCharAt(partialSolSB.length() - 1);
			}
		}
	}
}
