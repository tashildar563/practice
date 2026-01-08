package org.example.array;

import org.example.Solution;

public class Largest3SameDigitNumberinString implements Solution {

  @Override
  public void logic() {
    String num = "6771339";
    num = num.replaceFirst("0","2");
    long max = Integer.MIN_VALUE;
    String str = "";
    for (int i = 0; i <= num.length() - 3; i++) {
      boolean triplet = true;
      String sub = num.substring(i, i + 3);
      int j = 0;
      while (j + 1 < sub.length()) {
        if (sub.charAt(j) != sub.charAt(j + 1)) {
          triplet = false;
          break;
        }
        j++;
      }
      if (triplet && max < Long.parseLong(sub)) {
        str = sub;
        max = Long.parseLong(sub);
      }
    }
    System.out.println("Max "+ str);
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
