package org.example.array;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.example.Solution;

public class AppleRedistributionintoBoxes implements Solution {

  @Override
  public void logic() {
    int apple []= {1,3,2};
    int capacity []={4,3,1,5,2};
    int sum = Arrays.stream(apple).sum();
    Arrays.sort(capacity);
    int n = capacity.length;
    int i=n-1;
    int count = 0;
    while (i >=0) {
      sum-=capacity[i];
      count++;
      if(sum<=0){
        break;
      }
      i--;
    }
    System.out.print("Redistributed in "+count+" boxes.");
  }

  @Override
  public String description() {
    return "63 Apple Redistribution into Boxes";
  }

  @Override
  public String problemStatement() {
    return "\n You are given an array apple of size n and an array capacity of size m.\n"
        + "\n"
        + "There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.\n"
        + "\n"
        + "Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.\n"
        + "\n"
        + "Note that, apples from the same pack can be distributed into different boxes.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: apple = [1,3,2], capacity = [4,3,1,5,2]\n"
        + "Output: 2\n"
        + "Explanation: We will use boxes with capacities 4 and 5.\n"
        + "It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: apple = [5,5,5], capacity = [2,4,2,7]\n"
        + "Output: 4\n"
        + "Explanation: We will need to use all the boxes.";
  }
}
