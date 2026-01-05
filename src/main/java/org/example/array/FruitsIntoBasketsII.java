package org.example.array;

import java.util.PriorityQueue;
import org.example.Solution;

public class FruitsIntoBasketsII implements Solution {

  @Override
  public void logic() {
    int [] fruits={4,2,5};
    int [] baskets = {3,5,4};
    int i=0;
    int count=0;
    while(i<fruits.length){
      int f = fruits[i];
      int j=0;
      while(j<baskets.length && baskets[j]<f){
        j++;
      }
      if(j<baskets.length){
        baskets[j]=-1;
      }else{
        count++;
      }
      i++;
    }
    System.out.println("count :"+count);
//    boolean [] used = new boolean[baskets.length];
//    int i=0;
//    int unplaced=0;
//    while(i<baskets.length){
//      boolean placed = false;
//      for(int j=0;j<fruits.length;j++){
//        if(!used[j] && fruits[i]<=baskets[j]){
//          used[j]=true;
//          placed=true;
//          break;
//        }
//      }
//      if(!placed){
//        unplaced++;
//      }
//      i++;
//    }
    /*
    * 4 >> 4-3 = 1, 4-5=-1, 4-4=0 >> 0
    * 2 >> 2-3 = -1, 2-5=-3, 2-4=-2 >> -6
    * 5 >> 5-3=2, 5-5=0, 5-4=1 >> 3;
    *
    * */

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
