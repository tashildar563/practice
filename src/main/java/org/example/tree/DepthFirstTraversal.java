package org.example.tree;

import com.sun.source.tree.Tree;
import org.example.Solution;

public class DepthFirstTraversal implements Solution {


  @Override
  public void logic() {
    TreeNode binaryTree = new TreeNode(1);
    addLeftTreeNode(binaryTree,2);
    addRightTreeNode(binaryTree,5);
    addRightTreeNode(binaryTree.left,4);
    addLeftTreeNode(binaryTree.left,3);
    System.out.println("DFS Preorder traversal");
    preOrder(binaryTree);
    
    System.out.println("DFS post order traversal");
    postOrder(binaryTree);
    System.out.println();
    System.out.println("DFS In order traversal");
    inOrder(binaryTree);

  }

  private void inOrder(TreeNode binaryTree) {
    if(binaryTree== null){
      System.out.println(" ");
      return;
    }
    inOrder(binaryTree.left);
    System.out.print(binaryTree.data+" -> ");
    inOrder(binaryTree.right);
  }

  private void postOrder(TreeNode binaryTree) {
    if(binaryTree==null){
      System.out.println(" ");
      return;
    }
    postOrder(binaryTree.left);
    postOrder(binaryTree.right);
    System.out.print(binaryTree.data + " -> ");
  }
  private void preOrder(TreeNode binaryTree) {
    if(binaryTree==null){
      System.out.println("");
      return;}
    System.out.print(binaryTree.data + " -> ");
    preOrder(binaryTree.left);
    preOrder(binaryTree.right);
  }

  private void addRightTreeNode(TreeNode binaryTree, int i) {
    if(binaryTree.right==null){
      binaryTree.right = new TreeNode(i);
      return;
    }
    addRightTreeNode(binaryTree.right,i);
  }

  private void addLeftTreeNode(TreeNode binaryTree, int i) {
    if(binaryTree.left==null){
      binaryTree.left = new TreeNode(i);
      return;
    }
      addLeftTreeNode(binaryTree.left,i);
  }

  @Override
  public String description() {
    return "40. ";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
