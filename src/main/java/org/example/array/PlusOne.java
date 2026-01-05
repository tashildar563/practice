package org.example.array;

import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor.STRING;
import org.example.Solution;

public class PlusOne implements Solution {

  @Override
  public void logic() {
    int[] digits = {9,9};
    List<Integer> list = new ArrayList<>();
    int n= digits.length;

    int idx = recursive(digits,n,list);
    for(int i=list.size()-1;i>=0;i--){
      if(idx==-1){
        digits=new int[list.size()];
        idx++;
      }
      digits[idx]=list.get(i);
      idx++;
    }
    for(int i=0;i<n;i++){
      System.out.print(" "+digits[i]);
    }
  }
  public int recursive(int[] digits, int idx, List<Integer> list){
    idx--;
    if(idx==-1){
      list.add(1);
      return idx;
    }
    if(digits[idx]+1==10){
      list.add(0);
      idx = recursive(digits,idx, list);
    } else {
      list.add(digits[idx]+1);
    }
    return idx;
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
    return "Easy";
  }
}
