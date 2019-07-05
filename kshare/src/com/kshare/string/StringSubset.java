package com.kshare.string;

public class StringSubset {
	public static void main(String[] args) {
		System.out.println("Start..");
		int[] a = {1,2,3};
		int n = a.length;
		String str = "";
		for(int i = 0; i < n ; i++ ){
			
			for(int j = 0; j<n ; j++ ){
				str = ""+a[j];
				for(int k = 1; k<(i) ; k++){
					str = str+a[k];
				}
				System.out.println(str);
			}
		}
	}
}
