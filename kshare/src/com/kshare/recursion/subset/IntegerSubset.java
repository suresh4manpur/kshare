package com.kshare.recursion.subset;

import java.util.Arrays;

public class IntegerSubset {
	public static void main(String[] args) {
		IntegerSubset integerSubset = new IntegerSubset();
		int [] num = {1,2,2};
		//integerSubset.printSubset(3, "", num);
		Arrays.parallelSort(num);
		integerSubset.printSubsetWithDuplicateValue(0, "", num);
	}
	private void printSubset(int i, String partialSoln, int [] input) {
		if(i == input.length) {
			System.out.println(partialSoln);
		}else {
			int currVal = input[i];

			printSubsetWithDuplicateValue(i+1, partialSoln, input); //exclude last number
			printSubsetWithDuplicateValue(i+1, partialSoln + currVal, input); // include last number
		}
	}
	
	private void printSubsetWithDuplicateValue(int i, String partialSoln, int [] input) {
		if(i == input.length) {
			System.out.println(partialSoln);
		}else {
			int count = 0;
			count = getFrequency(i, input);
			
			printSubsetWithDuplicateValue(i+count, partialSoln, input); //exclude last number
			
			String partialSolnTemp = partialSoln;
			for(int j = 0 ; j < count ; j++) {
				partialSolnTemp = partialSolnTemp + input[i];
				printSubsetWithDuplicateValue(i+count, partialSolnTemp , input); // include last number
			}
		}
	}
	private int getFrequency(int i, int[] input) {
		int count=0;
		
		for (int j = i; j < input.length; j++) {
			if(input[j] == input[i]) {
				count++;
			}
		}
		return count;
	}
}
