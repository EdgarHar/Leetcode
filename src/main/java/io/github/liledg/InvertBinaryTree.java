package io.github.liledg;

public class InvertBinaryTree {

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    final TreeNode left = invertTree(root.left);

    root.left = invertTree(root.right);
    root.right = left;

    return root;
  }

  public static void main(String[] args) {

  }

  public static class TreeNode {
    int      val;
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
