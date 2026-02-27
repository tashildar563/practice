package org.example.array.YEAR2026;

import org.example.Solution;

public class LongestBalancedSubstringI implements Solution {

  @Override
  public void logic() {
    String s = "abbac";
    int res =0;
    for(int i=0;i<s.length();i++){
      for(int j=i+res;j<s.length();j++){
        String str = s.substring(i,j+1);
        int [] freq = new int[4];
        for(char ch : str.toCharArray()){
          freq[ch-'a']++;
        }
        boolean notBalanced = false;
        for(int m=1;m<str.length();m++){
          if(freq[str.charAt(m)-'a'] != freq[str.charAt(m-1)-'a']){
            notBalanced = true;
            break;
          }
        }
        if(!notBalanced){
          res = Math.max(res,str.length());
        }
      }
    }
    System.out.println("longest balanced substring "+res);
  }
  private int longestSubstring(String s, int k) {
    int n = s.length();
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
      freq[c - 'a']++;
    }

    for (int i = 0; i < n; i++) {
      if (freq[s.charAt(i) - 'a'] == k) {
        int leftStr = longestSubstring(s.substring(0, i), k);
        int rightStr = longestSubstring(s.substring(i + 1), k);
        return Math.max(leftStr, rightStr);
      }
    }
    return n;
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
    return "Medium";
  }
}
