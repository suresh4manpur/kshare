package com.sort;

public class QuickSort {
	public static void main(String[] args) {
	}
	public void sort(int[] a, int first, int last){
		int i = first;
		int j = last;
		int pivote = i;
		boolean rightToLeft = true;
		while(i < j){
			if(a[i] > a[j]){
				swap(a, i, j);
				pivote = j;
			}
			j--;
		}
	}
	private void swap(int []a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
