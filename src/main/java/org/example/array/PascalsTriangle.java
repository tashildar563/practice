package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.example.Solution;

public class PascalsTriangle implements Solution {

  @Override
  public void logic() {
    int n=5;
    int i=1;
    List<List<Integer>> list = new ArrayList<>();
    while(i<=n){
      List<Integer> arr = new ArrayList<>(i);
      int mid = i/2;
      if(i==1){
        arr.add(1);
        i++;
        list.add(arr);
        continue;
      }
      if(i==2){
        arr.add(1);
        arr.add(1);
        i++;
        list.add(arr);
        continue;
      }
      int l=0;
      List<Integer> pre = list.get(i-2);
      while(l<=pre.size()){
        if(l==0 || l==pre.size()){
          arr.add(1);
          l++;
          continue;
        }
        Integer n1= pre.get(l-1);
        Integer n2=pre.get(l);
        arr.add(n1+n2);
        l++;
      }
      list.add(arr);
      i++;
    }
    System.out.println(list);
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
