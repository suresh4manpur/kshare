package com.sort;

public class CountSort {
public static void main(String[] args) {
	int[]a = {1,4,1,2,7,5,2};
	//Assume the range of number is 0-9
	int[] countArr = new int[10]; 
	int[] resultArr = new int[a.length];
	
	//count each number and store the count in corresponding array position.
	for(int i=0 ; i<a.length ; i++){
		countArr[a[i]]++;
	}
	System.out.println(countArr);
	// Sum of current array position of current and previous value.
	for(int j=1; j<countArr.length ; j++){
		countArr[j] += countArr[j-1];
	}
	System.out.println(countArr);

	for(int i=0 ; i<a.length ; i++){
		resultArr[countArr[a[i]]-1] = a[i];
		--countArr[a[i]];
	}
	for(int k : resultArr){
		System.out.println(k);
	}
	
}
}
