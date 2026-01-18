package org.example.array.YEAR2025;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.example.Solution;

public class MeetingRooms_III implements Solution {

  @Override
  public void logic() {
    int[][] meeting = {{0, 10}, {1, 5}, {2, 7}, {3, 4}};
    Arrays.sort(meeting, (a, b) -> Integer.compare(a[0], b[0]));
    int n = 2;
    int[] count = new int[n];
    PriorityQueue<Integer> freeRoom = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      freeRoom.offer(i);
    }
    PriorityQueue<long[]> used = new PriorityQueue<>((a, b) -> {
      if (a[0] != b[0]) {
        return Long.compare(a[0], b[0]);
      }
      return Long.compare(a[1], b[1]);
    }
    );

    for(int[] m:meeting){
      long start = m[0], end=m[1];
      while(!used.isEmpty() && used.peek()[0]<=start){
        int room = (int) used.poll()[1];
        freeRoom.offer(room);
      }
      long dur = end - start;
      int room;
      long begin;
      if(!freeRoom.isEmpty()){
        room = freeRoom.poll();
        begin = start;
      }else{
        long[] earliest = used.poll();
        long delay = earliest[0];
        room = (int) earliest[1];
        begin = delay;
      }
      count[room]++;
      used.offer(new long[]{begin+dur,room});
    }

    int ans =0;
    for(int i=0;i<n;i++){
      if(count[i]>count[ans]){
        ans=i;
      }
    }
    System.out.println("answer "+ ans);

  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  class Room {

    int hostedMeets;
    int willFreeFrom;
    int occipiedFrom;

    Room(int start, int end) {
      this.occipiedFrom = start;
      this.willFreeFrom = end;
      this.hostedMeets += 1;
    }
  }
}
