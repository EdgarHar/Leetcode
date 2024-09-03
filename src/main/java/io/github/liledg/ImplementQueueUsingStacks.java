package io.github.liledg;

import java.util.Stack;

public class ImplementQueueUsingStacks {

  static class MyQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }

    public void push(int x) {
      stack1.push(x);
    }

    public int pop() {
      fillStack();
      return stack2.pop();
    }

    public int peek() {
      fillStack();
      return stack2.peek();
    }

    public boolean empty() {
      return stack1.isEmpty() && stack2.isEmpty();
    }

    private void fillStack() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
    }

  }

  public static void main(String[] args) {
    final MyQueue myQueue = new MyQueue();
  }

}
