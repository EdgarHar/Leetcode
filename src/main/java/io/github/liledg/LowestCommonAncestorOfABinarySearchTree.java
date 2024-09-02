package io.github.liledg;

import java.util.Stack;

public class LowestCommonAncestorOfABinarySearchTree {

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    final Stack<TreeNode> firstStack = new Stack<>();
    final Stack<TreeNode> secondStack = new Stack<>();

    traverse(root, p, firstStack);
    traverse(root, q, secondStack);

    //taking lower node and coming up from there, when the stacks are equal, we know they are on the same level and can start popping together
    while(secondStack.size() > firstStack.size()) {
      if (secondStack.pop().equals(firstStack.peek())) {
        return firstStack.peek();
      }
    }
    while(secondStack.size() < firstStack.size()) {
      if (firstStack.pop().equals(secondStack.peek())) {
        return secondStack.peek();
      }
    }
    while (!firstStack.peek().equals(secondStack.peek())) {
      firstStack.pop();
      secondStack.pop();
    }

    return firstStack.peek();
  }

  public static TreeNode lowestCommonAncestorSimpler(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (root.val > p.val && root.val > q.val) {
        root = root.left;
      } else if (root.val < p.val && root.val < q.val) {
        root = root.right;
      } else {
        return root;
      }
    }

    return null;
  }

  public static void traverse(final TreeNode current, final TreeNode destination, final Stack<TreeNode> trace) {
    trace.push(current);
    if (current.val == destination.val) {
      return;
    } else if (destination.val > current.val) {
      traverse(current.right, destination, trace);
    } else {
      traverse(current.left, destination, trace);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    TreeNode p = new TreeNode(0);
    TreeNode q = new TreeNode(5);

    root.left = new TreeNode(2);
    root.left.left = p;
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = q;

    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    System.out.println(lowestCommonAncestor(root, p, q).val);
    System.out.println(lowestCommonAncestorSimpler(root, p, q).val);
  }

  public static class TreeNode {

    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

  }

}
