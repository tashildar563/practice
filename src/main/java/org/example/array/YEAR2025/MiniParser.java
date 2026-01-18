package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.example.Solution;

public class MiniParser implements Solution {

  @Override
  public void logic() {
    String s = "[123,[456,[789]]]";
    Stack<List<Object>> stack = new Stack<>();
    int i=0;
    while(i<s.length()){
      if(s.charAt(i)=='['){
        List<Object> list = new ArrayList<>();
        int j=i+1;
        while(j<s.length()){
          if(s.charAt(j) == ',' || s.charAt(j) == ']'){
            String str = s.substring(i+1,j);
            list.add(Integer.parseInt(str));
            stack.push(list);
            i=j;
            break;
          }
          j++;
        }
      }
      i++;
    }
    List<Object> l = new ArrayList<>();
    while(!stack.isEmpty()){
      List<Object> li = stack.pop();
      if(l.isEmpty()){
        l=li;
      }else{
        li.add(l);
        l=li;
      }
    }
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
    return Solution.super.getToughness();
  }
}
