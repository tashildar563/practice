package org.example.array.YEAR2026;

import java.util.ArrayList;
import java.util.List;
import org.example.Solution;

public class BalanceaBinarySearchTree implements Solution {

  @Override
  public void logic() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);

    List<Integer> val = new ArrayList<>();
    inorder(root, val);
    System.out.println("Tree " + buildTreeNode(val, 0, val.size() - 1));

  }

  private TreeNode buildTreeNode(List<Integer> val, int l, int r) {
    if (l > r) {
      return null;
    }
    int mid = (l + r) / 2;
    TreeNode node = new TreeNode(val.get(mid));
    node.left = buildTreeNode(val, l, mid - 1);
    node.right = buildTreeNode(val, mid + 1, r);
    return node;
  }

  private void inorder(TreeNode root, List<Integer> val) {
    if (root == null) {
      return;
    }
    inorder(root.left, val);
    val.add(root.val);
    inorder(root.right, val);
  }

  @Override
  public String description() {
    return "115 Balance a Binary Search Tree";
  }

  @Override
  public String problemStatement() {
    return
        "Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.\n"
            + "\n"
            + "A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }


  }
}
