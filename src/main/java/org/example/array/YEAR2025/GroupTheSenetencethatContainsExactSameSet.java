package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.List;
import org.example.Solution;

public class GroupTheSenetencethatContainsExactSameSet implements Solution {

  @Override
  public void logic() {
    String[] arr = {"dog and cat",
        "cat and dog",
        "fish and bird",
        "bird and fish",
        "dog and bird"
    };
    int l =0;
    List<String> lists = new ArrayList<>();
    while(l<arr.length){
      if(arr[l].equals("")){
        l++;
        continue;
      }
      String str = arr[l];
      List<String> list = List.of(str.split(" "));
      for(int i = l+1;i<arr.length;i++){
        if(arr[i].equals("")){
          continue;
        }
        List<String> internal = List.of(arr[i].split(" "));
        if(internal.containsAll(list)){
          lists.add(arr[i]);
          lists.add(arr[l]);
          arr[l] ="";
          arr[i] ="";
        }
      }
      l++;
    }
    lists.stream().forEach(System.out::println);
  }

  @Override
  public String description() {
    return "46";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
