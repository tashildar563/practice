package org.example.array.YEAR2025;

import org.example.Solution;

public class FruitIntoBasket implements Solution {

  @Override
  public void logic() {
    int [] fruits  = {0,1,2,2};
    int f1=-1,f2=-1;
    int countLastFruit =0;
    int currentWindow=0;
    int maxWindow =0;

    for(int fr: fruits){
      if(fr == f1 || fr==f2){
        currentWindow++;
      }
      else{
        currentWindow = countLastFruit + 1;
      }
      if(fr == f2){
        countLastFruit++;
      }else{
        countLastFruit = 1;
        f1=f2;
        f2=fr;
      }
      maxWindow = Math.max(maxWindow,currentWindow);
    }
    System.out.println("treess from fruit collected "+maxWindow);
  }

  @Override
  public String description() {
    return "71. Fruits into basket";
  }

  @Override
  public String problemStatement() {
    return "You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.\n"
        + "\n"
        + "You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:\n"
        + "\n"
        + "You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.\n"
        + "Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.\n"
        + "Once you reach a tree with fruit that cannot fit in your baskets, you must stop.\n"
        + "Given the integer array fruits, return the maximum number of fruits you can pick.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: fruits = [1,2,1]\n"
        + "Output: 3\n"
        + "Explanation: We can pick from all 3 trees.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: fruits = [0,1,2,2]\n"
        + "Output: 3\n"
        + "Explanation: We can pick from trees [1,2,2].\n"
        + "If we had started at the first tree, we would only pick from trees [0,1].\n"
        + "Example 3:\n"
        + "\n"
        + "Input: fruits = [1,2,3,2,2]\n"
        + "Output: 4\n"
        + "Explanation: We can pick from trees [2,3,2,2].\n"
        + "If we had started at the first tree, we would only pick from trees [1,2].";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
