package com.kshare.recursion.subset;

import java.util.ArrayList;
import java.util.List;

public class Rough {
	public static void main(String[] args) {
		/*
		 * int[] input = {1,2,3,4,5}; helper(0, new StringBuilder(""), input, 6);
		 */
		
		int[] input = {1,-2,3,-4,5};
		helperWithNegativeValues(0, new ArrayList<Integer>(), input, 2);
	}

	/**
	 * Print all combinations of subsets of n whose sum is k, provided all are +ve integer.
	 * 
	 * @param i
	 * @param slate
	 * @param input
	 * @param constrantSum
	 */
	private static void helper(int i, StringBuilder slate, int[] input, int constrantSum) {
		if (getSum(slate) == constrantSum) {
			System.out.println(slate.toString());
		}else if(getSum(slate) > constrantSum) {
			return;
		}
		else if( i == input.length ) {
			if(getSum(slate) == constrantSum) {
				System.out.println(slate.toString());
			}
		}else {
			helper(i+1, slate, input, constrantSum);
			slate.append(input[i]);
			helper(i+1, slate, input, constrantSum);
			slate.deleteCharAt(slate.length() - 1);
		}
	}

	private static int getSum(StringBuilder slate) {
		int sum = 0;
		for (int i = 0; i < slate.length(); i++) {
			int val = Character.getNumericValue(slate.charAt(i));
			sum += val;
		}
		return sum;
	}
	
	/**
	 * Print all combinations of subsets of n whose sum is k, provided all are +ve and -ve integer.
	 * 
	 * @param i
	 * @param slate
	 * @param input
	 * @param constrantSum
	 */
	private static void helperWithNegativeValues(int i, List<Integer> slate, int[] input, int constrantSum) {

		if( i == input.length ) {
			if(getSumFromArray(slate) == constrantSum) {
				System.out.println(slate.toString());
			}
		}else {
			helperWithNegativeValues(i+1, slate, input, constrantSum);
			slate.add(input[i]);
			helperWithNegativeValues(i+1, slate, input, constrantSum);
			slate.remove(slate.size()-1);
		}
	}

	private static int getSumFromArray(List<Integer> slate) {
		int sum = 0;
		for (int i : slate) {
			sum += i;
		}
		return sum;
	}
}