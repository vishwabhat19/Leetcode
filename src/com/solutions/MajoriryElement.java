package com.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajoriryElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3,4,4,4,4,4,4,4,4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(
            num -> {
                if(map.containsKey(num)) {
                    int count = map.get(num)+1;
                    map.put(num, count);
                }
                else {
                    map.put(num, 1);
                }
            }
        );
        return map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get().getKey();
    }
    
}
