package com.kshare.recursion.subset;

public class DecimalString {
	public static void main(String[] args) {
		DecimalString decimalString = new DecimalString();
		decimalString.helper(3, new StringBuilder(""));
	}
/**
 * Print all decinal String of length n
 * @param n
 * @param str
 */
	private void helper(int n, StringBuilder str) {
		if (n == 0) {
			System.out.println(str.toString());
		} else {
			for (int i = 0; i < 10; i++) {
				str.append(i);
				helper(n - 1, str);
				str.deleteCharAt(str.length() - 1);
				//removind bcz at same level other node will start from empty state
			}
		}
	}
}
