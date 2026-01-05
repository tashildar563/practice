package org.example;

import java.util.Stack;

public class KthSmallestElementinaBST implements Solution{
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  @Override
  public void logic() {
     TreeNode root = new TreeNode(5);
     root.left = new TreeNode(3);
     root.right = new TreeNode(6);
     root.left.right = new TreeNode(4);
     root.left.left = new TreeNode(2);
     root.left.left.left = new TreeNode(1);
     int k=5;

     int kthSmallest = kthSmallesh(root,k);
     System.out.println("kth :"+k+"th samllest element :"+ kthSmallest);

  }

  public int kthSmallesh(TreeNode root, int k){
     Stack<TreeNode> stack = new Stack<>();
     while(root !=null){
       stack.push(root);
       root = root.left;
     }

     while(k!=0){
       TreeNode node = stack.pop();
       k--;
       if(k==0) return node.val;
       TreeNode right = node.right;
       while(right!=null){
         stack.push(right);
         right = right.left;
       }
     }
     return -1;
  }

  @Override
  public String description() {
    return "31. Kth Smallest Element in a BST";
  }

  @Override
  public String problemStatement() {
    return "Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: root = [3,1,4,null,2], k = 1\n"
        + "Output: 1\n"
        + "Example 2:\n"
        + "\n"
        + "\n"
        + "Input: root = [5,3,6,2,4,null,null,1], k = 3\n"
        + "Output: 3";
  }
}
