package com.streams;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(10);
        queue.add(20);
        queue.add(50);
        queue.add(30);

        queue.stream().forEach(System.out::println);
    }
    
}
