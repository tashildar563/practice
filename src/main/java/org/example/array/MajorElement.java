package org.example.array;

import java.util.logging.SocketHandler;
import org.example.Solution;

public class MajorElement implements Solution {


  @Override
  public void logic() {
    int arr [] = {1,5,5,8,4,5,6,5,4,5,5,4,5};
    int n = arr.length;
    int candidate = arr[0];
    int vote=1;
    int i=1;
    while(i<n){
      if(arr[i]==candidate){
        vote++;
      }else if(vote>0){
        vote--;
      }else{
        candidate = arr[i];
        vote=1;
      }
      i++;
    }
    System.out.println("Major Element "+ candidate);
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
