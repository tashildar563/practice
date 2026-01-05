package org.example;

import com.google.gson.internal.bind.util.ISO8601Utils;

public class MaximumFruitsHarvestedAfteratMostKSteps implements Solution{

  @Override
  public void logic() {
    int [][]fruits = {{2,8},{6,3},{8,6}};
    int startPos = 5, k = 4;
    int n=fruits.length;
    int left=0,total=0,maxFruits=0;
    for(int right=0;right<n;right++){
      total += fruits[right][1];

      while(left<=right){
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];
        int dist = Math.min(Math.abs(startPos-leftPos)+(rightPos-leftPos),Math.abs(startPos-rightPos)+(rightPos-leftPos));
        if(dist<=k) break;
        total -= fruits[left][1];
        left++;
      }
      maxFruits = Math.max(maxFruits,total);
    }
    System.out.println("max harvest0 "+maxFruits);
  }

  @Override
  public String description() {
    return "69. Maximum Fruits Harvested After at Most K Steps";
  }

  @Override
  public String problemStatement() {
    return "Fruits are available at some positions on an infinite x-axis. You are given a 2D integer array fruits where fruits[i] = [positioni, amounti] depicts amounti fruits at the position positioni. fruits is already sorted by positioni in ascending order, and each positioni is unique.\n"
        + "\n"
        + "You are also given an integer startPos and an integer k. Initially, you are at the position startPos. From any position, you can either walk to the left or right. It takes one step to move one unit on the x-axis, and you can walk at most k steps in total. For every position you reach, you harvest all the fruits at that position, and the fruits will disappear from that position.\n"
        + "\n"
        + "Return the maximum total number of fruits you can harvest.\n"
        + "Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4\n"
        + "Output: 9\n"
        + "Explanation: \n"
        + "The optimal way is to:\n"
        + "- Move right to position 6 and harvest 3 fruits\n"
        + "- Move right to position 8 and harvest 6 fruits\n"
        + "You moved 3 steps and harvested 3 + 6 = 9 fruits in total.";
  }
}
