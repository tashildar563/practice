package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.List;
import org.example.Solution;

public class NumberofZeroFilledSubarrays implements Solution {

  @Override
  public void logic() {
    int nums[] = {10,10,10,2,10,10};
    List<List<Integer>> list = new ArrayList<>();
    int res=0;

    for(int j=0;j<nums.length;j++){
      if(nums[j]==0){
        int count=0;
        while( j<nums.length && nums[j]==0){
          count++;
          j++;
        }
        res+=getRes(count);
      }
    }
    System.out.println("Max 0 sub Array "+ res);
  }

  private int getRes(int i) {
    return (i*(i+1))/2;
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
    return "Medium";
  }
}
