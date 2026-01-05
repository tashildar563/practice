package org.example.sortingAlgo;

import org.example.Solution;
import org.example.Utils;

public class MergeSort implements Solution {
    @Override
    public void logic() {
        int arr[] = {3,6,2,6};
        int n = arr.length;
        mergeSort(arr,0,n-1);
        Utils.printArrays(arr);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if(l<r){
            int  mid = l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int n1=mid-l+1;
        int n2 = r-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;++i){
            L[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = arr[mid+1+i];
        }
        int i =0;
        int j=0;
        int k=l;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
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
