package org.example.array;

import org.example.Solution;

/**
 * <p>Approach</p>
 * <p>1. build events from each square</p>
 */

public class SeparateSquaresII implements Solution {

  @Override
  public void logic() {
    int[][] squares = {{16,27,3}, {18, 24, 5}};
    double totalArea =0;
    double low = 2e9;
    double high =0;
    for(int i=1;i<squares.length;i++){
      int [] sq=squares[i];
      int [] sqM=squares[i-1];
      double x = sqM[0];
      double y = sqM[1];
      double l = sqM[2];
      double x1 = sq[0];
      double y1 = sq[1];
      double l1 = sq[2];
      double maxX = Math.max(x1,x);
      double minXL = Math.min(x+l,x1+l1);
      double maxY = Math.max(y1,y);
      double minYL = Math.min(y1+l1,y+l);
      if(maxX<minXL && maxY < minYL){
        double overLapx = Math.max(0,minXL-maxX);
        double overLapy = Math.max(0,minYL-maxY);
        totalArea-=overLapx*overLapy;
      }
      if(i==1){
        totalArea+=l1*l1;
        low = Math.min(low,y1);
        high = Math.max(high,y1+l1);
      }
      totalArea += l*l;
      low = Math.min(low,y);
      high = Math.max(high,y+l);
    }
    double halfArea = totalArea/2.0;

    for( int i=0;i<100;i++){
      double mid = low + (high-low)/2.0;
      if(calculateArea(squares,mid)>=halfArea){
        high=mid;
      }else{
        low=mid;
      }
    }
    System.out.println("Y coordinates "+high);
  }
  private double calculateArea(int [][] squares,double currentY){
    double area=0;
    for(int sq[]:squares){
      double y = sq[1];
      double l = sq[2];

      double top = y+l;

      if(y>=currentY){
        continue;
      }else if(top<=currentY){
        area+=l*l;
      }else{
        area+=l*(currentY-y);
      }
    }
    return area;
  }

  @Override
  public String description() {
    return "96. Separate Squares II";
  }

  @Override
  public String problemStatement() {
    return "You are given a 2D integer array squares. Each squares[i] = [xi, yi, li] represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.\n"
        + "\n"
        + "Find the minimum y-coordinate value of a horizontal line such that the total area covered by squares above the line equals the total area covered by squares below the line.\n"
        + "\n"
        + "Answers within 10-5 of the actual answer will be accepted.\n"
        + "\n"
        + "Note: Squares may overlap. Overlapping areas should be counted only once in this version.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: squares = [[0,0,1],[2,2,1]]\n"
        + "\n"
        + "Output: 1.00000";
  }

  @Override
  public String getToughness() {
    return "Hard";
  }
}
