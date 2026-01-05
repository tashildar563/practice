package org.example.array;

import org.example.Solution;

public class DeleteColumnstoMakeSorted2 implements Solution {

  @Override
  public void logic() {
    String strs[] = {"xga","xfb","yfa"};
    int n = strs.length;
    int m = strs[0].length();
    boolean[] sorted = new boolean[n-1];
    int deletions =0;
    for(int col=0;col<m;col++){
      boolean needDelete = false;
      for(int row=0;row<n-1;row++){
        if(!sorted[row] && strs[row].charAt(col)>strs[row+1].charAt(col)){
          needDelete = true;
          break;
        }
      }
      if(needDelete){
        deletions++;
        continue;
      }
      for(int row=0;row<n-1;row++){
        if(!sorted[row] && strs[row].charAt(col)<strs[row+1].charAt(col)){
          sorted[row] = true;
        }
      }
    }

    System.out.println("Deletions "+deletions);
  }

  @Override
  public String description() {
    return "60. Delete Columns to Make Sorted II";
  }

  @Override
  public String problemStatement() {
    return "You are given an array of n strings strs, all of the same length.\n"
        + "\n"
        + "We may choose any deletion indices, and we delete all the characters in those indices for each string.\n"
        + "\n"
        + "For example, if we have strs = [\"abcdef\",\"uvwxyz\"] and deletion indices {0, 2, 3}, then the final array after deletions is [\"bef\", \"vyz\"].\n"
        + "\n"
        + "Suppose we chose a set of deletion indices answer such that after deletions, the final array has its elements in lexicographic order (i.e., strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]). Return the minimum possible value of answer.length.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: strs = [\"ca\",\"bb\",\"ac\"]\n"
        + "Output: 1\n"
        + "Explanation: \n"
        + "After deleting the first column, strs = [\"a\", \"b\", \"c\"].\n"
        + "Now strs is in lexicographic order (ie. strs[0] <= strs[1] <= strs[2]).\n"
        + "We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.\n"
        + "Example 2:\n"
        + "\n"
        + "Input: strs = [\"xc\",\"yb\",\"za\"]\n"
        + "Output: 0\n"
        + "Explanation: \n"
        + "strs is already in lexicographic order, so we do not need to delete anything.\n"
        + "Note that the rows of strs are not necessarily in lexicographic order:\n"
        + "i.e., it is NOT necessarily true that (strs[0][0] <= strs[0][1] <= ...)\n"
        + "Example 3:\n"
        + "\n"
        + "Input: strs = [\"zyx\",\"wvu\",\"tsr\"]\n"
        + "Output: 3\n"
        + "Explanation: We have to delete every column.";
  }
}
