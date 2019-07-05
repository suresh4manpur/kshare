package com.kshare.misc;


public class RainHarvestProblem {
    public static void main(String[] args) {
        int[] arr = {2,1,0,2,0,0,1,3};
        RainHarvestProblem problem = new RainHarvestProblem();
        System.out.println("Sum : "+ problem.getWaterAmount(arr));
    }
    public int getWaterAmount(int []arr){
        int [] leftMaxArr = new int[arr.length];
        int [] rightMaxArr = new int[arr.length];

        int max = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            leftMaxArr[i] = max;
        }
        System.out.println("leftMaxArr : "+leftMaxArr);
        max = 0;
        for (int i = arr.length -1; i >= 0; i--) {
            if(arr[i] > max){
                max = arr[i];
            }
            rightMaxArr[arr.length -1 - i] = max;
        }
        System.out.println("rightMaxArr : "+rightMaxArr);

        int sumArea = 0;

        for (int i = 0; i < arr.length; i++) {
            int tempMin = min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
            sumArea +=  tempMin > -1 ? tempMin : 0;
        }

        return sumArea;
    }
    public int min(int a, int b){
        return a<b ? a:b;
    }

}
