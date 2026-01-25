package org.example.array.YEAR2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.example.Solution;

public class MinimumDifferenceBetweenHighestandLowestofKScores implements Solution {
  Integer maxDiff = Integer.MAX_VALUE;

  @Override
  public void logic() {
    int [] nums = {9,4,1,7};
    int k = 2;
    final int n= nums.length;
    if(k==1){ System.out.println("minimum difference "+ maxDiff); return;}
    Arrays.sort(nums);
    int diff= Integer.MAX_VALUE;
    for(int l=0,r=k-1;r<n;){
      diff = Math.min(diff, nums[r++]-nums[l++]);
    }
    System.out.println("minimum difference "+ diff);
  }

  @Override
  public String description() {
    return "110. Minimum Difference Between Highest and Lowest of K Scores";
  }

  @Override
  public String problemStatement() {
    return "You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.\n"
        + "\n"
        + "Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.\n"
        + "\n"
        + "Return the minimum possible difference.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: nums = [90], k = 1\n"
        + "Output: 0\n"
        + "Explanation: There is one way to pick score(s) of one student:\n"
        + "- [90]. The difference between the highest and lowest score is 90 - 90 = 0.\n"
        + "The minimum possible difference is 0.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: nums = [9,4,1,7], k = 2\n"
        + "Output: 2\n"
        + "Explanation: There are six ways to pick score(s) of two students:\n"
        + "- [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.\n"
        + "- [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.\n"
        + "- [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.\n"
        + "- [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.\n"
        + "- [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.\n"
        + "- [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.\n"
        + "The minimum possible difference is 2.";
  }

  @Override
  public String getToughness() {
    return "Easy";
  }
}
