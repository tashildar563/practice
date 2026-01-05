package org.example.array;

import org.example.Solution;

public class MinimumPenaltyforaShop implements Solution {

  @Override
  public void logic() {
    String cus = "YYNY";
    int n=cus.length();
    int prefix[] = new int[n+1];
    int suffix[] = new int[n+1];
    int min = Integer.MAX_VALUE;

    prefix[0]=0;
    suffix[n]=0;

    for(int i=0;i<n;i++){
      if(cus.charAt(i)=='N'){
        prefix[i+1]=prefix[i]+1;
      }else{
        prefix[i+1]=prefix[i];
      }
    }

    for(int i=n-1;i>=0;i--){
      if(cus.charAt(i)=='Y'){
        suffix[i]=suffix[i+1]+1;
      }else{
        suffix[i]=suffix[i+1];
      }
    }
    int mini=0;

    for(int i=0;i<=n;i++){
      int penalty = prefix[i]+suffix[i];
      if(penalty<min){
        min=penalty;
        mini=i;
      }
    }
    System.out.println("imini "+mini);
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
