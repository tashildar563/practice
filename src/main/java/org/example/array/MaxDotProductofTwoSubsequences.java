package org.example.array;

import org.example.Solution;

public class MaxDotProductofTwoSubsequences implements Solution {

  @Override
  public void logic() {
    int [] n1={2,1,-2,5};
    int [] n2={3,0,-6};
    Integer [][] dp = new Integer[n1.length+1][n2.length+1];
    System.out.println(" output "+helper(n1,n2,0,0,dp));
  }

  private int helper(int[] n1, int[] n2, int i, int j, Integer[][] dp) {
    if(i == n1.length || j==n2.length){
      return Integer.MIN_VALUE;
    }

    if(dp[i][j] != null){
      return dp[i][j];
    }

    //option 1 take both n1 and n2 then continue
    int takeBoth = n1[i]* n2[j] + (i+1 < n1.length && j+1 < n2.length ? helper(n1,n2,i+1,j+1,dp):0);

    //option 2 skip n1[i], continue with n1[i+1]
    int num1=helper(n1,n2,i+1,j,dp);
    //option 2 skip n2[j], continue with n2[j+1]
    int num2=helper(n1,n2,i,j+1,dp);

    //take the maximum of :
    // just current pair (n1[i]*n2[j])
    //taking both and extending (takeboth)
    // skipping n1[i]
    // skipping n2[j]
    return dp[i][j] = Math.max(n1[i]*n2[j],Math.max(takeBoth,Math.max(num1,num2)));

  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  @Override
  public String getToughness() {
    return "Hard";
  }
}
