package org.example.array.YEAR2025;

import org.example.Solution;

public class RemoveTwoConsicutiveCharacter implements Solution {

  @Override
  public void logic() {
    String s = "ABCCAADBB";
    int l=1;
    int count = 0;
    while(l<s.length()){
      if(s.charAt(l)==s.charAt(l-1)){
        s= s.substring(0,l-1)+s.substring(l+1);
        count++;
        l=l-1;
      }else{
        l++;
      }
    }
    System.out.println(" No of two Consecutive Characters "+count+" >>> "+ s);
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
