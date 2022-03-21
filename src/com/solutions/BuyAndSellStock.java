package com.solutions;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int []prices) {
        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = 0;
        int lowestPrice = prices[0];
        for(int i=0;i<prices.length;i++) {
            if(lowestPrice > prices[i]) lowestPrice = prices[i];
            currentProfit = prices[i] - lowestPrice;
            if(currentProfit > maxProfit) maxProfit = currentProfit;
            
        }
        return maxProfit;
    }
    
}
