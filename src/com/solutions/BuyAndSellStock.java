package com.solutions;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int []prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        int leastPrice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            if(prices[i] < leastPrice) {
                leastPrice = prices[i];
            }
            currentProfit = prices[i] - leastPrice;
            if(currentProfit > maxProfit) maxProfit = currentProfit;
        }
        return maxProfit;
    }
    
}
