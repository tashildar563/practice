package org.example.array;

import java.util.LinkedList;
import java.util.Queue;
import org.example.Solution;

public class LastDayWhereYouCanStillCross implements Solution {
  /*
  * Intuition
Let's break down the problem step by step:

What we need: Find the LAST day we can walk from top row to bottom row
Key observation 1: If we can cross on day X, we can definitely cross on all days < X (monotonic property)
Key observation 2: If we cannot cross on day X, we cannot cross on any day > X
This screams: Binary Search on the answer!
Why not simulate day by day? Would be too slow!
Better approach: Binary search the day + verify with BFS
The trick: Don't ask "what happens each day?" Ask "can we cross on day X?"
Visual intuition:

Days: 1  2  3  4  5  6  7  8
Cross: ✅ ✅ ✅ ✅ ❌ ❌ ❌ ❌
            ↑
      Find this boundary!
Approach
Breaking down the solution into clear steps:

Step 1: Binary Search Setup

Search space: days from 1 to total_cells
Goal: Find the maximum day where crossing is still possible
Use standard binary search template with "maximize valid answer" pattern
Step 2: For Each Candidate Day (mid)

Build the grid state after mid days
Mark cells[0] to cells[mid-1] as water (1)
Rest are land (0)
Step 3: BFS Path Finding

Start: All land cells (value 0) in the TOP row
Goal: Reach ANY cell in the BOTTOM row
Explore: 4 directions (up, down, left, right)
Track: Visited array to avoid revisiting cells
Step 4: Binary Search Logic

If canCross(mid) returns TRUE → try later days → left = mid + 1, save answer = mid
If canCross(mid) returns FALSE → try earlier days → right = mid - 1
Continue until left > right
Step 5: Return Answer

The last valid day we found is our answer
Complexity
Time complexity: O(row×col×log(row×col))

Space complexity: O(row×col)*/

  private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
  private int rows,cols;
  @Override
  public void logic() {
    int row = 2, col = 2;
    int [][] cells = {{1,1},{2,1},{1,2},{2,2}};
    this.rows = row;
    this.cols = col;
    int left =1,right = cells.length, answer =0;

    while(left <= right){
      int mid = left +(right-left)/2;
      if(canCross(mid,cells)){
        answer = mid;
        left = mid +1;
      }else {
        right = mid-1;
      }
    }
    System.out.println("Answers " + answer);
  }

  private boolean canCross(int day, int[][] cells) {
    int [][] grid = new int[rows][cols];
    for(int i=0;i<day;i++){
      grid[cells[i][0]-1][cells[i][1]-1] = 1;
    }
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][cols];

    for(int c =0;c<cols;c++){
      if(grid[0][c]==0){
        queue.offer(new int[]{0,c});
        visited[0][c]=true;
      }
    }
    while(!queue.isEmpty()){
      int[] curr = queue.poll();
      int r= curr[0], c= curr[1];

      if(r==rows - 1) return true;

      for(int[] dir : directions){
        int nr = r+dir[0];
        int nc = c + dir[1];
        if(nr >=0 && nr<rows && nc>=0 && nc < cols && !visited[nr][nc] && grid[nr][nc]==0){
          visited[nr][nc] =true;
          queue.offer(new int[]{nr,nc});

        }
      }
    }
    return false;
  }

  @Override
  public String description() {
    return "71.Last Day Where You Can Still Cross";
  }

  @Override
  public String problemStatement() {
    return "There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.\n"
        + "\n"
        + "Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).\n"
        + "\n"
        + "You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).\n"
        + "\n"
        + "Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]\n"
        + "Output: 2\n"
        + "Explanation: The above image depicts how the matrix changes each day starting from day 0.\n"
        + "The last day where it is possible to cross from top to bottom is on day 2.";
  }
  @Override
  public String getToughness(){
    return "Hard";
  }

}
