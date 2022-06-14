package com.solutions;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int nums[] = { 3, 0, 1 };
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedSum = length*(length+1)/2;
        int sum = Arrays.stream(nums).sum();
        return (expectedSum-sum);
    }
}
