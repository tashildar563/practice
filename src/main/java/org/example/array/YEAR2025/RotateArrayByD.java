package org.example.array.YEAR2025;

import org.example.Solution;

public class RotateArrayByD implements Solution {
    @Override
    public void logic() {
        int [] arr = {1,2,3,4,5,6,7};
        int d = 3;
        d %=arr.length;
        int[] newArr = new int[arr.length];
        int k =0;
        int start = arr.length-d;
        while(start<arr.length && k<arr.length){
          newArr[k] = arr[start];
          k++;
          start++;
          if(start==arr.length){
            start=0;
          }
        }
        for(int i=0;i<newArr.length;i++){
          System.out.print(newArr[i]+",");
        }
      System.out.println();
        //Left rotation : 0-(d-1) -> d-(n-1) -> 0-(n-1)
        reverseArr(arr,0,d-1);
        reverseArr(arr,d,arr.length-1);
        reverseArr(arr,0,arr.length-1);


        //right rotation 0-(n-1) -> 0-(d-1) -> d-(n-1)
      reverseArr(arr,0,arr.length-1);
      reverseArr(arr,0,d-1);
      reverseArr(arr,d,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }

    }
    public void reverseArr(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    @Override
    public String description() {
        return "15. Rotate an Array by d - Counterclockwise or Left";
    }

    @Override
    public String problemStatement() {
        return "Given an array of integers arr[] of size n, the task is to rotate the array elements to the left by d positions.";
    }
}
