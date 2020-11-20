package com.kshare.recursion.phonenumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationOfPhoneNumberMain {

	public static void main(String[] args) {
		
			CombinationOfPhoneNumber combinationOfPhoneNumber = new CombinationOfPhoneNumber();
			
			combinationOfPhoneNumber.getPhoneNumber(0, new StringBuilder(""), (Integer[]) Arrays.asList(2,3).toArray());
	}
}

class CombinationOfPhoneNumber {
	static Map<Integer, String[]> inputMap = new HashMap<>();
	static {
		inputMap.put(2, (String[]) Arrays.asList("a", "b", "c").toArray());
		inputMap.put(3, (String[]) Arrays.asList("d", "e", "f").toArray());
		inputMap.put(4, (String[]) Arrays.asList("g", "h", "i").toArray());
	}
	public void getPhoneNumber(int i, StringBuilder slate, Integer[] input) {
		helper(i, slate, input);
	}

	public void helper(int i, StringBuilder slate, Integer[] input) {
		if (i == input.length)
			System.out.println(slate);
		else {
			int key = input[i];
			String[] strArr = inputMap.get(key);
			
			for( int j = 0 ; j< strArr.length ; j++) {
				slate.append(strArr[j]);
				helper(i+1, slate, input);
				slate.deleteCharAt(slate.length() - 1);
			}
		}
	}

}
