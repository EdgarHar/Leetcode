package io.github.liledg.neetcode.medium;

import java.util.Stack;

/**
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * 1) MinStack() initializes the stack object.
 * 2) void push(int val) pushes the element val onto the stack.
 * 3) void pop() removes the element on the top of the stack.
 * 4) int top() gets the top element of the stack.
 * 5) int getMin() retrieves the minimum element in the stack.
 * Each function should run in O(1) time.
 */

public class MinStack {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    if (minStack.isEmpty() || val < minStack.peek()) {
      stack.push(val);
      minStack.push(val);
    } else {
      stack.push(val);
      minStack.push(minStack.peek());
    }
  }

  public void pop() {
    minStack.pop();
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) {

  }

}
