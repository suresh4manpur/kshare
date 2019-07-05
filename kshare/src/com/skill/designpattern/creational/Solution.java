package com.skill.designpattern.creational;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    // Complete the sockMerchant function below.
    //   static int sockMerchant(int n, int[] ar) {


    //   }

    static int simpleArraySum(int[] ar) {
        int sum = 0;
        for(int i =0 ; i < ar.length ; i++){
            sum += ar[i];
        }
    return sum;
    }
    public static void main(String[] args) throws IOException {

     //   int n = scanner.nextInt();
        int n = 9;




        System.out.println("in main");

        int[] ar = {10,30,20,40,10,30,20,40,20};
        int result = sockMerchant(n, ar);
        System.out.println("result : "+result);

    }
    public static int sockMerchant(int n, int[] arItems){
        System.out.println("sockMerchant");
        Map<Integer,Integer> map = new HashMap<>();

        for (int item : arItems) {
            map.put(item, 0);
        }
        int val = 0;
        for(int item : arItems){

            val = map.get(item);

            map.put(item, val+1);
        }
        int count = 0;
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) !=0){
                count += map.get(key)/2;
            }
        }

        return count;
    }
}

