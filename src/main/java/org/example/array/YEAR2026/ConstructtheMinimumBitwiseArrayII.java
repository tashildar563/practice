package org.example.array.YEAR2026;

import java.util.ArrayList;
import java.util.List;
import org.example.Solution;

public class ConstructtheMinimumBitwiseArrayII implements Solution {

  @Override
  public void logic() {
    int i =7;
    List<Integer> list = new ArrayList<>();
    getBinaryNumbers(list,i);
    list = list.reversed();


  }

  private void getBinaryNumbers(List<Integer> list, int i) {
    int den = i/2;
    int rem =i%2;
    list.add(rem);
    if(den>0){
      getBinaryNumbers(list,rem);
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
    return "Medium";
  }
}
