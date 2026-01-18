package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

public class FindFirstandLastPositionofElementinSortedArray implements Solution {

  @Override
  public void logic() {
    int[] nums = {5,7,7,8,8,10};
    int l=0;
    int target=6;
    int[] index = new int[]{-1,-1};
    int count = 0;
    while(l<nums.length){
      if(nums[l]==target){
        if(count>0){
          index[1]=l;
        }else{
          index[0]=l;
        }
        count++;
      } else if(count>0){
        break;
      }
      l++;
    }
    Arrays.stream(index).forEach(System.out::println);
  }

  @Override
  public String description() {
    return "45. Find First and Last Position of Element in Sorted Array";
  }

  @Override
  public String problemStatement() {
    return "Input: nums = [5,7,7,8,8,10], target = 8\n"
        + "Output: [3,4]";
  }
}
