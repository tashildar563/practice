package org.example.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.example.Solution;
/**
 * <p>problem statement:</p>
 * -----------------
 * <p>
 *  we are given two string s1 and s2
 *  we are allowed to deltet characters form either string.
 *
 *  teh cost fo deleting a character is tis ASCII value.
 *
 *  out goal is to make the two strings equal with the
 *  MINIMUM possible total ASCII deletion cost
 *</p>
 *
 *  <p>key observation:</p>
 *<p>
 *  instaed of directly thinking deletions. it is easier
 *  to think about what we keep.
 *
 *  if we keep a common subsequence in both strings.
 *    - that subsequence is not deleted from either string.
 *    - Everything else is deleted.
 *
 *  let:
 *    cost1 = total ASCII sum of s1
 *    cost2 = totol ASCII sum of s2
 *    keep = ASCII sum of a common subsequence kept in both
 *
 *  Then:
 *    total deletion cost
 *      = (cost1-keep) +(cost2-keep)
 *      = cost1 + cost2 - 2 * keep
 *      so the problem reduces to:
 *        find a common subsequence of s1 and s2
 *        whose ASCII sum is MAXIMUM
 *
 *   so the problem reduces to
 *    find a common subsequence of s1 and s2
 *    whose ASCII sum is maximum.
 *
 *</p><p>
 *   DP Definition:
 *   Let
 *    let dp[i][j] = maximum ASCII sum of a common subsequence
 *                   between s1[i...n-1] and s2[j...m-1]
 *
 *    dp[i][j] answers:
 *      what is the best ASCII value we can keep
 *          if we start from index i in s1 and j in s2?
 *
 *     Base case
 *     if either string is exhausted :
 *          dp[n][*]=0
 *          dp[*][m]=0;
 *
 *     this is correct because no common subsequence is possible.
 *
 *
 *     transition
 *       at possition (i,j)
 *
 *       1) if character Match : s1[i]=s2[j]
 *            then we keep this character in the subsequence.
 *            its ASCII value contributes to the totol.
 *
 *                dp[i][j] = ASCII(s1[i]+dp[i+1][j+1]
 *
 *      2) if characters do not match :
 *            s1[i] != s2[j]
 *
 *            we have two choices:
 *            - Skip s1[i]
 *            - skip s2[j]
 *
 *         we take the better of the two:
 *          dp[i][j] = max[dp[i+1][j],dp[i][j+1])
 *</p>
 * <p>
 *  ordere of computation
 *     we fill the DP table bottom up, starting from the end
 *     of both strings and moving backward.
 *</p>
 *<p>
 *  final Answer:
 *
 *  dp[0][0] gives the maximum ASCII sum of a common subsequence that can be kep in both strings.
 *
 *  using the formula derived earlier
 *     minimum delete sum
 *     = cost1 + cost2 -1 * dp[0][0];
 *</p>
 */
public class MinimumASCIIDeleteSumforTwoStrings implements Solution {



  @Override
  public void logic() {
    List<String> list = Arrays.asList("a","b");
    list.add("c");
    String s1 = "delete", s2 = "leet";
    int n = s1.length(), m=s2.length();
    char[] a= s1.toCharArray();
    int cost1= s1.chars().sum();

    char[] b = s2.toCharArray();
    int cost2=s2.chars().sum();

    int dp[][] = new int[n+1][m+1];
    for(int i=n-1 ;i >=0 ;i--){
      for(int j=m-1;j>=0 ;j--){
        if(a[i]==b[j]){
          dp[i][j] = a[i]+dp[i+1][j+1];
        }else{
          dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
        }
      }
    }


    System.out.println("Sum " + (cost1+cost2-2*dp[0][0]));
  }

  @Override
  public String description() {
    return "92 Minimum ASCII Delete Sum for Two Strings";
  }

  @Override
  public String problemStatement() {
    return
        "Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "Input: s1 = \"sea\", s2 = \"eat\"\n"
            + "Output: 231\n"
            + "Explanation: Deleting \"s\" from \"sea\" adds the ASCII value of \"s\" (115) to the sum.\n"
            + "Deleting \"t\" from \"eat\" adds 116 to the sum.\n"
            + "At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.\n"
            + "Example 2:\n"
            + "\n"
            + "Input: s1 = \"delete\", s2 = \"leet\"\n"
            + "Output: 403\n"
            + "Explanation: Deleting \"dee\" from \"delete\" to turn the string into \"let\",\n"
            + "adds 100[d] + 101[e] + 101[e] to the sum.\n"
            + "Deleting \"e\" from \"leet\" adds 101[e] to the sum.\n"
            + "At the end, both strings are equal to \"let\", and the answer is 100+101+101+101 = 403.\n"
            + "If instead we turned both strings into \"lee\" or \"eet\", we would get answers of 433 or 417, which are higher.";
  }

  @Override
  public String getToughness() {
    return Solution.super.getToughness();
  }
}
