package com.solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProduct {

    public static void main(String[] args) {
        int nums[] = {3,4,5,2};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer num: nums) {
            queue.add(num);
        }
        int firstNum = queue.remove()-1;
        int secondNum = queue.remove()-1;
        return firstNum * secondNum;
    }
    
}
