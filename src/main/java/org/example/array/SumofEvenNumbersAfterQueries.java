package org.example.array;

import org.example.Solution;

public class SumofEvenNumbersAfterQueries implements Solution {

  @Override
  public void logic() {
    int [] nums = {1,2,3,4};
    int queries [][]= {{1,0},{-3,1},{-4,0},{2,3}};
    int n = queries.length;
    int evenSum = 0;
    for(int num:nums){
      if(num%2==0){
        evenSum+=num;
      }
    }
    int result[] = new int[queries.length];
    int i=0;
    for(int [] query:queries){
      int val = query[0];
      int index = query[1];

      if(nums[index]%2==0){
        evenSum -=nums[index];
      }
      nums[index] +=val;

      if(nums[index]%2 == 0){
        evenSum += nums[index];
      }
      result[i++] = evenSum;
    }

    for(int k=0;k<result.length;k++){
      System.out.print(" "+result[k]);
    }
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
    return "Easy";
  }
}
