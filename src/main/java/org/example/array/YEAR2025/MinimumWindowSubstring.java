package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

public class MinimumWindowSubstring implements Solution {

  @Override
  public void logic() {
    String s= "ADOBECODEBANC",t="ABC";
    String subString="";
    int[] charCount = new int[128];
    Arrays.fill(charCount,0);
    for(int i=0;i<t.length();i++){
      charCount[t.charAt(i)]++;
    }
    int count=t.length(),start=0,end=0,minLen=Integer.MAX_VALUE, startIndex=0;
    char[] chs = s.toCharArray();
    while(end<s.length()){
      if(charCount[chs[end++]]-- > 0){
        count--;
      }
      while(count==0){
        if(end - start < minLen){
          startIndex = start;
          minLen = end-start;
        }
        if(charCount[chs[start++]]++==0){
          count++;
        }
      }
    }
    if(minLen==Integer.MAX_VALUE){
      subString =new String();
    }else{
      subString = new String(chs,startIndex,minLen);
    }
    System.out.println("Minimum window Substring : " + subString);

  }

  @Override
  public String description() {
    return "38. Minimum Window Substring";
  }

  @Override
  public String problemStatement() {
    return "Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string \"\".\n"
        + "\n"
        + "The testcases will be generated such that the answer is unique.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: s = \"ADOBECODEBANC\", t = \"ABC\"\n"
        + "Output: \"BANC\"\n"
        + "Explanation: The minimum window substring \"BANC\" includes 'A', 'B', and 'C' from string t.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: s = \"a\", t = \"a\"\n"
        + "Output: \"a\"\n"
        + "Explanation: The entire string s is the minimum window.\n"
        + "Example 3:\n"
        + "\n"
        + "Input: s = \"a\", t = \"aa\"\n"
        + "Output: \"\"\n"
        + "Explanation: Both 'a's from t must be included in the window.\n"
        + "Since the largest window of s only has one 'a', return empty string.";
  }
}
