package org.example.array;

import org.example.Solution;

import java.util.Arrays;

public class BinarySearch implements Solution {
    @Override
    public void logic() {
        int [] arr = {2,3,5,2,6,8};
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        int target = 5;
        while(l<=r){
          int mid = l+(r-l)/2;
          if(arr[mid]==target){
            System.out.println("target value "+arr[mid]);
          }
          if(arr[mid]<target){
            l = mid+1;
          }else{
            r= mid-1;
          }
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
}
