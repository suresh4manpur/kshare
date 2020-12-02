package com.kshare.recursion.permutation;

public class ParenthesisGeneration {
	public static void main(String[] args) {
		ParenthesisGeneration parenthesisGeneration = new ParenthesisGeneration();
		int n = 4;

		parenthesisGeneration.helper(0, new char[n*2], 0, 0, n);
	}
	private void helper(int i, char[] slateChar,int open, int close ,int n) {
		if(i == slateChar.length) {
			print(slateChar);
			return;
		}else {
			//here we have two choices
			
			//1. include '{'
			if(open < n ) {
				slateChar[i] = '{';
				open++;
				helper(i+1, slateChar, open, close, n);
				slateChar[i] = '\0';
				open--;
			}
			//2. include '}'
			if(open > close) {
				slateChar[i] = '}';
				close++;
				helper(i+1, slateChar, open, close, n);
				slateChar[i] = '\0';
				close--;
			}
		}
	}
	private void print(char[] slateChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < slateChar.length; i++) {
			sb.append(slateChar[i]);
		}
		System.out.println(sb.toString());
	}
}
