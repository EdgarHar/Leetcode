package io.github.liledg;

import java.util.Stack;

public class ValidParentheses {

  public static boolean isValidParentheses(String s) {
    final Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValidParentheses("()[[{]}"));
  }

}
