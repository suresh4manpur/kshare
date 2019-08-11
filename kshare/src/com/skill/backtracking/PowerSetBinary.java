package com.skill.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSetBinary {
	public static void main(String[] args) {
		String inputStr = "abcd";
		List<String> result = new ArrayList<String>();
		subset(0,inputStr, "", result);
		for(String value  : result){
			System.out.println(value);
		}
	}
	public static void subset(int index, String inputStr, String curr, List<String> result)
	{
		if(index == inputStr.length()){
			result.add(curr);
			//System.out.println(curr);
		}
		else
		{
			subset(index + 1, inputStr, curr, result);
			subset(index + 1, inputStr, curr+inputStr.charAt(index), result);
		}
	}
}
