package org.example.array.YEAR2026;

import java.util.TreeSet;
import org.example.Solution;

public class MinimumPairRemovaltoSortArrayII implements Solution {

  @Override
  public void logic() {
    int[] nums = {7,9,8,5,21,4};
    System.out.println("operations "+ minimumPairRemoval(nums));

  }
  private long flipped;
  private int[] left;
  private int[] right;
  private TreeSet<long[]> pairSum;
  public int minimumPairRemoval(int[] nums) {
    int N = nums.length;
    if(N<2) return 0;

    long[] array = new long[N];
    for(int i=0;i<N;i++){
      array[i] = nums[i];
    }
    flipped = 0;
    left = new int[N];
    right = new int[N];

    pairSum = new TreeSet<>((a,b)->{
      if(a[0]!=b[0]){
        return Long.compare(a[0],b[0]);
      }
      return Long.compare(a[1],b[1]);
    });

    for(int i=0;i<N ;i++){
      left[i]=i-1;
      right[i]=i+1;
    }
    for(int i=0;i<N-1;i++){
      if(array[i]>array[i+1]) flipped++;
      pairSum.add(new long[] {array[i] + array[i+1],i});
    }

    int op =0;
    while(flipped > 0 && !pairSum.isEmpty()){
      long[] first = pairSum.pollFirst();
      int i = (int) first[1];

      int j = right[i];
      int h = left[i];
      int k = right[j];

      remove(h,N,array);
      if(array[i]>array[j]) flipped--;
      remove(j,N,array);
      array[i]+=array[j];
      op++;
      right[i]=k;
      if(k<N){
        left[k] = i;
      }
      add(h,N,array);
      add(i,N,array);
    }
    return op;

  }
  private void add(int i, int N, long[] array){
    if(i>=0 && i<N){
      int j = right[i];
      if(j<N){
        pairSum.add(new long[]{array[i]+array[j],i});
        if(array[i]>array[j]) flipped++;
      }
    }
  }

  private void remove(int i, int N, long[] array){
    if(i>=0 && i<N){
      int j = right[i];
      if(j<N){
        long[] target = new long[]{array[i]+array[j],i};
        if(pairSum.contains(target)){
          if(array[i]>array[j]) flipped --;
          pairSum.remove(target);
        }
      }
    }
  }

  @Override
  public String description() {
    return "109 Minimum Pair Removal to Sort Array II";
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
        + "The array nums is already sorted.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Constraints:\n"
        + "\n"
        + "1 <= nums.length <= 50\n"
        + "-1000 <= nums[i] <= 1000";
  }

  @Override
  public String getToughness() {
    return "Hard";
  }
}
