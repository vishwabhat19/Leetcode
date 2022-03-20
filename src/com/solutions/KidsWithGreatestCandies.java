package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class KidsWithGreatestCandies {

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        kidsWithCandies(candies, 3).stream().forEach(System.out::println);

    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        
        List<Boolean> list = new ArrayList<>();
        int largestValue = Integer.MIN_VALUE;
        for(Integer candy : candies) {
            if(candy >= largestValue) largestValue = candy;
        }
        for(Integer i : candies) {
            if(i+extraCandies >= largestValue) list.add(true);
            else list.add(false);
        }
        
        return list;
    }
    
}
