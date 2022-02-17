package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LeetArray arr = new LeetArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        int result = arr.maxSubArray();
        System.out.println(result);
    }


}
