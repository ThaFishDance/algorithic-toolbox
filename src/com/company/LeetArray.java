package com.company;

public class LeetArray {

    int[] nums;

    public LeetArray(int[] nums){
        this.nums = nums;
    }

    public int maxSubArray() {
        int maxSum = nums[0];
        int currentSum = maxSum;

        for (int i = 1; i < nums.length; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
