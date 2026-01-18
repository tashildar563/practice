package org.example.array.YEAR2025;

import org.example.Solution;
/**
 <p>Intuition</p>
       <p>This problem asks for the smallest subtree that contains all the deepest nodes. This is effectively finding the Lowest Common Ancestor (LCA) of all nodes at maximum depth.

       The core insight is to look at the height of the left and right subtrees for any given node:

       If the left subtree is deeper, the answer must lie somewhere inside the left subtree.

       If the right subtree is deeper, the answer must lie inside the right subtree.

       If both subtrees have the same depth, it means the deepest nodes are split between the left and right sides. Therefore, the current node is the lowest node that connects them all (the root of the smallest subtree).
        </p>
Approach
 We can solve this using a single-pass Depth First Search (DFS). We use a bottom-up approach (post-order traversal) where every node returns two values to its parent:

 Height: The maximum height (depth from bottom) of the tree rooted at that node.

 LCA Node: The root of the smallest subtree containing all deepest nodes found so far in that branch.

Algorithm:
 Base Case: If the node is None, return (0, None).

 Recursive Step: Call DFS on left and right children.

Compare:

 If left_height > right_height: The deepest nodes are on the left. We propagate the left_height + 1 and the left_node (the answer found deeper in the left branch).

 If right_height > left_height: The deepest nodes are on the right. We propagate right_height + 1 and the right_node.

 If left_height == right_height: The deepest nodes are balanced on both sides. The current node is the new LCA. We return left_height + 1 and current_node.
Complexity
 Time complexity: O(N)
 We traverse every node in the tree exactly once.

Space complexity: O(H)
This is required for the recursion stack, where His the height of the tree. In the worst case (skewed tree), this isO(N)

Visual Trace
Let's trace this code on a simple tree:

  1
 / \
2   3
/\
4 5
Goal: Find the subtree with all deepest nodes (4 and 5).

Step 1: Leaves (4 and 5)

Node 4 calls DFS on null children. Both return (0, None).

4 sees a Tie (0 == 0). It returns (1, Node 4).
Node 5 calls DFS on null children. Both return (0, None).

5 sees a Tie (0 == 0). It returns (1, Node 5).
Step 2: Node 2 (The Parent of 4 and 5)

Receives from Left (4): (1, Node 4)

Receives from Right (5): (1, Node 5)

Comparison: Left Height (1) == Right Height (1).

Logic: It's a Tie! This means Node 2 connects the deepest nodes on the left and right.

Returns: (2, Node 2) (Height increments to 2, Node 2 becomes the LCA).

Step 3: Node 3 (Leaf on the right)

Calls DFS on null children.

Returns (1, Node 3).

Step 4: Root Node 1

Receives from Left (2): (2, Node 2) <-- Deeper!

Receives from Right (3): (1, Node 3)

Comparison: Left Height (2) > Right Height (1).

Logic: The left side wins. The deepest nodes are strictly on the left side. The specific answer found down there was Node 2.

Action: Don't change the node. Pass Node 2 up.

Returns: (3, Node 2).

Final Answer: Node 2.*/
public class SmallestSubtreewithalltheDeepestNodes implements Solution {

  TreeNode result;

  @Override
  public void logic() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    TreeNode node = dfs(root).node;
  }

  private Result dfs(TreeNode node) {
    if (node == null) {
      return new Result(0, null);
    }
    Result left = dfs(node.left);
    Result right = dfs(node.right);

    if (left.height > right.height) {
      return new Result(left.height + 1, left.node);
    } else if (left.height < right.height) {
      return new Result(right.height + 1, right.node);
    } else {
      return new Result(left.height + 1, node);
    }
  }

  public void treeLength(TreeNode root, int length, Level lvl, boolean isLeft) {
    if (root == null) {
      return;
    }
    if (!isLeft && root.left == null && root.right == null && length > lvl.maxLevel) {
      result = root;
      lvl.maxLevel = length;
    }
    treeLength(root.left, length + 1, lvl, true);
    treeLength(root.right, length + 1, lvl, false);
  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }


  class Result {

    int height;
    TreeNode node;

    Result(int h, TreeNode n) {
      height = h;
      node = n;
    }
  }

  class Level {

    int maxLevel = 0;
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
