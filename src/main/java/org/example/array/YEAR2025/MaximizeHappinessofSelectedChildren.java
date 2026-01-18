package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

public class MaximizeHappinessofSelectedChildren implements Solution {

  @Override
  public void logic() {
    int [] arr = {2135218,73431904,92495076,77528042,82824634,3036629,28375907,65220365,40948869,58914871,57169530,89783499,19582915,19676695,11932465,21770144,49740276,22303751,80746555,97391584,95775653,43396943,47271136,43935930,59643137,64183008,8892641,39587569,85086654,5663585,82925096,24868817,95900395,48155864,74447380,7618448,63299623,91141186,33347112,81951555,52867615,92184410,7024265,85525916,29846922,59532692,47267934,6514603,1137830,97807470};
    int k=41;
    Arrays.sort(arr);
    int count = 0;
    long res = 0;
    for (int i = arr.length - 1; i >= arr.length - k; i--) {
      if (arr[i] + count > 0) {
        res += arr[i] + count;
      }
      count--;
    }
    System.out.println("max happiness "+res);
  }

  @Override
  public String description() {
    return "64. Maximize Happiness of Selected Children";
  }

  @Override
  public String problemStatement() {
    return "You are given an array happiness of length n, and a positive integer k.\n"
        + "\n"
        + "There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.\n"
        + "\n"
        + "In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.\n"
        + "\n"
        + "Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: happiness = [1,2,3], k = 2\n"
        + "Output: 4\n"
        + "Explanation: We can pick 2 children in the following way:\n"
        + "- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].\n"
        + "- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.\n"
        + "The sum of the happiness values of the selected children is 3 + 1 = 4.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: happiness = [1,1,1,1], k = 2\n"
        + "Output: 1\n"
        + "Explanation: We can pick 2 children in the following way:\n"
        + "- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].\n"
        + "- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].\n"
        + "The sum of the happiness values of the selected children is 1 + 0 = 1.";
  }
}
