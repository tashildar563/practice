package org.example.array.YEAR2025;

import org.example.Solution;

public class BestTimeToBuyAndSell implements Solution {

  @Override
  public void logic() {
    int stock[] = {7,1,5,3,6,4};
    int buy = stock[0];
    int profit = 0;
    for( int i=1;i<stock.length;i++){
      if(buy > stock[i]){
        buy = stock[i];
      }else if(profit < stock[i]-buy){
        profit = stock[i]-buy;
      }
    }
    System.out.println("Max profit " +profit);

  }

  @Override
  public String description() {
    return "47";
  }

  @Override
  public String problemStatement() {
    return "You are given an array prices where prices[i] is the price of a given stock on the ith day.\n"
        + "You want to maximize your profit by choosing a single day to buy one stock and choosing a different\n"
        + "day in the future to sell that stock.\n"
        + "Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,\n"
        + "return 0.\n"
        + "Example 1:\n"
        + "Input: prices = [7,1,5,3,6,4]\n"
        + "Output: 5\n"
        + "Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.\n"
        + "Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.";
  }
}
