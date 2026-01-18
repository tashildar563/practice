package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

public class BestTimeToBuyAndSellStockUsingStrategy implements Solution {
  private static final int maxsize = 100001;
  private static long[] prefixSum = new long[maxsize];
/*
* */



  @Override
  public void logic() {
    int [] prices = {4,2,8};
    int [] strategy = {-1,0,1};
    int k=2;
    int n = prices.length,half=k/2;
    Arrays.fill(prefixSum,0,n+1,0);

    for(int i=0;i<n;i++){
      prefixSum[i+1] = prefixSum[i]+(long) strategy[i]*prices[i];
    }

    long windowSum=0;
    for(int i=half;i<k;i++){
      windowSum+=prices[i];
    }

    long maxProfit = Math.max(prefixSum[n],windowSum+prefixSum[n]-prefixSum[k]);

    for(int start=1;start+k<=n; start++){
      windowSum +=prices[start+k-1]-prices[start+half-1];
      maxProfit = Math.max(maxProfit,windowSum+prefixSum[n]-prefixSum[start+k]+prefixSum[start]);
    }
    System.out.println("Max profit "+maxProfit);
  }

  private int calculateprofit(int maxProfit, int[] prices, int[] strategy) {
    int profit=0;
    for(int i=0;i<strategy.length;i++){
      profit += prices[i]*strategy[i];

    }
    return Math.max(profit,maxProfit);
  }

  @Override
  public String description() {
    return "57 Best Time to Buy and Sell Stock using Strategy";
  }

  @Override
  public String problemStatement() {
    return "You are given two integer arrays prices and strategy, where:\n"
        + "\n"
        + "prices[i] is the price of a given stock on the ith day.\n"
        + "strategy[i] represents a trading action on the ith day, where:\n"
        + "-1 indicates buying one unit of the stock.\n"
        + "0 indicates holding the stock.\n"
        + "1 indicates selling one unit of the stock.\n"
        + "You are also given an even integer k, and may perform at most one modification to strategy. A modification consists of:\n"
        + "\n"
        + "Selecting exactly k consecutive elements in strategy.\n"
        + "Set the first k / 2 elements to 0 (hold).\n"
        + "Set the last k / 2 elements to 1 (sell).\n"
        + "The profit is defined as the sum of strategy[i] * prices[i] across all days.\n"
        + "\n"
        + "Return the maximum possible profit you can achieve.\n"
        + "\n"
        + "Note: There are no constraints on budget or stock ownership, so all buy and sell operations are feasible regardless of past actions.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: prices = [4,2,8], strategy = [-1,0,1], k = 2\n"
        + "\n"
        + "Output: 10\n"
        + "\n"
        + "Explanation:\n"
        + "\n"
        + "Modification\tStrategy\tProfit Calculation\tProfit\n"
        + "Original\t[-1, 0, 1]\t(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8\t4\n"
        + "Modify [0, 1]\t[0, 1, 1]\t(0 × 4) + (1 × 2) + (1 × 8) = 0 + 2 + 8\t10\n"
        + "Modify [1, 2]\t[-1, 0, 1]\t(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8\t4\n"
        + "Thus, the maximum possible profit is 10, which is achieved by modifying the subarray [0, 1]\u200B\u200B\u200B\u200B\u200B\u200B\u200B.";
  }
}
