package org.example.twopointers;

import org.example.Solution;

public class MoveAllZerosToEndOfTheArray implements Solution {
    @Override
    public void logic() {
      int arr[]={0, 0, 0,2,0,3,0};
      int l=0;
      int r=1;
      int count=0;
      for(int i=0;i<arr.length;i++){
        if(arr[i]!=0){
          int temp = arr[i];
          arr[i] = arr[count];
          arr[count] = temp;
          count++;
        }
      }

//      while(r<arr.length){
//          if(arr[l]==0){
//              if(arr[l]!=arr[r]){
//                  int temp =arr[l];
//                  arr[l] = arr[r];
//                  arr[r]=temp;
//                  l++;
//              }
//          } else {
//              l++;
//          }
//          r++;
//      }
      for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+" ");
      }
        System.out.println();
    }

    @Override
    public String description() {
        return "22. Move all Zeros to End of Array";
    }

    @Override
    public String problemStatement() {
        return "Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.\n" +
                "\n" +
                "Examples: \n" +
                "\n" +
                "Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]\n" +
                "Output: [1, 2, 4, 3, 5, 0, 0, 0]\n" +
                "Explanation: There are three 0s that are moved to the end.\n" +
                "\n" +
                "Input: arr[] = [10, 20, 30]\n" +
                "Output: [10, 20, 30]\n" +
                "Explanation: No change in array as there are no 0s.";
    }
}
