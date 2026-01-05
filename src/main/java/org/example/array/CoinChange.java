package org.example.array;

import java.util.Arrays;
import org.example.Solution;

public class CoinChange implements Solution {

  @Override
  public void logic() {
    int[] coins = {5,6,8,9,10,12};
    int amt = 14;
    int mincoins[] = new int[amt+1];
    Arrays.fill(mincoins,amt+1);
    mincoins[0] = 0;
    for(int i=1;i<=amt ; i++){
      for(int coin: coins){
        int diff = i-coin;
        if(diff>=0){
          mincoins[i] = Math.min(mincoins[i],1+mincoins[i-coin]);
        }
      }
    }
    System.out.println("min coins " + (mincoins[amt] != amt + 1 ? mincoins[amt] : -1));
  }

  @Override
  public String description() {
    return "28. Coin Change";
  }

  @Override
  public String problemStatement() {
    return
        "You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.\n"
            + "\n"
            + "Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.\n"
            + "\n"
            + "You may assume that you have an infinite number of each kind of coin.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "Input: coins = [1,2,5], amount = 11\n"
            + "Output: 3\n"
            + "Explanation: 11 = 5 + 5 + 1\n"
            + "Example 2:\n"
            + "\n"
            + "Input: coins = [2], amount = 3\n"
            + "Output: -1\n"
            + "Example 3:\n"
            + "\n"
            + "Input: coins = [1], amount = 0\n"
            + "Output: 0";
  }
}
