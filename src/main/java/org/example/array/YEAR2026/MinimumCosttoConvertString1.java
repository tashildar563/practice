package org.example.array.YEAR2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.example.Solution;

public class MinimumCosttoConvertString1 implements Solution {

  @Override
  public void logic() {
    String source = "aaaabadaaa", target = "dbdadddbad";
    char[] original ={'c','a','c','a','a','b','b','b','d','d','c'},
             changed = {'a','c','b','d','b','c','a','d','c','b','d'};
    int [] costs = {7,8,11,9,7,6,4,6,9,5,9};
    int INF = Integer.MAX_VALUE / 2;
    int[][] dist = new int[26][26];
    for (int i = 0; i < 26; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0;
    }
    for (int i = 0; i < original.length; i++) {
      int u = original[i] - 'a';
      int v = changed[i] - 'a';
      dist[u][v] = Math.min(dist[u][v], costs[i]);
    }
    for (int k = 0; k < 26; k++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (dist[i][k] < INF && dist[k][j] < INF) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
    }
    long total_cost = 0;
    for (int i = 0;  i < source.length(); i++) {
      int s = source.charAt(i) - 'a';
      int t = target.charAt(i) - 'a';
      if (s == t)
        continue;
      if (dist[s][t] == INF){
        total_cost = -1;
        break;
      }
      total_cost += dist[s][t];
    }
    System.out.println("total cost "+ (total_cost == Integer.MAX_VALUE ? -1 : total_cost));
  }

  @Override
  public String description() {
    return "111. Minimum Cost to Convert String I";
  }

  @Override
  public String problemStatement() {
    return "You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters. You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i] represents the cost of changing the character original[i] to the character changed[i].\n"
        + "\n"
        + "You start with the string source. In one operation, you can pick a character x from the string and change it to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.\n"
        + "\n"
        + "Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.\n"
        + "\n"
        + "Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: source = \"abcd\", target = \"acbe\", original = [\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"], changed = [\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"], cost = [2,5,5,1,2,20]\n"
        + "Output: 28\n"
        + "Explanation: To convert the string \"abcd\" to string \"acbe\":\n"
        + "- Change value at index 1 from 'b' to 'c' at a cost of 5.\n"
        + "- Change value at index 2 from 'c' to 'e' at a cost of 1.\n"
        + "- Change value at index 2 from 'e' to 'b' at a cost of 2.\n"
        + "- Change value at index 3 from 'd' to 'e' at a cost of 20.\n"
        + "The total cost incurred is 5 + 1 + 2 + 20 = 28.\n"
        + "It can be shown that this is the minimum possible cost.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: source = \"aaaa\", target = \"bbbb\", original = [\"a\",\"c\"], changed = [\"c\",\"b\"], cost = [1,2]\n"
        + "Output: 12\n"
        + "Explanation: To change the character 'a' to 'b' change the character 'a' to 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b', a total cost of 3 * 4 = 12 is incurred.\n"
        + "Example 3:\n"
        + "\n"
        + "Input: source = \"abcd\", target = \"abce\", original = [\"a\"], changed = [\"e\"], cost = [10000]\n"
        + "Output: -1\n"
        + "Explanation: It is impossible to convert source to target because the value at index 3 cannot be changed from 'd' to 'e'.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }
}
