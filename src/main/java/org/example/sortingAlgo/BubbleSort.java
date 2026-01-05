package org.example.sortingAlgo;

import org.example.Solution;
import org.example.Utils;

public class BubbleSort implements Solution {
    @Override
    public void logic() {
        int arr[] = {68,9,101,5,67};
        int temp;
        int n = arr.length;
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        Utils.printArrays(arr);
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
