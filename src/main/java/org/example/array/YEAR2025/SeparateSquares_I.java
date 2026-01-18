package org.example.array.YEAR2025;

import org.example.Solution;

public class SeparateSquares_I implements Solution {

  /**
   * <p>Approach</p>
   * <p>
   * We need to find a y coordinate (let's call it cutY) such that the area of the squares below cutY is exactly half of the total area.
   * Step 1: Define Search Space. The answer must be between the lowest bottom edge (low) and the highest top edge (high) of all squares.
   * Step 2: Binary Search (Real Numbers). Since the answer is a double , we can't use low <= high. Instead, we run the loop for a fixed number of iterations (e.g., 100 times).
   * Pick a mid-point.
   * Calculate the area of all squares below mid.
   * If Area(mid) >= HalfTotal, the line is too high (or correct), so move high down to mid.
   * If Area(mid) < HalfTotal, the line is too low, so move low up to mid.
   * Step 3: Calculating Area. For each square, check its relation to the line cutY:
   * Fully Below: Add the square's full area (l×l).
   * Fully Above: Add 0.
   * Intersecting: The line cuts through the square. Add the area of the bottom rectangular chunk: Width×(cutY−BottomY).
   * Complexity
   * Time complexity:O(N×K)
   * </p>
   */

  @Override
  public void logic() {
    int[][] squares = {{0, 0, 2}, {1, 1, 1}};
    int m = squares.length - 1;
    double totalArea = 0;
    double low = 2e9;
    double high = 0;
    for (int[] sq : squares) {
      double y = sq[1];
      double l = sq[2];

      totalArea += l * l;
      low = Math.min(low, y);
      high = Math.max(high, y + l);
    }
    double halfArea = totalArea / 2.0;

    for (int i = 0; i < 100; i++) {
      double mid = low + (high - low) / 2.0;
      if (calculateArea(squares, mid) >= halfArea) {
        high = mid;
      } else {
        low = mid;
      }
    }
    System.out.println("y coordinate " + high);


  }

  private double calculateArea(int[][] squares, double mid) {
    double area = 0;
    for (int[] sq : squares) {
      double y = sq[1];
      double l = sq[2];
      double top = y + l;

      if (y >= mid) {
        continue;
      } else if (top <= mid) {
        area += l * l;
      } else {
        area += l * (mid - y);
      }
    }
    return area;
  }

  @Override
  public String description() {
    return "95 : 3453. Separate Squares I";
  }

  @Override
  public String problemStatement() {
    return "You are given a 2D integer array squares. Each squares[i] = [xi, yi, li] represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.\n"
        + "\n"
        + "Find the minimum y-coordinate value of a horizontal line such that the total area of the squares above the line equals the total area of the squares below the line.\n"
        + "\n"
        + "Answers within 10-5 of the actual answer will be accepted.\n"
        + "\n"
        + "Note: Squares may overlap. Overlapping areas should be counted multiple times.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
