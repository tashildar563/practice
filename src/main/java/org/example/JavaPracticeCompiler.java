package org.example;

import java.util.Map;
import java.util.stream.Collectors;

public class JavaPracticeCompiler implements Solution{

  @Override
  public void logic() {
    String s = "kjhalsdlajsdlj";
    Map<Character,Long> map = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
    for(Character key : map.keySet()){
      System.out.println("Character :"+key +" Count :"+map.get(key));
    }
    int n=9;
    if(n<=1){
      System.out.println("Prime number "+n);
    }
    boolean isPrime = true;
    for(int i =2;i<=Math.sqrt(n);i++){
      if(n%i==0){
        System.out.println("Non Prime Number "+n);
        isPrime=false;
        break;
      }
    }
    if(isPrime) System.out.println("It is prime Number : "+n);

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
