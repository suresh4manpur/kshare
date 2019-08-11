package com.skill.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSetNumber {
	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		List<Integer> subset = new ArrayList<>();
		List<List<Integer>> results = new ArrayList<>();
		getAllSubsets(num, results, subset, 0);
		System.out.println(results);
	}

	private static void getAllSubsets(int[] num, List<List<Integer>> results, List<Integer> subset, int startIndex) {
		System.out.println("subset 1 : "+subset);
		results.add(new ArrayList<>(subset));
		for(int i = startIndex ; i<num.length ; i++){
			subset.add(num[i]);
			getAllSubsets(num, results, subset, i + 1);
			subset.remove(subset.size()-1);
			System.out.println("subset 2 : "+subset);

		}
	}
}
