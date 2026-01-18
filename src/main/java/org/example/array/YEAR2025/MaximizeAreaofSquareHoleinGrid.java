package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

/**
 * <p>Intuition
 * You are trapped in a cage made of metal iron bars and wooden bars.
 *
 * You cannot remove the iron bars, but you can remove the wooden bars.
 *
 * The goal is to remove some wooden bars in order to maximize the size of a square hole so that you can escape.
 * </p>
 * <p>
 *   Condition
 *
 * Only wooden bars can be removed.
 * Iron bars are fixed and always remain.
 * Removing consecutive wooden bars creates a larger open space between two iron bars.
 *
 * Removing isolated wooden bars does not help much.
 *
 * Thus, the largest opening comes from removing bars that are next to each other.
 * </p>
 * <p>
 *   Therefore, The goal is to:
 *
 * Find the largest stretch of removable bars in each direction.
 * and use the smaller one to form the maximum possible square hole.
 *
 * Time Complexity: O(nlogn+mlogm)
 * Space Complexity: O(1)
 * </p>
 */

public class MaximizeAreaofSquareHoleinGrid implements Solution {

  @Override
  public void logic() {
    int n = 2, m = 1;
    int[] hBars = {2,3}, vBars = {2};
    Arrays.sort(hBars);
    Arrays.sort(vBars);
    int s = (int) Math.min(maxSpan(hBars),maxSpan(vBars));

    System.out.println("Max square hole int grid "+s*s);
  }

  private double maxSpan(int[] bars) {
    int res =1;
    int streak=1;
    for(int i=1;i<bars.length;i++){
      if(bars[i]==bars[i-1]+1){
        streak++;
        continue;
      }
      res = Math.max(res,++streak);
      streak=1;
    }
    return Math.max(res,++streak);
  }

  @Override
  public String description() {
    return "97. Maximize Area of Square Hole in Grid";
  }

  @Override
  public String problemStatement() {
    return "You are given the two integers, n and m and two integer arrays, hBars and vBars. The grid has n + 2 horizontal and m + 2 vertical bars, creating 1 x 1 unit cells. The bars are indexed starting from 1.\n"
        + "\n"
        + "You can remove some of the bars in hBars from horizontal bars and some of the bars in vBars from vertical bars. Note that other bars are fixed and cannot be removed.\n"
        + "\n"
        + "Return an integer denoting the maximum area of a square-shaped hole in the grid, after removing some bars (possibly none)."
        + "Input: n = 2, m = 1, hBars = [2,3], vBars = [2]\n"
        + "\n"
        + "Output: 4\n"
        + "\n"
        + "Explanation:\n"
        + "\n"
        + "The left image shows the initial grid formed by the bars. The horizontal bars are [1,2,3,4], and the vertical bars are [1,2,3].\n"
        + "\n"
        + "One way to get the maximum square-shaped hole is by removing horizontal bar 2 and vertical bar 2.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
