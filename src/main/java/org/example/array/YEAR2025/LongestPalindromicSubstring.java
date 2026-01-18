package org.example.array.YEAR2025;

import org.example.Solution;

public class LongestPalindromicSubstring implements Solution {

  @Override
  public void logic() {
    String s = "babad";
    int k = 0;
    int l = 0;
    int r = s.length() - 1;
    boolean isPalindrom = isPalindrom(s);
    if (isPalindrom) {
      System.out.println("longest palindrome substring : " + s);
      return;
    }
    String maxSubStr = "";
    while (l < r) {
      String subString = s.substring(l,r);
      isPalindrom = isPalindrom(subString);
      if (isPalindrom) {
        if(subString.length()>maxSubStr.length()){
          maxSubStr=subString;
        }
      }
      l++;
    }

    System.out.println("longest palindrome substring : " + maxSubStr);
  }

  private boolean isPalindrom(String s) {
    if(s.isEmpty()){
      return false;
    }
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      if (s.charAt(r) != s.charAt(l)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  @Override
  public String description() {
    return "24. Longest Palindromic Substring";
  }

  @Override
  public String problemStatement() {
    return "Given a string s, return the longest palindromic substring in s.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: s = \"babad\"\n"
        + "Output: \"bab\"\n"
        + "Explanation: \"aba\" is also a valid answer.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: s = \"cbbd\"\n"
        + "Output: \"bb\"\n"
        + " \n"
        + "\n"
        + "Constraints:\n"
        + "\n"
        + "1 <= s.length <= 1000\n"
        + "s consist of only digits and English letters.";
  }
}
