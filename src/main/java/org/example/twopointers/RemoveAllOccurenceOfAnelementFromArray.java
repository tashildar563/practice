package org.example.twopointers;

import org.example.Solution;

public class RemoveAllOccurenceOfAnelementFromArray implements Solution {
    @Override
    public void logic() {
//        char arr[] = {'0', '1', '3', '0', '2', '2', '4'};
        int arr[] = {0, 1, 3, 0, 2, 2, 4, 2};
        int k = 0;
        int r = 1;
        char ele = '3';
        while (r < arr.length) {
            if (arr[k] == ele) {
                if (arr[r] != ele) {
                    int temp = arr[k];
                    arr[k] = arr[r];
                    arr[r] = temp;
                    k++;
                }
            } else {
                k++;
            }
            r++;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    @Override
    public String description() {
        return "21. Remove All Occurrences of an Element in an Array";
    }

    @Override
    public String problemStatement() {
        return "Given an integer array arr[] and an integer ele the task is to the remove all occurrences of ele from arr[] in-place and return the number of elements which are not equal to ele. If there are k number of elements which are not equal to ele then the input array arr[] should be modified such that the first k elements should contain the elements which are not equal to ele and then the remaining elements.\n" +
                "\n" +
                "Note: The order of first k elements may be changed.\n" +
                "\n" +
                "Examples:\n" +
                "\n" +
                "Input: arr[] = [3, 2, 2, 3], ele = 3\n" +
                "Output: 2\n" +
                "Explanation: The answer is 2 because there are 2 elements which are not equal to 3 and arr[] will be modified such that the first 2 elements contain the elements which are not equal to 3 and remaining elements can contain any element. So, modified arr[] = [2, 2, _, _]\n" +
                "\n" +
                "Input: arr[] = [0, 1, 3, 0, 2, 2, 4, 2], ele = 2";
    }
}
