package com.streams;

public class ReverseInteger {
    
    public static void main(String[] args) {
        System.out.println("Reverse String is: "+reverse(-326));
    }

    private static Integer reverse(int i) {
        
        if(i == 0) return 0;

        long answer = 0;

        while( i != 0 ) {
            answer = answer * 10 + i % 10;
           i = i/10;
        }

        if(answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) return 0;
        return (int)answer;
    }
}
