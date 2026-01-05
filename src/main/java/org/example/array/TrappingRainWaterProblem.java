package org.example.array;

import org.example.Solution;

public class TrappingRainWaterProblem implements Solution {
    @Override
    public void logic() {
        int arr[] = {4,2,1,9,4,1,13};
        int l=1;
        int r=arr.length-2;
        int lMax=arr[l-1];
        int rMax=arr[r+1];
        int result=0;
        while(l<=r){
            if(rMax<=lMax){
                result+=Math.max(0,rMax-arr[r]);
                rMax = Math.max(rMax,arr[r]);
                r--;
            }else{
                result+=Math.max(0,lMax-arr[l]);
                lMax = Math.max(lMax,arr[l]);
                l++;
            }
        }
        System.out.println("Result "+result);
    }

    @Override
    public String description() {
        return "16. Trapping Rain Water Problem";
    }

    @Override
    public String problemStatement() {
        return "Given an array arr[] of size n consisting of non-negative integers, where each element represents the height of a bar in an elevation map and the width of each bar is 1, determine the total amount of water that can be trapped between the bars after it rains.";
    }
}
