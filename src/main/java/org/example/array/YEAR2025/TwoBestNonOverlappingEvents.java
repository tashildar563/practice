package org.example.array.YEAR2025;

import java.util.Arrays;
import org.example.Solution;

public class TwoBestNonOverlappingEvents implements Solution {

  @Override
  public void logic() {
    /*
    * what problem is this code solving > pick at most two events, event must not voerlap, you want to maximum total value
    *
    * why do we sort the events
    * after event i ends what the earliest event that start after it?*/
    int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
    Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
    int n=events.length;

    /*this is to know that if i start choosing events from index i, what the best value i can get?*/
    int [] sufMax = new int[n];
    sufMax[n-1]=events[n-1][2];
    for(int i=n-2;i>=0;i--){
      sufMax[i]=Math.max(sufMax[i+1],events[i][2]);
    }
    /*now below loop we assume that the current event is first event
    * then we try to find out the best second event that desont overlap*/
    int ans=0;
    for(int i=0;i<n;i++){
      int sum=events[i][2];
      sum+=nextMaxEvent(i+1,n-1,events[i][1],sufMax,events);
      ans=Math.max(ans,sum);
    }

    System.out.println("max "+ans);
  }

  private int nextMaxEvent(int l, int r, int end, int[] sufMax, int[][] events) {
    /*binary serach logic
    *
    * if event(m).start > end
    *   this is valid event
    *   but maybe there an earlier valid one
    *   so move left
    * else this event overlaps move right */
    int max=0;
    while(l<=r){
      int m = l+(r-l)/2;
      if(events[m][0]>end){
        max = sufMax[m];
        r=m-1;
      }else{
        l=m+1;
      }
    }
    return max;
  }

  @Override
  public String description() {
    return "62 Two Best Non-Overlapping Events";
  }

  @Override
  public String problemStatement() {
    return
        "You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.\n"
            + "\n"
            + "Return this maximum sum.\n"
            + "\n"
            + "Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "\n"
            + "Input: events = [[1,3,2],[4,5,2],[2,4,3]]\n"
            + "Output: 4\n"
            + "Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.";
  }
}
