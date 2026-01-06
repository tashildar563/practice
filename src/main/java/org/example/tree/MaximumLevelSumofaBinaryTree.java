package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import org.example.Solution;

public class MaximumLevelSumofaBinaryTree implements Solution {

  @Override
  public void logic() {
    TreeNode root = new TreeNode(-100);
    root.left = new TreeNode(-200);
    root.left.left = new TreeNode(-20);
    root.left.right = new TreeNode(-5);
    root.right = new TreeNode(-300);
    root.right.left = new TreeNode(-10);

    Queue<TreeNode> q = new LinkedList<>();
    int maxSum = Integer.MIN_VALUE;
    int maxSumIndex = 0;
    q.offer(root);
    int currentLevel = 0;
    while (!q.isEmpty()) {
      int len = q.size();
      int sum = 0;
      for (int i = 0; i < len; i++) {
        TreeNode node = q.poll();
        sum += node.val;
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      if (maxSum < sum) {
        maxSum = sum;
        maxSumIndex = currentLevel;
      }
      currentLevel++;
    }
    System.out.println(" Max sum at level " + maxSumIndex);
  }

  @Override
  public String description() {
    return "81. Maximum Level Sum of a Binary Tree";
  }

  @Override
  public String problemStatement() {
    return
        "Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.\n"
            + "\n"
            + "Return the smallest level x such that the sum of all the values of nodes at level x is maximal.\n"
            + "\n"
            + " \n"
            + "\n"
            + "Example 1:\n"
            + "\n"
            + "\n"
            + "Input: root = [1,7,0,7,-8,null,null]\n"
            + "Output: 2\n"
            + "Explanation: \n"
            + "Level 1 sum = 1.\n"
            + "Level 2 sum = 7 + 0 = 7.\n"
            + "Level 3 sum = 7 + -8 = -1.\n"
            + "So we return the level with the maximum sum which is level 2.\n"
            + "Example 2:\n"
            + "\n"
            + "Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]\n"
            + "Output: 2";
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
