package org.example.array.YEAR2026;

import org.example.Solution;

public class ConstructtheMinimumBitwiseArrayI implements Solution {

  @Override
  public void logic() {
    int[] nums = {2,3,5,7};
    int [] ans = new int[nums.length];
    for(int i=0;i<nums.length;i++){
      int e = nums[i];
      //1111
      //
      int j=0;
      while(j<=e){
        if((j|(j+1))==e){
          ans[i]=j;
          break;
        }else{
          ans[i]=-1;
        }
        j++;
      }
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
