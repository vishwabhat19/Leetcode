package com.solutions;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        moveZeros(nums);
    }

    static void moveZeros(int[] nums) {
        int nonZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroIndex++;
                nums[nonZeroIndex] = nums[i];
            }
        }
        for (int i = nonZeroIndex + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

}
