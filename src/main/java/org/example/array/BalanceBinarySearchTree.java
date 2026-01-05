package org.example.array;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.List;
import org.example.Solution;

public class BalanceBinarySearchTree implements Solution {
  class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
      this.data = data;
    }
  }

  @Override
  public void logic() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    treeNode.right.right = new TreeNode(3);
    treeNode.right.right.right = new TreeNode(4);

    inorderTraversal(treeNode);
    TreeNode balancedTreeNode = sortedArrayToBST(0,sortArr.size()-1);

    printTreeNode(balancedTreeNode);

  }

  private void printTreeNode(TreeNode treeNode) {
    if(treeNode == null) {
      System.out.print(" ");
      return;}
    printTreeNode(treeNode.left);
    System.out.println(">> "+treeNode.data);
    printTreeNode(treeNode.right);
  }

  private TreeNode sortedArrayToBST(int start, int end) {
    if(start>end) return null;
    int mid = (start+end)/2;
    TreeNode root = sortArr.get(mid);
    root.left = sortedArrayToBST(start,mid-1);
    root.right =sortedArrayToBST(mid+1,end);
    return root;
  }

  List<TreeNode> sortArr = new ArrayList<>();
  private void inorderTraversal(TreeNode treeNode) {
    if(treeNode == null) return;
    inorderTraversal(treeNode.left);
    sortArr.add(treeNode);
    inorderTraversal(treeNode.right);
  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
