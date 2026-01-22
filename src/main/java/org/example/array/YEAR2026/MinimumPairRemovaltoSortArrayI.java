package org.example.array.YEAR2026;

import java.util.ArrayList;
import java.util.List;
import org.example.Solution;

public class MinimumPairRemovaltoSortArrayI implements Solution {

  @Override
  public void logic() {
    int [] nums = {5,2,3,1};
    List<Integer> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
        if(min>nums[i-1]+nums[i]){
          min = nums[i-1]+nums[i];
        }
    }

  }

  @Override
  public String description() {
    return "104. Minimum Pair Removal to Sort Array I";
  }

  @Override
  public String problemStatement() {
    return "Given an array nums, you can perform the following operation any number of times:\n"
        + "\n"
        + "Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.\n"
        + "Replace the pair with their sum.\n"
        + "Return the minimum number of operations needed to make the array non-decreasing.\n"
        + "\n"
        + "An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: nums = [5,2,3,1]\n"
        + "\n"
        + "Output: 2\n"
        + "\n"
        + "Explanation:\n"
        + "\n"
        + "The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].\n"
        + "The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].\n"
        + "The array nums became non-decreasing in two operations.\n"
        + "\n"
        + "Example 2:\n"
        + "\n"
        + "Input: nums = [1,2,2]\n"
        + "\n"
        + "Output: 0\n"
        + "\n"
        + "Explanation:\n"
        + "\n"
        + "The array nums is already sorted.";
  }

  @Override
  public String getToughness() {
    return "Easy";
  }
}
