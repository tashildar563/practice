package org.example.array.YEAR2025;

import java.util.ArrayDeque;
import java.util.Queue;
import org.example.Solution;

public class NumberOfIsLands implements Solution {

  @Override
  public void logic() {
    String[][] grid = {
  {"1","1","0","0","0"},
  {"1","1","0","0","0"},
  {"0","0","1","0","0"},
  {"0","0","0","1","1"}
};
    int m = grid.length;
    int n = grid[0].length;
    int count =0;

    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(grid[i][j]=="1"){
          count++;
          Queue<int[]> queue = new ArrayDeque<>();
          queue.offer(new int[]{i,j});
          grid[i][j]="0";
          while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] d:dir){
              int nr = r+d[0];
              int nc = c+d[1];
              if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=="1"){
                grid[nr][nc]="0";
                queue.offer(new int[]{nr,nc});
              }
            }
          }
        }
      }
    }
    System.out.println("Islands >> "+ count);

  }

  @Override
  public String description() {
    return "44. Number of Islands";
  }

  @Override
  public String problemStatement() {
    return
        "Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.\n"
            + "\n"
            + "An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "Input: grid = [\n"
            + "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n"
            + "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n"
            + "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n"
            + "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n"
            + "]\n"
            + "Output: 1\n"
            + "Example 2:\n"
            + "\n"
            + "Input: grid = [\n"
            + "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n"
            + "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n"
            + "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n"
            + "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n"
            + "]\n"
            + "Output: 3";
  }
}
