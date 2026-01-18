package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.Solution;

public class ThreeSum implements Solution {

  @Override
  public void logic() {
    /*
    * 1) sort the array
    *   sort nums in ascending order
    *   sorting gives order so pointer moves are predictable
    *   benefits makes it easy to increase/ decrease pair sums add to detect/skip duplicates.
    *
    *
    * 2)fix one element nums[i] as the first of the triplet
    *   for each i (0..n-3) treat a = nums[i] as the first elemtn.
    *   the problem reduces to: find b and c such that b+c = -a (a two-sum).
    *   only consider i upto n-3 becase you need tow elements after i;
    *
    * 3) use two pointers on the subarray right of i
    *   initialise: left = i+1, right = n-1.
    *   let target = -nums[i]. we want nums[left]+nums[right] == target.
    *   because the array is sorter
    *     if nums[left]+nums[right] < target, then left++ (increases pair sum).
    *     if nums[left]+nums[right] > target, then right-- (decreases)
    *   continue while left<right every valid pair for this i will be found in linear time.
    * 4) skip duplicates
    *   before tow pointer scan
    *     if i>0 and nums[i] == nums[i-1], continue (skip same a)
    *   after finding a valid triplet
    *     move both pointers: left +=1; right-=1
    *     then skip repeated values;
    *   while left<right and nums[left] == nums[left-1]: left +=1;
    *   while left<right and nums[right] == nums[left+1]: left -=1;
    * */
    int nums[]={-1,0,1,2,-1,-4};
    //store all unque triplets
    List<List<Integer>> res = new ArrayList<>();

    //no triplets possible
    if(nums.length<3) {
      System.out.println(res);
      return;
    }

    //sorting the array in ascending order
    Arrays.sort(nums);

    //
    for(int i=0;i<nums.length-2;i++){
      //skip duplicates for the first element
      if(i>0 && nums[i]==nums[i-1]) continue;

      if(nums[i]>0)break;

      int left = i+1, right = nums.length -1;

      //setting the target
      int target = -nums[i];

      //two pointer scan
      while(left < right){
        int sum = nums[left]+nums[right];
        if(sum == target){
          res.add(Arrays.asList(nums[i],nums[left],nums[right]));
          left++;
          right--;

          //skip duplicate==
          while(left<right && nums[left] == nums[left-1]) left++;
          while(left<right && nums[right] == nums[right+1]) right--;
        }else if(sum<target){
          left++;
        }else{
          right--;
        }
      }
    }
    System.out.println(res);
  }

  @Override
  public String description() {
    return "26. Three sum";
  }

  @Override
  public String problemStatement() {
    return "Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.\n"
        + "\n"
        + "Notice that the solution set must not contain duplicate triplets.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: nums = [-1,0,1,2,-1,-4]\n"
        + "Output: [[-1,-1,2],[-1,0,1]]\n"
        + "Explanation: \n"
        + "nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.\n"
        + "nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.\n"
        + "nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.\n"
        + "The distinct triplets are [-1,0,1] and [-1,-1,2].\n"
        + "Notice that the order of the output and the order of the triplets does not matter.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: nums = [0,1,1]\n"
        + "Output: []\n"
        + "Explanation: The only possible triplet does not sum up to 0.\n"
        + "Example 3:\n"
        + "\n"
        + "Input: nums = [0,0,0]\n"
        + "Output: [[0,0,0]]\n"
        + "Explanation: The only possible triplet sums up to 0.";
  }
}
