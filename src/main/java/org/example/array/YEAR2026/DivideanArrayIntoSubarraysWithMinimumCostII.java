package org.example.array.YEAR2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.example.Solution;

public class DivideanArrayIntoSubarraysWithMinimumCostII implements Solution {
  int diff=3;

  @Override
  public void logic() {
    int[] nums = {1, 3, 2, 6, 4, 2};
    int k = 3;
    int n = nums.length;
    int targetK = k-1;
    int[] sorted = nums.clone();
    Arrays.sort(sorted);
    int m=0;
    for(int i=0;i<n;i++){
      if (i == 0 || sorted[i] != sorted[i - 1]) {
        sorted[m++] = sorted[i];
      }
    }
    int dist =2;
    long[] bitsum = new long[m+1];
    int[] bitcount = new int[m+1];
    int maxpow2 = Integer.highestOneBit(m);
    long minExtra = Long.MAX_VALUE;

    for(int i=1;i<n;i++){
      int rank = Arrays.binarySearch(sorted,0,m,nums[i])+1;
      update(rank,nums[i],1,bitsum,bitcount,m);
      if(i>dist+1){
        int oldrank = Arrays.binarySearch(sorted,0,m,nums[i-dist-1])+1;
        update(oldrank,-nums[i-dist-1],-1, bitsum,bitcount,m);
      }
      if(i>=targetK){
        minExtra = Math.min(minExtra,query(targetK, bitsum,bitcount,sorted,m,maxpow2));
      }
    }
    System.out.println(" array sum "+ nums[0]+minExtra);
  }
  private void update(int idx,int val, int cnt, long[] bsum,int[] bcnt, int m){
    for(;idx<=m;idx+=idx & -idx){
      bsum[idx]+=val;
      bcnt[idx]+=cnt;
    }
  }

  private long query(int k,long[] bsum,int [] bcnt, int[]sorted, int m, int maxpow2){
    int idx = 0, curcnt =0;
    long cursum =0;
    for(int i=maxpow2;i>0;i>>=1){
      if(idx+1<=m && curcnt + bcnt[idx+1] < k){
        idx+=i;
        curcnt += bcnt[idx];
        cursum += bsum[idx];
      }
    }
    if(curcnt<k) cursum += (long) (k-curcnt)*sorted[idx];
    return cursum;
  }

  private void generateSubArray(int[] nums, int index, List<List<Integer>> current,List<List<List<Integer>>> result) {
    if(index == nums.length){
      result.add(new ArrayList<>(current));
      return;
    }

    List<Integer> sub = new ArrayList<>();
    for(int i=index;i<nums.length;i++){
      sub.add(nums[i]);
      current.add(new ArrayList<>(sub));
      generateSubArray(nums,i+1,current,result);
      current.remove(current.size()-1);
    }
  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  @Override
  public String getToughness() {
    return "Hard";
  }
}
