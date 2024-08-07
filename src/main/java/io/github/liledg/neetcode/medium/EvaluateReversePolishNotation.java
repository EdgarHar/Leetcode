package io.github.liledg.neetcode.medium;

import java.util.Set;
import java.util.Stack;
import java.util.function.BinaryOperator;

/**
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 * <p>
 * Return the integer that represents the evaluation of the expression.
 * <p>
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * <p>
 * Input: tokens = ["1","2","+","3","*","4","-"]
 * Output: 5
 * Explanation: ((1 + 2) * 3) - 4 = 5
 */

public class EvaluateReversePolishNotation {

  private static final Set<String> operators = Set.of("+", "-", "*", "/");

  private static final BinaryOperator<Integer> addOperator      = Integer::sum;
  private static final BinaryOperator<Integer> subtractOperator = (integer, integer2) -> integer - integer2;
  private static final BinaryOperator<Integer> multiplyOperator = (integer, integer2) -> integer * integer2;
  private static final BinaryOperator<Integer> divideOperator   = (integer, integer2) -> integer / integer2;

  public static int evalRPNStack(String[] tokens) {
    final Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      if (!operators.contains(token)) {
        stack.push(Integer.parseInt(token));
      } else {
        int secondOperand = stack.pop();
        int firstOperand = stack.pop();
        stack.push(
            switch (token) {
              case "+" -> addOperator.apply(firstOperand, secondOperand);
              case "-" -> subtractOperator.apply(firstOperand, secondOperand);
              case "*" -> multiplyOperator.apply(firstOperand, secondOperand);
              case "/" -> divideOperator.apply(firstOperand, secondOperand);
              default -> throw new IllegalArgumentException("Unknown operator: " + token);
            }
        );
      }
    }

    return stack.pop();
  }

  public static void main(String[] args) {
    System.out.println(evalRPNStack(new String[] {"4", "13", "5", "/", "+"}));
  }

}
