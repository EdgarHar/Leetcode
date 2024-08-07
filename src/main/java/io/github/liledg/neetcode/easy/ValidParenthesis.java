package io.github.liledg.neetcode.easy;

import java.util.Stack;

public class ValidParenthesis {

  public static boolean isValid(String s) {
    final Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else if (stack.isEmpty() || c != stack.pop()) {
        return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("([{}])"));
  }

}
