package org.example.array.YEAR2025;

import org.example.Solution;

public class DeleteColumnstoMakeSorted implements Solution {

  @Override
  public void logic() {
    String[] strs = {"zyx","wvy","tsr"};
    int column = 0;
    int row = 0;
    int n = strs[0].length();
    for (int i = 0; i < n; i++) {
      while (row + 1 < strs.length) {
        String str = strs[row];
        String str1 = strs[row + 1];
        if (str.charAt(i) > str1.charAt(i)) {
          column +=1;
          break;
        }
        row++;
      }
      row=0;
    }
    System.out.println("Column not sorted : " + column);
  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
