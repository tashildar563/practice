package org.example.array.YEAR2025;

import org.example.Solution;

public class MaximumScoreFromRemovingSubstrings implements Solution {

  @Override
  public void logic() {
    String s = "cdbcbbaaabab";
    int x=4;
    int y=4;
//    PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>((e1,e2)->Integer.compare(
//        e2.getValue(),e1.getValue()));
//    Map<String,Integer> map = new HashMap<>();
//    map.put("ab",x);
//    map.put("ba",y);
//    for(Map.Entry<String,Integer> entry: map.entrySet()){
//      priorityQueue.add(entry);
//    }
//int score =0;
//
//    while(!priorityQueue.isEmpty()){
//        Map.Entry<String,Integer> entry = priorityQueue.poll();
//        int i=0;
//        while(i+1<s.length()){
//          if(entry.getKey().equals(s.substring(i,i+2))){
//            s = s.substring(0,i)+s.substring(i+2);
//            score+=entry.getValue();
//            i = Math.max((i - 1), 0);
//          }else{
//            i++;
//          }
//        }
//    }
    int score = maximumGain( s, x, y);
    System.out.println("Maximum Score "+score);
  }

  private int maximumGain(String s, int x, int y) {
    int score=0;
    if(x>=y){
      Result first = removePattern(s,'a','b',x);
      Result second = removePattern(s,'b','a',y);
      score = first.score+ second.score;
    }else{
      Result first = removePattern(s,'b','a',y);
      Result second = removePattern(s,'a','b',x);
      score = first.score+ second.score;
    }
    return score;
  }

  private Result removePattern(String s, char first, char second, int v) {
    StringBuilder stack = new StringBuilder();
    int score=0;
    for(char c:s.toCharArray()){
      int len = stack.length();
      if(len>0 && stack.charAt(len-1)==first && c == second){
        stack.deleteCharAt(len-1);
        score+=v;
      }else{
        stack.append(c);
      }
    }
    return new Result(stack.toString(),score);
  }

  class Result{
    String remaining;
    int score;
    Result(String remaining,int s){
      this.remaining=remaining;
      this.score=s;
    }
  }

  @Override
  public String description() {
    return "58 Maximum Score From Removing Substrings";
  }

  @Override
  public String problemStatement() {
    return "You are given a string s and two integers x and y. You can perform two types of operations any number of times.\n"
        + "\n"
        + "Remove substring \"ab\" and gain x points.\n"
        + "For example, when removing \"ab\" from \"cabxbae\" it becomes \"cxbae\".\n"
        + "Remove substring \"ba\" and gain y points.\n"
        + "For example, when removing \"ba\" from \"cabxbae\" it becomes \"cabxe\".\n"
        + "Return the maximum points you can gain after applying the above operations on s.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: s = \"cdbcbbaaabab\", x = 4, y = 5\n"
        + "Output: 19\n"
        + "Explanation:\n"
        + "- Remove the \"ba\" underlined in \"cdbcbbaaabab\". Now, s = \"cdbcbbaaab\" and 5 points are added to the score.\n"
        + "- Remove the \"ab\" underlined in \"cdbcbbaaab\". Now, s = \"cdbcbbaa\" and 4 points are added to the score.\n"
        + "- Remove the \"ba\" underlined in \"cdbcbbaa\". Now, s = \"cdbcba\" and 5 points are added to the score.\n"
        + "- Remove the \"ba\" underlined in \"cdbcba\". Now, s = \"cdbc\" and 5 points are added to the score.\n"
        + "Total score = 5 + 4 + 5 + 5 = 19.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: s = \"aabbaaxybbaabb\", x = 5, y = 4\n"
        + "Output: 20";
  }
}
