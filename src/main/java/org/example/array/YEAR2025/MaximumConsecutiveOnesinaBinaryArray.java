package org.example.array.YEAR2025;

import org.example.Solution;

public class MaximumConsecutiveOnesinaBinaryArray implements Solution {
    @Override
    public void logic() {
        int arr[] = {0, 0, 0, 0};
        int maxCount = 0;
        int count = 0;
        for(int i =1;i<arr.length ; i++){
            if(arr[i]==arr[i-1]){
                count++;
            }else{
                maxCount = Math.max(maxCount,count);
                count =1;
            }
        }
        System.out.println("Max Count "+Math.max(maxCount,count));
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
