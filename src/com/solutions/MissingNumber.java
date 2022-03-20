package com.solutions;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int nums[] = { 3, 0, 1 };
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int currentSum = Arrays.stream(nums).sum();
        int maxNumber = (int)Arrays.stream(nums).count();
        int expectedSum = maxNumber * (maxNumber + 1) / 2;
        return (expectedSum - currentSum);
    }
}
