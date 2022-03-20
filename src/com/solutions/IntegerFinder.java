package com.solutions;

import java.util.Scanner;

public class IntegerFinder {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter start range:");
            int startRange = scanner.nextInt();
            System.out.println("Enter end range:");
            int endRange = scanner.nextInt();
            findNumberOfIntegersBetween(startRange, endRange);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void findNumberOfIntegersBetween(int startRange, int endRange) {

        int count = 0;
        for(int i = startRange+1; i < endRange; i++) {
            count++;
        }
        System.out.println("The count is: "+count);
    }
    
}
