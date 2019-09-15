package com.skill.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CoinProblem {
	static int count = 0;
	static List<int[]> result = new ArrayList<>();

	public static void main(String[] args) {
		
/*		
	final int[][] COINS = {{0,25},{1,10},{2,5},{3,1}};
	int[] coinCounts = {0,0,0,0};
	final int TARGET = 100;
	// getCoinCounts(COINS,coinCounts, TARGET);
	int count = makeChange(45);
	 System.out.println("Count = "+count);*/
	
/*	for(List<int[]> counts : result){
		for( int[] a : counts){
			System.out.println("25 cents : "+a[0]+", 10 cents : "+a[1]+", 5 cents : "+a[2]+", 1 cents : "+a[3]);
		}
	}*/
		
        int arr[] = {1, 2, 3}; 
        int length = arr.length; 
        System.out.println( count(arr, length, 5)); 
	}

	private static void getCoinCounts(int[][] COINS, int[] currCounts, final int TARGET) {

		int currentSum = 0;
		for (int i = 0; i < currCounts.length; i++) {
			currentSum += currCounts[i]*COINS[i][1];
		}
		if(currentSum == TARGET){
			count++;
			System.out.println("25 cents : "+currCounts[0]+", 10 cents : "+currCounts[1]+", 5 cents : "+currCounts[2]+", 1 cents : "+currCounts[3]);
		} 
		else if (currentSum < TARGET){
			for(int i = 0 ; i < currCounts.length ; i++){
				int [] currCountsTemp ;
				currCountsTemp =Arrays.copyOf(currCounts, currCounts.length);
				currCountsTemp[i]++;
				getCoinCounts(COINS,currCountsTemp, TARGET);
			}
		}
		return ;
	}
	private static  int makeChange(int n){
		int[] denoms = {10,25};
		return makeChange(n, denoms,0);
	}

	private static int makeChange(int amount, int[] denoms, int index) {
		if( amount == 0){
			return 1; //last denoms
		}else if(amount < 0) {
			return 0;
		}
		int denomAmount = denoms[index];
		int ways = 0 ; 
		for(int i = 0 ; i*denomAmount <= amount ; i++){
			int amountRemaining = amount - i*denomAmount;
			ways += makeChange(amountRemaining, denoms, index+1);
		}
		return ways;
	}
	
    // Returns the count of ways we can  
    // sum S[0...m-1] coins to get sum n 
    static int count( int S[], int length, int remAmount ) 
    { 
    	
        // If n is 0 then there is 1 solution  
        // (do not include any coin) 
        if (remAmount == 0) 
            return 1; 
          
        // If n is less than 0 then no  
        // solution exists 
        if (remAmount < 0) 
            return 0; 
      
        // If there are no coins and n  
        // is greater than 0, then no 
        // solution exist 
        if (length <=0 && remAmount >= 1) 
            return 0; 
      
        // count is sum of solutions   
        // (i) including S[m-1] 
        // (ii) excluding S[m-1] 
        return count( S, length - 1, remAmount ) +  // excluding S[m-1] 
               count( S, length, remAmount-S[length-1] );  //including S[m-1] 
    } 
}
