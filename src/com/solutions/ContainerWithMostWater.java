package com.solutions;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int nums[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    static int maxArea(int nums[]) {
        int maxArea = Integer.MIN_VALUE;

        int start = 0;
        int end = nums.length-1;
        while(start<end) {
            int tempArea = (end-start)*Math.min(nums[start], nums[end]);
            if(maxArea<tempArea) maxArea = tempArea;
            if(nums[end]>nums[start]) {
                start++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }
    
}
