package com.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

    }

    static int[] twoSum(int []nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int []result = new int[2];
        for(int i = 0;i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                break;
            }
            else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
