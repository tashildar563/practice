package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.example.Solution;

public class LongestSubstringWithoutRepeatingCharacters implements Solution {

  @Override
  public void logic() {
String string = "abcbc";
//    Map<Character,Integer> map = new HashMap<>();
//    int l=0;
//    int r=l;
//    int max = 0;
//    while(r<string.length()){
//      if(!map.containsKey(string.charAt(r))){
//        map.put(string.charAt(r),r);
//        r++;
//        max=Math.max(max,map.size());
//      }else{
//        map.clear();
//        l++;
//        r=l;
//      }
//    }
    /*int n = string.length();
    int maxLength=0;
    int[] charIndex = new int[128];
    Arrays.fill(charIndex,-1);
    int left =0;
    for(int right=0;right<n;right++){
      if(charIndex[string.charAt(right)]>=left){
        left = charIndex[string.charAt(right)]+1;
      }

      charIndex[string.charAt(right)]=right;
      maxLength = Math.max(maxLength,right-left+1);
    }*/

    int maxLength = 0;
    int n = string.length();
    int[] charindex = new int[128];
    Arrays.fill(charindex,-1);
    int left=0;
    for(int right=0;right<n ; right++){
      if(charindex[string.charAt(right)]>=left){
        left = charindex[string.charAt(right)]+1;
      }
      charindex[string.charAt(right)]=right;
      maxLength = Math.max(maxLength,right-left+1);
    }

    System.out.print("longest substring : "+maxLength);
  }

  @Override
  public String description() {
    return "27. Longest Substring Without Repeating Characters";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
