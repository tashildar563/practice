package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.Solution;

public class FindEvenNumber implements Solution {

  @Override
  public void logic() {
    int[] arr = {45, 546, 1, 5, 7, 5, 6, 6, 86, 489, 7};
//    arr = Arrays.stream(arr).filter(f->f%2==0).toArray();
//    Arrays.stream(arr).forEach(System.out::println);
//    arr = Arrays.stream(arr).filter(f->{
//      String s = String.valueOf(f);
//      if(s.startsWith("1")){
//        return true;
//      }
//      return false;
//    }).toArray();
//    Set<Integer> set = new HashSet<>();
//    arr = Arrays.stream(arr).filter(f->!set.add(f)).toArray();
    List<Integer> l = new ArrayList<>();
//    Arrays.stream(arr).forEach(l::add);
//     l.stream().limit(1).toList().stream().forEach(System.out::println);
//    Arrays.stream(arr).forEach(System.out::println);
//    OptionalInt max = Arrays.stream(arr).max();
//    System.out.println("Max element "+max.getAsInt());
    String s = "asfadadjfadfad";
    Character k = s.chars().mapToObj(c -> (char) c).filter(c -> s.indexOf(c) == s.lastIndexOf(c))
        .findFirst().orElse(null);
    Character m = s.chars().mapToObj(c -> (char) c).filter(c -> s.indexOf(c) != s.lastIndexOf(c))
        .findFirst().orElse(null);
    arr = Arrays.stream(arr).sorted().toArray();
    Arrays.stream(arr).forEach(System.out::println);
    System.out.println("Fist repeating chracter " + m);
    System.out.println("First non repeating character " + k);
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
    return "Easy";
  }
}
