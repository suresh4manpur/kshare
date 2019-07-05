package com.sort;

public class RadixSort {
public static void main(String[] args) {
	int[] arr = {170,45,75,90,802,24,2,66};
	RadixSort rs = new RadixSort();
	System.out.println("Original Array : ");
	rs.showArray(arr);
	rs.sort(arr);
	System.out.println("Sorted Array");
	rs.showArray(arr);
}
public int getMax(int[] arr){
	int max = 0;
	for(int a : arr){
		if(a > max){
			max = a;
		}
	}
	return max;
}

public void sort(int[]arr){
	int max = getMax(arr);
	for(int exp = 1; max/exp > 0 ; exp *=10){
		 countSort(arr, exp,arr.length);
	}
	
}
public void showArray(int[] arr){
	for(int a : arr){
		System.out.print(a+" ");
	}
	//System.out.println("");
}
public void countSort(int[]arr, int exp, int n){
	int[]count = new int[10];
	int[] result = new int[n];
	//Count the array
	for(int i=0; i< n ; i++){
		count[(arr[i]/exp)%10]++;
		//System.out.println("Count the array");
		//showArray(count);
	}
	// Sum of current and previous value
	for(int j=1; j< 10  ; j++){
		count[j] += count[j-1];
		//System.out.println("Sum of current and previous value");
		//showArray(count);
	}
	//Store the key into result array and decrease the count
	//System.out.println("Store the key into result array and decrease the count");
	for(int k=n-1; k >=0 ; k--){
		result[count[(arr[k]/exp)%10] -1] = arr[k];
		count[(arr[k]/exp)%10]--;
	}
	
	for(int i = 0 ; i < n ; i++){
		arr[i] = result[i]; 
		//showArray(arr);
	}
	//System.out.println("-------------");
}
}
