package org.example.array;

import java.util.Stack;
import org.example.Solution;

public class MaximumRectangle implements Solution {

  @Override
  public void logic() {
    String[][] matrix = {
        {"1", "0", "1", "0", "0"},
        {"1", "0", "1", "1", "1"},
        {"1", "1", "1", "1", "1"},
        {"1", "0", "0", "1", "0"}};
    int m = matrix.length, n = matrix[0].length;
    int[] height = new int[n];
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        height[j] = matrix[i][j] == "1" ? height[j] + 1 : 0;
      }
      ans = Math.max(ans, largerstRectangle(height));
    }
  }

  private int largerstRectangle(int[] height) {
    Stack<Integer> st = new Stack<>();
    int n = height.length;
    int max = 0;
    for (int i = 0; i <= n; i++) {
      int cur = i == n ? 0 : height[i];
      while (!st.isEmpty() && height[st.peek()] > cur) {
        int h = height[st.pop()];
        int w = st.isEmpty() ? i : i - st.peek() - 1;
        max = Math.max(max, h * w);
      }
      st.push(i);
    }
    return max;
  }

  @Override
  public String description() {
    return "93. Maximal Rectangle";
  }

  @Override
  public String problemStatement() {
    return "Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: matrix = [[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]\n"
        + "Output: 6\n"
        + "Explanation: The maximal rectangle is shown in the above picture.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: matrix = [[\"0\"]]\n"
        + "Output: 0\n"
        + "Example 3:\n"
        + "\n"
        + "Input: matrix = [[\"1\"]]\n"
        + "Output: 1\n"
        + " ";
  }

  @Override
  public String getToughness() {
    return "Hard";
  }
}
