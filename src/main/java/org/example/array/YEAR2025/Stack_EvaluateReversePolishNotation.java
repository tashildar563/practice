package org.example.array.YEAR2025;

import java.util.HashMap;
import java.util.Map;
import org.example.Solution;

public class Stack_EvaluateReversePolishNotation implements Solution {

  @Override
  public void logic() {
    String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    Map<String, Integer> map = new HashMap<>();
    int i = 0;
    int j = 2;
    String[] str = new String[tokens.length - j];
    while (j < tokens.length) {
      if (tokens[j].matches("[+*/-]")) {
        int v = 0;
        switch (tokens[j]) {
          case "+":
            v = Integer.parseInt(tokens[i]) + Integer.parseInt(tokens[j - 1]);
            break;
          case "*":
            v = Integer.parseInt(tokens[i]) * Integer.parseInt(tokens[j - 1]);
            break;
          case "/":
            v = Integer.parseInt(tokens[i]) / Integer.parseInt(tokens[j - 1]);
            break;
          default:
            break;
        }
        str[i] = String.valueOf(v);
        for (int k = i + 1; k < tokens.length - 2; k++) {
          str[k] = tokens[j + 1];
          j++;
        }
        tokens = str;
        i = 0;
        j = 2;
        if (tokens.length > 1) {
          str = new String[tokens.length - 2];
        } else {
          str = new String[]{"0"};
        }
      } else {
        str[i] = tokens[i];
        i++;
        j++;
      }
    }
    System.out.println("Expression value : " + tokens[0]);

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
    return "Medium";
  }

  class ActionNode {

    int value;
    ActionNode next;

    ActionNode(int v) {
      this.value = v;
    }
  }
}
