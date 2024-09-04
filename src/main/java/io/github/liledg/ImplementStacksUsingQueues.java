package io.github.liledg;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStacksUsingQueues {

  static class MyStack {

    private int top;
    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public MyStack() {
      queue1 = new LinkedList<>();
      queue2 = new LinkedList<>();
    }

    public void push(int x) {
      queue1.add(x);
      top = x;
    }

    public int pop() {
      while(queue1.size()>1){
        top = queue1.remove();
        queue2.add(top);
      }
      int e = queue1.remove();
      while(!queue2.isEmpty()){
        queue1.add(queue2.remove());
      }
      return e;
    }

    public int top() {
      return top;
    }

    public boolean empty() {
      return queue1.isEmpty();
    }

  }

  public static void main(String[] args) {
    final MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    myStack.empty(); // return False

  }

}
