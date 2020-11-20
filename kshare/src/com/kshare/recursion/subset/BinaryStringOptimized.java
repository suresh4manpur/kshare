package com.kshare.recursion.subset;

public class BinaryStringOptimized {
	public static void main(String[] args) {
		BinaryStringOptimized binaryStringOptimized = new BinaryStringOptimized();
		binaryStringOptimized.binaryString("",3);
	}
	
	public void binaryString(String inputString, int n) {
		
		if(n == 0) {
			System.out.println(inputString);
		}else {
			binaryString(inputString+"0", n-1);
			binaryString(inputString+"1", n-1);
		}
	}
}
