package org.example.array.YEAR2025;

import org.example.Solution;

public class MaximumProductOfSplittedBinaryTree implements Solution {
  /*
  *
  *
  * */
long totalSum=0;
long maxProduct=0;
  @Override
  public void logic() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
     totalSum = getTotalSum(root);
     dfs(root);
    System.out.println(maxProduct);

  }

  private long dfs(TreeNode root) {
    if(root == null) return 0;
    long left = dfs(root.left);
    long right = dfs(root.right);
    long subSum = root.val + left + right;
    long product = subSum * (totalSum - subSum);
    maxProduct = Math.max(maxProduct, product);
    return subSum;
  }

  private long getTotalSum(TreeNode root) {
    if(root==null) return 0;
    return root.val + getTotalSum(root.left)+getTotalSum(root.right);
  }

  @Override
  public String description() {
    return "84 . 1339. Maximum Product of Splitted Binary Tree";
  }

  @Override
  public String problemStatement() {
    return "Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.\n"
        + "\n"
        + "Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.\n"
        + "\n"
        + "Note that you need to maximize the answer before taking the mod and not after taking it.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: root = [1,2,3,4,5,6]\n"
        + "Output: 110\n"
        + "Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)\n"
        + "Example 2:\n"
        + "\n"
        + "\n"
        + "Input: root = [1,null,2,3,4,null,null,5,6]\n"
        + "Output: 90\n"
        + "Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
