package org.example.array.YEAR2026;

import org.example.Solution;

public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold implements Solution {

  @Override
  public void logic() {
    int[][] mat = {
        {1, 1, 3, 2, 4, 3, 2},
        {1, 1, 3, 2, 4, 3, 2},
        {1, 1, 3, 2, 4, 3, 2}};
    int t = 4;
    //binary search solution
    int row = mat.length;
    int col = mat[0].length;

    // first calculate the prefix sum matrix
    int[][] prefixSum = new int[row + 1][col + 1];

    //add padding so that edge cases are dealth with more smoothly.
    // we keep the prefixSum of mat[0][0] at prefix[1][1] and so on
    for (int r = 1; r <= row; r++) {
      for (int c = 1; c <= col; c++) {
        prefixSum[r][c] =
            prefixSum[r - 1][c] + prefixSum[r][c - 1] - prefixSum[r - 1][c - 1] + mat[r - 1][c - 1];
      }
    }
    int lower = 0;
    int upper = Math.min(row, col) - 1;

    while (lower <= upper) {
      int size = lower + (upper - lower) / 2;
      int minSumSubMat = Integer.MAX_VALUE;
      for (int r = 1; r + size <= row; r++) {
        for (int c = 1; c + size <= col; c++) {
          int sumSubMat = prefixSum[r + size][c + size] -
              prefixSum[r - 1][c + size] -
              prefixSum[r + size][c - 1] +
              prefixSum[r - 1][c - 1];
          minSumSubMat = Math.min(minSumSubMat, sumSubMat);
        }
      }
      if (minSumSubMat < t) {
        lower = size + 1;
      } else {
        upper = size - 1;
      }
    }
    System.out.println("Output :" + lower);
  }

  @Override
  public String description() {
    return "105. Maximum Side Length of a Square with Sum Less than or Equal to Threshold";
  }

  @Override
  public String problemStatement() {
    return
        "Given a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "\n"
            + "Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4\n"
            + "Output: 2\n"
            + "Explanation: The maximum side length of square with sum less than 4 is 2 as shown.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
