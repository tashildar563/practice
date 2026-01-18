package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.Solution;

public class AllCombinationOfString implements Solution {

  @Override
  public void logic() {
    String str = "ABCDE";
    List<String> result = findThePermutations(str);
    System.out.println("Count :"+result.size());
    for (String x : result) {
      System.out.print(x + " ");
    }
  }

  private List<String> findThePermutations(String str) {
    StringBuilder strBuil = new StringBuilder(str);
    List<String> ans = new ArrayList<>();
    recurePermutation(0,strBuil,ans);
    Collections.sort(ans);
    return ans;
  }

  private void recurePermutation(int i, StringBuilder s, List<String> ans) {
    if(i == s.length()){
      ans.add(s.toString());
      return;
    }
    for(int j = i;j< s.length();j++){
      swapStr(s,i,j);
      recurePermutation(i+1,s,ans);
      swapStr(s,i,j);
    }
  }

  private void swapStr(StringBuilder s, int i, int j) {
    char temp = s.charAt(i);
    s.setCharAt(i,s.charAt(j));
    s.setCharAt(j,temp);
  }

  @Override
  public String description() {
    return "39.";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
