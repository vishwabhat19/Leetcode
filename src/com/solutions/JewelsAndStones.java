package com.streams;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    private static int numJewelsInStones(String jewels, String stones) {

        Set<Character> jewelSet = new HashSet<>();
        jewels.chars().mapToObj((i) -> (char)i).forEach(c -> jewelSet.add(c));
        long count = stones.chars().mapToObj(i -> (char)i).filter(c -> jewelSet.contains(c)).count();
        return (int)count;
    }
    
}
