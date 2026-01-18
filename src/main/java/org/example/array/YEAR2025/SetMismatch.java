package org.example.array.YEAR2025;

import java.util.HashSet;
import java.util.Set;
import org.example.Solution;

public class SetMismatch implements Solution {

  @Override
  public void logic() {
    int[] nums = {1, 2, 2, 4};
    int n = nums.length;
    int sum = (n * (n + 1)) / 2;
    Set<Integer> set = new HashSet<>();
    int[] res = new int[2];
    for (int num : nums) {
      if (!set.add(num)) {
        res[0] = num;
        res[1] = num;
      }
      sum -= num;
    }
    res[1] += sum;
    for (int re : res) {
      System.out.print(re + " ");
    }
  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  @Override
  public String getToughness() {
    return "Easy";
  }
}
