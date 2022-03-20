package com.solutions;

public class Maxsubarray {

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int nums[]) {
        if(nums.length == 0) return nums[0];
        int maxSum = nums[0];
        int tempSum = 0;
        for(int i=0;i<nums.length;i++) {
            tempSum += nums[i];
            if(tempSum > maxSum) maxSum = tempSum;
            if(tempSum < 0) tempSum = 0;

        }
        return maxSum;
    }
    
}
