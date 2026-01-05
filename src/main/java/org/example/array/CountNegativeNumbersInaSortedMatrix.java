package org.example.array;

import org.example.Solution;

public class CountNegativeNumbersInaSortedMatrix implements Solution {

  @Override
  public void logic() {
    int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
    int i = 0;
    int n = grid.length;
    int m = grid[0].length;
    int count=0;
    while (i < n) {
      int j=0;
      while (j < m) {
        int k = grid[i][j];
        if(k>-1){
          j++;
        }else{
          count+=m-j;
          break;
        }
      }
      i++;
    }
    System.out.println("Count "+ count);

  }

  @Override
  public String description() {
    return "67. Count Negative Numbers in a Sorted Matrix";
  }

  @Override
  public String problemStatement() {
    return
        "Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]\n"
            + "Output: 8\n"
            + "Explanation: There are 8 negatives number in the matrix.\n"
            + "Example 2:\n"
            + "\n"
            + "Input: grid = [[3,2],[1,0]]\n"
            + "Output: 0";
  }
}
