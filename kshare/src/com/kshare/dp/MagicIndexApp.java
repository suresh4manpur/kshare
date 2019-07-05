package com.kshare.dp;

public class MagicIndexApp {
    public static void main(String[] args) {
        int [] inputArr = {-40,-20,-1,1,2,3,5,7,9,12,13};
        //input is in sorted order
       int magicIndex =  getMagicIndex(inputArr);
        System.out.println("Magic Index = "+magicIndex);

    }

    private static int getMagicIndex(int[] inputArr) {
        int start = 0;
        int end = inputArr.length-1;
        int magicIndex = magicFast(inputArr, start, end);
        return magicIndex;
    }

    private static int magicFast(int[] inputArr, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;

        if(mid == inputArr[mid]){
            return mid;
        }
       else {
           if(inputArr[mid] > mid ){
                start = mid + 1;
            }
           else{
               end = mid - 1;
           }
        }
       return  magicFast(inputArr, start, end);
    }

    public static int getMagicIndexBrute(int[] inputArr){
        for (int i = 0; i < inputArr.length; i++) {
            if (i == inputArr[i]){
                return i;
            }
        }
        return -1;
    }
}

