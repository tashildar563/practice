package org.example.array.YEAR2025;

import org.example.Solution;

public class HowManyNumbersAreSmallerThantheCurrentNumber implements Solution {

  @Override
  public void logic() {
    int nums[] = {8,1,2,2,3};
    int[] fr = new int[101];
    for(int i:nums){
      fr[i]++;
    }
    for(int i=1;i<101;i++){
      fr[i]+=fr[i-1];
    }
    int[] ar = new int[nums.length];
    for(int i=0;i<nums.length;i++){
      ar[i] = nums[i]==0?0:fr[nums[i]-1];
    }

    for(int i=0;i<ar.length;i++){
      System.out.print(" "+ar[i]);
    }
  }

  @Override
  public String description() {
    return "76 How Many Numbers Are Smaller Than the Current Number";
  }

  @Override
  public String problemStatement() {
    return "Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].\n"
        + "\n"
        + "Return the answer in an array.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: nums = [8,1,2,2,3]\n"
        + "Output: [4,0,1,1,3]\n"
        + "Explanation: \n"
        + "For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). \n"
        + "For nums[1]=1 does not exist any smaller number than it.\n"
        + "For nums[2]=2 there exist one smaller number than it (1). \n"
        + "For nums[3]=2 there exist one smaller number than it (1). \n"
        + "For nums[4]=3 there exist three smaller numbers than it (1, 2 a";
  }

  @Override
  public String getToughness() {
    return "Easy";
  }
}
