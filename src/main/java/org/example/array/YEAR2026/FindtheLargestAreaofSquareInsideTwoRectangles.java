package org.example.array.YEAR2026;

import org.example.Solution;

public class FindtheLargestAreaofSquareInsideTwoRectangles implements Solution {

  @Override
  public void logic() {
    int [][] bottomLeft = {{1,4},{1,1},{3,8}}, topRight = {{6,9},{6,4},{8,10}};
    int j=0;
    double larSqAreaSide=0;
    while(j<bottomLeft.length){
      int i=0;
      while(i<bottomLeft.length){
        if(i==j){
          i++;
          continue;
        }
        int recBot []=bottomLeft[i];
        int recTop []=topRight[i];

        int recBotPrev []=bottomLeft[j];
        int recTopPrev []=topRight[j];

        double maxX = Math.max(recBot[0],recBotPrev[0]);
        double minXL = Math.min(recTop[0],recTopPrev[0]);
        double maxY = Math.max(recBot[1],recBotPrev[1]);
        double minYL = Math.min(recTop[1],recTopPrev[1]);
        if(maxX<minXL && maxY < minYL){
          double side = Math.min((minXL-maxX),(minYL-maxY));
          larSqAreaSide = Math.max(larSqAreaSide,side);
        }
        i++;
      }
      j++;
    }
    System.out.println("sqr side "+larSqAreaSide);
  }

  @Override
  public String description() {
    return "102 Find the Largest Area of Square Inside Two Rectangles";
  }

  @Override
  public String problemStatement() {
    return "There exist n rectangles in a 2D plane with edges parallel to the x and y axis. You are given two 2D integer arrays bottomLeft and topRight where bottomLeft[i] = [a_i, b_i] and topRight[i] = [c_i, d_i] represent the bottom-left and top-right coordinates of the ith rectangle, respectively.\n"
        + "\n"
        + "You need to find the maximum area of a square that can fit inside the intersecting region of at least two rectangles. Return 0 if such a square does not exist.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
