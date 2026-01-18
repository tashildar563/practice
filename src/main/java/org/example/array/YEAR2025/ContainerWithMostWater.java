package org.example.array.YEAR2025;

import org.example.Solution;

public class ContainerWithMostWater implements Solution {

  @Override
  public void logic() {
    int height[] = {1,8,6,2,5,4,8,3,7};
    int n=height.length;
    int i =0;
    int j = n-1;
    int res=0;
    while(i<j){
      int m = j-i;
      int minH = Math.min(height[i],height[j]);
      res = Math.max(res,m*minH);
      if(height[i]<height[j])i++;
      else j--;
    }
    System.out.println("Container with water: "+res);
  }

  @Override
  public String description() {
    return "25. Container With Most Water";
  }

  @Override
  public String problemStatement() {
    return "You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).\n"
        + "\n"
        + "Find two lines that together with the x-axis form a container, such that the container contains the most water.\n"
        + "\n"
        + "Return the maximum amount of water a container can store.\n"
        + "\n"
        + "Notice that you may not slant the container.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: height = [1,8,6,2,5,4,8,3,7]\n"
        + "Output: 49\n"
        + "Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: height = [1,1]\n"
        + "Output: 1";
  }
}
