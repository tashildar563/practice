package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

public class MaximumMatrixSum implements Solution {

  @Override
  public void logic() {
    int [][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
    int n = matrix.length;
    int sum=0;
    int negativeCount =0;
    int leastElement=100001;
    for(int row[]: matrix){
      for(int v:row){
        if(v<0){
          negativeCount++;
          v=-v;
        }
        sum+=v;
        if(leastElement>v){
          leastElement=v;
        }
      }
    }
    if(negativeCount%2==0){
      System.out.println("Sum "+ sum);
    }else{
      System.out.println("Sum "+(sum-2*leastElement));
    }
  }

  private int sumOfMatrix(int[][] matrix) {
    int sum = 0;
    for(int i=0;i<matrix.length;i++){
      sum += Arrays.stream(matrix[i]).sum();
    }
    return sum;
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
    return Solution.super.getToughness();
  }
}

