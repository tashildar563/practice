package org.example.tree;

import java.util.ArrayList;
import org.example.Solution;

public class BreadthFirstSearchTraversal implements Solution {

  @Override
  public void logic() {
    TreeNode binaryTree = new TreeNode(1);
    binaryTree.left = new TreeNode(2);
    binaryTree.right = new TreeNode(5);
    binaryTree.left.left = new TreeNode(3);
    binaryTree.left.right = new TreeNode(4);
    binaryTree.right.left = new TreeNode(6);
    binaryTree.right.right = new TreeNode(7);


    levelOrder(binaryTree);
  }

  private void levelOrder(TreeNode binaryTree) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    levelOrderRec(binaryTree,0,res);

    for (ArrayList<Integer> level : res) {
      for (int val : level) {
        System.out.print(val + " ");
      }
      System.out.println();
    }
  }

  private void levelOrderRec(TreeNode binaryTree, int level, ArrayList<ArrayList<Integer>> res) {
    if(binaryTree==null) return;

    if(res.size() <= level){
      res.add(new ArrayList<>());
    }

    res.get(level).add(binaryTree.data);
    levelOrderRec(binaryTree.left,level+1, res);
    levelOrderRec(binaryTree.right,level+1,res);
  }

  @Override
  public String description() {
    return "41";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
