package org.example.array;

import org.example.Solution;

public class ReorderPowerOf2 implements Solution {

  @Override
  public void logic() {
    int n=10;
    int [] target = digitFreq(n);
    boolean flag = false;
    for(int i=0;i<=30;i++){
      int powerOf2 = (int) Math.pow(2,i);
      if(equalFreq(target,digitFreq(powerOf2))){
        flag = true;
      }
    }
    System.out.println(" "+ flag);
  }

  private boolean equalFreq(int[] target, int[] b) {
    for(int i=0;i<10;i++){
      if(target[i]!=b[i])
          return false;
    }
    return true;
  }

  private int[] digitFreq(int n) {
    int [] freq = new int[10];
    while(n>0){
      freq[n%10]++;
      n/=10;
    }
    return freq;
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
