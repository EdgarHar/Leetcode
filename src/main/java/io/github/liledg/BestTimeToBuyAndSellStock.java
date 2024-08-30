package io.github.liledg;


public class BestTimeToBuyAndSellStock {

  public static int maxProfit(int[] prices) {
    int minBuyPrice = prices[0];
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minBuyPrice) {
        minBuyPrice = prices[i];
      } else {
        maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
      }
    }

    return maxProfit;
  }

  public static int maxProfitSlidingWindow(int[] prices) {
    int leftPointer = 0;
    int rightPointer = 0;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[leftPointer] < prices[rightPointer]) {
        maxProfit = Math.max(maxProfit, prices[rightPointer] - prices[leftPointer]);
      } else {
        leftPointer = rightPointer;
      }

      rightPointer++;
    }

    return maxProfit;
  }


  public static void main(String[] args) {
    System.out.println(maxProfitSlidingWindow(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfitSlidingWindow(new int[]{2, 6, 1, 3}));
  }

}
