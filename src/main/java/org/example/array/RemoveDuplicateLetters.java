package org.example.array;

import java.util.Arrays;
import org.example.Solution;

public class RemoveDuplicateLetters implements Solution {

  @Override
  public void logic() {
    String s = "cbacdcbc";
    System.out.println("String >>>>> : " + removeDuplicateLetters(s));
  }

  public String removeDuplicateLetters(String s) {
    int[] cnt = new int[26];
    int pos = 0; // the position for the smallest s[i]
    for (int i = 0; i < s.length(); i++) {
      cnt[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < s.charAt(pos)) {
        pos = i;
      }
      if (--cnt[s.charAt(i) - 'a'] == 0) {
        break;
      }
    }
    return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(
        s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
  }

  @Override
  public String description() {
    return "32.";
  }

  @Override
  public String problemStatement() {
    return
        "Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "Input: s = \"bcabc\"\n"
            + "Output: \"abc\"\n"
            + "Example 2:\n"
            + "\n"
            + "Input: s = \"cbacdcbc\"\n"
            + "Output: \"acdb\"\n"
            + " \n"
            + "\n"
            + "Constraints:\n"
            + "\n"
            + "1 <= s.length <= 104\n"
            + "s consists of lowercase English letters.\n"
            + " ";
  }
}
