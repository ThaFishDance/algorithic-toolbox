package com.company;

public class LeetArray {

    int[] arr;

    public LeetArray(int[] nums){
        this.arr = nums;
    }

    public int maxSubArray() {
        int maxSum = arr[0];
        int currentSum = maxSum;

        for (int i = 1; i < arr.length; i++){
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
