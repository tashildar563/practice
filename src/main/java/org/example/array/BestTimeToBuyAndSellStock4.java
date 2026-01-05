package org.example.array;

import org.example.Solution;

public class BestTimeToBuyAndSellStock4 implements Solution {

  @Override
  public void logic() {
    int price[] = {1,7,9,8,2};
    int k=2;
    final int x0=price[0], n=price.length;
    Data [] dp = new Data[k+1];
    for(int t=0;t<=k;t++)
      dp[t]= new Data(0,-x0,x0);

    for(int i=1;i<n;i++){
      final int x=price[i];
      for(int t=k;t>0;t--){
        Data cur = dp[t];
        long prevP = dp[t-1].profit;
        cur.profit=Math.max(cur.profit,Math.max(cur.buy+x,cur.sell-x));
        cur.buy = Math.max(cur.buy, prevP-x);
        cur.sell=Math.max(cur.sell,prevP+x);
      }
    }
    System.out.println("max profit "+ dp[k].profit);
  }
  class Data{
    long profit=0,buy=0,sell=0;
    Data(long p,long b, long s){
      this.profit = p;
      this.buy=b;
      this.sell=s;
    }
  }

  @Override
  public String description() {
    return "55";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
