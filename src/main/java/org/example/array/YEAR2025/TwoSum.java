package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.Solution;

public class TwoSum implements Solution {

  @Override
  public void logic() {
    int[] nums = {3, 2, 4, 3,6,0};
    Map<Integer, Integer> m = new HashMap<>();
    int target = 6;
    int l = 0;
    List<Integer[]> result = new ArrayList<>();
    while(l<nums.length){
      int complement = target - nums[l];
      if(m.containsKey(complement)){
        result.add(new Integer[]{m.get(complement),l});
      }
      m.put(nums[l],l);
      l++;
    }
//    for(int i=0;i<nums.length;i++){
//      for(int j=i+1;j<nums.length;j++){
//        if(nums[i]+nums[j]==target){
//          System.out.println("indexes >> first index :" + i + " second index :" + j);
//          break;
//        }
//      }
//    }

    for(var res : result){
      System.out.println("indexes >> first index :" + res[0] + " second index :" + res[1]);
    }
  }

  @Override
  public String description() {
    return "23. Two Sum";
  }

  @Override
  public String problemStatement() {
    return
        "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n"
            + "\n"
            + "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n"
            + "\n"
            + "You can return the answer in any order.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "Input: nums = [2,7,11,15], target = 9\n"
            + "Output: [0,1]\n"
            + "Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].\n"
            + "Example 2:\n"
            + "\n"
            + "Input: nums = [3,2,4], target = 6\n"
            + "Output: [1,2]\n"
            + "Example 3:\n"
            + "\n"
            + "Input: nums = [3,3], target = 6\n"
            + "Output: [0,1]";
  }
}
