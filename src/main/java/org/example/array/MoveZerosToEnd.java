package org.example.array;

import org.example.Solution;

public class MoveZerosToEnd implements Solution {
    @Override
    public void logic() {
            int [] arr = {2,5,0,0,6,0,8};
            int count =0;
            for (int i=0;i<arr.length;i++){
                if(arr[i]!=0){
                    int temp = arr[i];
                    arr[i]=arr[count];
                    arr[count] = temp;
                    count++;
                }
                System.out.println();
                for(int ii=0;ii<arr.length;ii++){
                    System.out.print(arr[ii]+",");
                }
            }

            System.out.println();
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+",");
            }
    }

    @Override
    public String description() {
        return "14. Move all Zeros to End of Array";
    }

    @Override
    public String problemStatement() {
        return "Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.\n" +
                "\n" +
                "Examples: \n" +
                "\n" +
                "Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]\n" +
                "Output: [1, 2, 4, 3, 5, 0, 0, 0]\n" +
                "Explanation: There are three 0s that are moved to the end.";
    }
}
