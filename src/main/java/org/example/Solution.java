package org.example;

public interface Solution {
    void logic();
    String description();
    String problemStatement();

  default String getToughness() {
    return null;
  }
}
