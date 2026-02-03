package org.example.array.YEAR2026;

import org.example.Solution;

public class FindNUniqueIntegersSumuptoZero implements Solution {

  @Override
  public void logic() {
    int n =5;
    int count = n;
    int i=1;
    int arr[] = new int[n];
    if(n%2>0){
      arr[0]=0;
    }
    while(i<n-1){
      arr[i] = count;
      arr[i+1] = -arr[i];
      count--;
      i+=2;
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
