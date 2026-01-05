package org.example.array;

import java.util.Arrays;
import org.example.Solution;

public class LongestSubstringWithAtLeastKRepeatingCharacters implements Solution {

  @Override
  public void logic() {
    String s = "ababbcd";
    int k=1;
    int length = longestSubstring(s,k);
    System.out.println("Longest Substring with At Least "+k+" Repeating Characters is : >>>> " +length+" <<<<< of length :"+length);
  }

  private int longestSubstring(String s, int k) {
    /*int n = s.length();
    int[] freq = new int[26];
    for(char ch : s.toCharArray()){
      freq[ch-'a']++;
    }

    for(int i=0;i<n;i++){
      if(freq[s.charAt(i)-'a'] < k){
        int leftStr = longestSubstring(s.substring(0,i),k);
        int rightStr =  longestSubstring(s.substring(i+1),k);
        return Math.max(leftStr,rightStr);
      }
    }*/



    int n = s.length();
    int[] freq = new int[26];
    for(char ch : s.toCharArray()){
      freq[ch-'a']++;
    }
    for(int i=0;i<n;i++){
      if(freq[s.charAt(i)-'a']<k){
        int leftStr =  longestSubstring(s.substring(0,i),k);
        int rightStrt = longestSubstring(s.substring(i+1),k);
        return Math.max(leftStr,rightStrt);
      }
    }
    return n;
  }

  @Override
  public String description() {
    return "30. Longest Substring with At Least K Repeating Characters";
  }

  @Override
  public String problemStatement() {
    return "Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.\n"
        + "\n"
        + "if no such substring exists, return 0.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: s = \"aaabb\", k = 3\n"
        + "Output: 3\n"
        + "Explanation: The longest substring is \"aaa\", as 'a' is repeated 3 times.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: s = \"ababbc\", k = 2\n"
        + "Output: 5\n"
        + "Explanation: The longest substring is \"ababb\", as 'a' is repeated 2 times and 'b' is repeated 3 times.";
  }
}
