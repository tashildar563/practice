package org.example.array;

import org.example.Solution;

public class SearchinRotatedSortedArray implements Solution {

  @Override
  public void logic() {
    int nums[] = {4,5,6,7,0,1,2};
    int target = 0;
    int index = searchEle(nums,target);
    System.out.println("index of target from an array : "+ index);
  }

  private int searchEle(int[] nums, int target) {
    int n = nums.length;
    int l=0;
    int r=n-1;
    while(l<=r){
      int mid = (l+r)/2;
      if(nums[mid]==target){
        return mid;
      }else if(nums[mid] >= nums[l]){
        if(nums[l]<=target && target<=nums[mid]){
          r = mid-1;
        }else{
          l=mid+1;
        }
      }else{
        if(nums[mid] <= target && target<=nums[r]){
          l=mid+1;
        }else{
          r=mid-1;
        }
      }
    }
    return -1;
  }

  @Override
  public String description() {
    return "36. Search in Rotated Sorted Array";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
