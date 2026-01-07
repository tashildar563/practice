package org.example.array;

import org.example.Solution;

public class UniqueNumber implements Solution {

  @Override
  public void logic() {
    int [] arr = {1,2,3,2,1,4,5,4,5};
    int ans =0;
    for(int i=0;i<arr.length;i++){
      ans^=arr[i];
    }
    System.out.println("Answers "+ans);
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
    return Solution.super.getToughness();
  }
}
