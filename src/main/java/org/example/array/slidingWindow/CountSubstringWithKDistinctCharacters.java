package org.example.array.slidingWindow;

import org.example.Solution;

public class CountSubstringWithKDistinctCharacters implements Solution {

  @Override
  public void logic() {
    String s = "cac";
    int k=2;
    System.out.println("Substring with "+k+" distinct character " + countString(s,k));
  }

  int countString(String s, int k){
    int n = s.length();
    int ans =0;

    ans = count(s,k)-count(s,k-1);
    return ans;
  }

  int count(String s,int k){
    int n =s.length();
    int ans=0;
    int [] freq = new int[26];
    int distinctCnt = 0;
    int i=0;

    for(int j=0;j<n;j++){
      freq[s.charAt(j)-'a']++;
      if(freq[s.charAt(j)-'a']==1) distinctCnt++;

      while(distinctCnt>k){
        freq[s.charAt(i)-'a']--;
        if(freq[s.charAt(i)-'a']==0) distinctCnt--;
        i++;
      }

      ans+=j-i+1;
    }
    return ans;
  }

  @Override
  public String description() {
    return "42. ";
  }

  @Override
  public String problemStatement() {
    return "Given a string s consisting of only lowercase English letters and an integer k, count the total number of substrings (not necessarily distinct) of s that contain exactly k distinct characters.\n"
        + "Note:\n"
        + "\n"
        + "A substring is a contiguous sequence of characters within a string.\n"
        + "Substrings that are identical but occur at different positions should each be counted separately.\nInput: s = \"abc\", k = 2\n"
        + "Output: 2\n"
        + "Explanation: Possible substrings are [\"ab\", \"bc\"]\n"
        + "\n"
        + "Input: s = \"aba\", k = 2\n"
        + "Output: 3\n"
        + "Explanation: Possible substrings are [\"ab\", \"ba\", \"aba\"]\n"
        + "\n"
        + "Input: s = \"aa\", k = 1\n"
        + "Output: 3\n"
        + "Explanation: Possible substrings are [\"a\", \"a\", \"aa\"]";
  }
}
