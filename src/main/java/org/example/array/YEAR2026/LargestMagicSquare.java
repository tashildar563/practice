package org.example.array.YEAR2026;

import org.example.Solution;

public class LargestMagicSquare implements Solution {

  @Override
  public void logic() {
    int[][] grid = {
        {5, 1, 3, 1},
        {9, 3, 3, 1},
        {1, 3, 3, 8}
    };
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] rowsum = new int[rows+1][cols+1];
    int[][] colsum = new int[rows+1][cols+1];
    int[][] daig = new int[rows+1][cols+1];
    int[][] antidiag = new int[rows+1][cols+1];

    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        int x = grid[i][j];
         rowsum[i+1][j+1]=rowsum[i+1][j]+x;
         colsum[i+1][j+1]=colsum[i][j+1]+x;
         daig[i+1][j+1]=daig[i][j]+x;
        antidiag[i+1][j]=rowsum[i][j+1]+x;
      }
    }
    for( int k=Math.max(rows,cols);k>=2;k++){
      if(isMagic(k,rows,cols,rowsum,colsum,daig,antidiag)){
        System.out.println("output :"+k);
      }
    }
    System.out.println("output :"+1);

  }

  private boolean isMagic(int k, int rows, int cols, int[][] rowsum, int[][] colsum, int[][] daig, int[][] antidiag) {
    for(int i=0;i<=rows-k;i++){
      for(int j=0;j<=cols;j++){
        int s = daig[i+k][j+k]-daig[i][j];
        int anti = antidiag[i+k][j]-antidiag[i][j+k];
        if(s!=anti){
          continue;
        }
        boolean valid = true;
        for(int m =0;m<k;m++){
          int row = rowsum[i+m+1][j+k] - rowsum[i+m+1][j];
          int col = colsum[i+k][j+m+1]-colsum[i][j+m+1];
          if(row!=s || col !=s){
            valid = false;
            break;
          }
        }
        if(valid) return true;
      }
    }
    return false;
  }

  @Override
  public String description() {
    return "104 Largest Magic Square";
  }

  @Override
  public String problemStatement() {
    return
        "A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal. The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.\n"
            + "\n"
            + "Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
