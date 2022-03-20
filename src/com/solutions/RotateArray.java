package com.solutions;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int nums[] = {1,2};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        if(nums.length==0 || nums.length==1) return;
        reverse(nums,0,nums.length-1); //Reverse entire Array
        reverse(nums,0,k-1); // Reverse first k elements
        reverse(nums,k,nums.length-1); // Reverse the rest of the elements
        Arrays.stream(nums).forEach(System.out::println);
    }

    static void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp =  nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
