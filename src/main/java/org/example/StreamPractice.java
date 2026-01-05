package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice implements Solution{

  @Override
  public void logic() {
    String s = "abdnchhsgj";
    Map<Character, Long> map = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
    map.keySet().stream().forEach(key -> System.out.print(key + " = " +map.get(key)+" "));

  }

  @Override
  public String description() {
    return "43.";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
