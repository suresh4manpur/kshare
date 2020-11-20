package com.kshare.recursion.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerPermutationMain {
	public static void main(String[] args) {
		int[] inputStr = {1,2,3,1};
		IntegerPermutation integerPermutation = new IntegerPermutation();
		List<String> result = integerPermutation.getPermutation(inputStr);
		result.stream().forEach(s -> System.out.println(" "+s));
	}

}
class IntegerPermutation{
	private List<String> result = new ArrayList<String>();
	
	public List<String> getPermutation(int[] inputString){
		//helper(0, new StringBuilder(""), inputString);
		//helper1(0, "", inputString);
		//helperWithoutSlate(0, inputString);
		helperWithoutSlateDuplicateEntry(0, inputString);
		return result;
	}
	
	public void helper(int subProb_idx, StringBuilder partialSoln, int[] inputString) {
		if( subProb_idx == inputString.length) {
			result.add(partialSoln.toString());
			return;
		}else {
			for (int i = subProb_idx; i < inputString.length; i++) {
				swap(inputString, subProb_idx, i);
				partialSoln.append(inputString[subProb_idx]);
				helper(subProb_idx+1, partialSoln, inputString);
				partialSoln.deleteCharAt(partialSoln.length() - 1);
				swap(inputString, subProb_idx, i);
			}
		}
		
	}
	public void helperWithoutSlate(int subProb_idx, int[] inputString) {
		if( subProb_idx == inputString.length) {
			result.add(getString(inputString));
			return;
		}else {
			for (int i = subProb_idx; i < inputString.length; i++) {
				swap(inputString, subProb_idx, i);
				helperWithoutSlate(subProb_idx+1, inputString);
				swap(inputString, subProb_idx, i);
			}
		}
		
	}
	public void helperWithoutSlateDuplicateEntry(int subProb_idx, int[] inputString) {
		if( subProb_idx == inputString.length) {
			result.add(getString(inputString));
			return;
		}else {
			Set<Integer> usedValue = new HashSet<>();
			for (int i = subProb_idx; i < inputString.length; i++) {
				if(!usedValue.contains(inputString[i])) {
					usedValue.add(inputString[i]);
					swap(inputString, subProb_idx, i);
					helperWithoutSlate(subProb_idx+1, inputString);
					swap(inputString, subProb_idx, i);
				}
			}
		}
		
	}
	private String getString(int[] inputString) {
		StringBuilder result = new StringBuilder("");
		Arrays.stream(inputString).forEach(i -> result.append(i));
		return result.toString();
	}

	private void swap(int[]s, int i, int j) {
		int temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	public void helper1(int subProb_idx, String partialSoln, int[] inputString) {
		if( subProb_idx == inputString.length) {
			System.out.println(partialSoln);
			return;
		}else {
			for (int i = subProb_idx; i < inputString.length; i++) {
				swap(inputString, subProb_idx, i);
				helper1(subProb_idx+1, partialSoln + inputString[subProb_idx], inputString);
				swap(inputString, subProb_idx, i);
			}
		}
		
	}
	
}
