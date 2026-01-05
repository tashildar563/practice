package org.example.array;

import org.example.Solution;

public class DeleteCharactersToMakeFancyString implements Solution {

  @Override
  public void logic() {
    String s = "aaaa";
    StringBuilder ans = new StringBuilder();
    char last = s.charAt(0);
    ans.append(last);
    int count=1;
    for(int i=1;i<s.length();i++){
      char c= s.charAt(i);
      if(c ==last){
        count++;
        if(count <3) ans.append(c);
      }else {
        last =c;
        count=1;
        ans.append(c);
      }
    }

    System.out.println(">>>>>>>>>> "+ans.toString());
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
