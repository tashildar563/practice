package org.example.array.YEAR2025;

import org.example.Solution;

public class WaystoExpressanIntegerasSumofPowers implements Solution {

  /*
  * solve using 1D DP similar to 0/1 Knapsack
  * step 1 precompute possible powers
  * loop over intergers starting from 1
  * reais each to the x-th power
  * stop when the power exceeds n.
  *
  *
  * step 2 dp definition
  * let dp[s] number of ways to form sum s
  * using the powers considereed so far
  *   dp[0] = 1 -> one way to make sum 0 (choose nothing)
  *   dp[1...n] = = initially
  *
  * step 3 iterate over each power
  * for each power p:
  *   look backwards from n down to p
  *   update:  dp[sum]+=dp[sum-p]
  *
  *backward looping ensures each power is used at most once
  *
  * dp[n] will contain the total number of valid combinations
  *
  *
  * */

  @Override
  public void logic() {
    int n = 4, x = 2;
    int MOD = 1000000007;
    long[] dp = new long[n+1];
    dp[0]=1;
    for(int i=1;Math.pow(i,x)<=n;i++){
      int power = (int) Math.pow(i,x);
      for(int sum=n;sum>=power;sum--){
        dp[sum]=(dp[sum] + dp[sum-power])%MOD;
      }
    }
    System.out.println("output " + dp[n]);
  }

  private void findPowers(int[] res, int n, int x, int i) {
    long p = (long) Math.pow(i, x);
    if (p <= n) {
      res[i]++;
      findPowers(res, n, x, i + 1);
    }
  }

  @Override
  public String description() {
    return "87. 2787 Ways to Express an Integer as Sum of Powers";
  }

  @Override
  public String problemStatement() {
    return "Given two positive integers n and x.\n"
        + "\n"
        + "Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.\n"
        + "\n"
        + "Since the result can be very large, return it modulo 109 + 7.\n"
        + "\n"
        + "For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: n = 10, x = 2\n"
        + "Output: 1\n"
        + "Explanation: We can express n as the following: n = 32 + 12 = 10.\n"
        + "It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: n = 4, x = 1\n"
        + "Output: 2\n"
        + "Explanation: We can express n in the following ways:\n"
        + "- n = 41 = 4.\n"
        + "- n = 31 + 11 = 4.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
