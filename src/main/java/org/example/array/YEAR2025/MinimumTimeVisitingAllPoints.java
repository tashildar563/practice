package org.example.array.YEAR2025;

import org.example.Solution;

public class MinimumTimeVisitingAllPoints implements Solution {
  /**
   * <p>Intuition
   * We are given a sequence of points on a 2D grid and must visit them in order.
   * At every second, we are allowed to move in three possible ways:
   *
   * One unit horizontally
   * One unit vertically
   * One unit diagonally (one horizontal + one vertical together)
   * The diagonal move is crucial because it allows us to reduce both x and y distances at the same time.
   * So the key question becomes:
   *
   * Given two points, how many seconds are minimally required to move from one to the next using these rules?
   *
   * Instead of thinking in terms of directions or quadrants, we focus only on how far apart the points are along the x-axis and y-axis.
   *
   * </p>
   * <p>
   *   Approach
   * Consider two consecutive points:
   *
   * (x1, y1) → (x2, y2)
   *
   * Compute:
   *
   * dx = |x2 - x1|
   * dy = |y2 - y1|
   * Step 1: Use diagonal moves optimally
   * A diagonal move reduces both dx and dy by 1 in one second.
   * So we should use diagonal moves as much as possible.
   *
   * The maximum number of diagonal moves we can make is:
   *
   * min(dx, dy)
   *
   * After these diagonal moves:
   *
   * One direction becomes zero
   * The other direction has remaining distance |dx - dy|
   * Step 2: Finish remaining distance
   * Once either x or y distance becomes zero, we can only move:
   *
   * Horizontally or
   * Vertically
   * Each such move reduces the remaining distance by 1 and costs 1 second.
   *
   * Step 3: Total time for one segment
   * Putting it together:
   *
   * time = diagonal_moves + remaining_moves
   * = min(dx, dy) + |dx - dy|
   * = max(dx, dy)
   *
   * So the minimum time to move between two points is simply:
   *
   * max(|x2 - x1|, |y2 - y1|)
   *
   * Step 4: Visit all points in order
   * Since we must visit the points sequentially:
   *
   * Compute the required time for each consecutive pair
   * Add all of them together
   * This guarantees the minimum total time.
   *
   * Complexity
   * Time complexity:
   * O(n)
   * We process each pair of consecutive points exactly once.
   *
   * Space complexity:
   * O(1)
   * Only a few variables are used regardless of input size.
   * </p>
   */


  @Override
  public void logic() {
    int[][] p ={{1,1},{3,4},{-1,0}};
    int m =p.length;
    int ans=0;
    for(int i=1;i<m;i++){
      ans+=Math.max(Math.abs(p[i][0]-p[i-1][0]),Math.abs(p[i][1]-p[i-1][1]));
    }
    System.out.println(" Answer "+ ans);
  }

  @Override
  public String description() {
    return "93 1266. Minimum Time Visiting All Points";
  }

  @Override
  public String problemStatement() {
    return "On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.\n"
        + "\n"
        + "You can move according to these rules:\n"
        + "\n"
        + "In 1 second, you can either:\n"
        + "move vertically by one unit,\n"
        + "move horizontally by one unit, or\n"
        + "move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).\n"
        + "You have to visit the points in the same order as they appear in the array.\n"
        + "You are allowed to pass through points that appear later in the order, but these do not count as visits."
        + "Input: points = [[1,1],[3,4],[-1,0]]\n"
        + "Output: 7\n"
        + "Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   \n"
        + "Time from [1,1] to [3,4] = 3 seconds \n"
        + "Time from [3,4] to [-1,0] = 4 seconds\n"
        + "Total time = 7 seconds\n"
        + "Example 2:\n"
        + "\n"
        + "Input: points = [[3,2],[-2,2]]\n"
        + "Output: 5";
  }

  @Override
  public String getToughness() {
    return Solution.super.getToughness();
  }
}
