package org.example.array.YEAR2025;

import org.example.Solution;

public class MagicSquaresInGrid implements Solution {

  @Override
  public void logic() {
    int [][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
    /*
    * find 3*3 grid whose rows, column and both diagnals cell has same sum*/
    int m = grid.length, n = grid[0].length, c=0;
    for(int i=0;i<=m-3;i++){
      for(int j=0;j<=n-3;j++){
        if(isMagixSquare(grid,i,j)) c++;
      }
    }
  }

  private boolean isMagixSquare(int[][] grid, int i, int j) {
    if( grid[i+1][j+1]!=5) return false;
    int a= grid[i][j], b=grid[i][j+1],d=grid[i][j+2];
    int e = grid[i+1][j], f = grid[i+1][j+2];
    int h = grid[i+2][j], k=grid[i+2][j+1], l=grid[i+2][j+2];

    boolean[] seen = new boolean[10];
    int[] arr = {a,b,d,e,f,h,k,l,5};
    for(int x:arr){
      if(x<1||x>9 || seen[x]) return false;
      seen[x]=true;
    }
    if(a+l!=10) return false;
    if(b+k!=10) return false;
    if(d+h!=10) return false;
    if(e+f!=10) return false;


    if(a+b+d!=15) return false;
    if(h+k+l!=15) return false;
    if(a+e+h!=15) return false;
    if(d+f+l!=15) return false;
    if(a+5+l!=15) return false;
    if(d+5+h!=15) return false;

    return true;
  }


  @Override
  public String description() {
    return "70 Magic Squares In Grid";
  }

  @Override
  public String problemStatement() {
    return "A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.\n"
        + "\n"
        + "Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?\n"
        + "\n"
        + "Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]\n"
        + "Output: 1\n"
        + "Explanation: \n"
        + "The following subgrid is a 3 x 3 magic square:\n"
        + "\n"
        + "while this one is not:\n"
        + "\n"
        + "In total, there is only one magic square inside the given grid.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: grid = [[8]]\n"
        + "Output: 0";
  }
}
