package io.github.liledg.neetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 * <p>
 * Example 1:
 * Input: n = 1
 * Output: ["()"]
 */

/**
 * Backtracking solution: There are two observations from the problem we need to know to start solving:
 * 1) The number of opening and closing brackets need to be the same for it to be valid
 * 2) At all times, the number of closing brackets SHOULD NOT be larger than the opening bracket count, as it if is,
 * it means that there is a closing bracket without a corresponding opening bracket, which is invalid.
 * For the solution, there are always two cases, if the number of open brackets is less than n, we are SURE that we
 * can add another open bracket, as it still has potential to be valid, if the number of closed brackets is less than
 * the number of open brackets, we add a closed bracket, and since the count of closing brackets do not surpass the
 * open bracket count, we know that this is still on its way to be a valid string. So for each string we generate, we
 * generate two more strings for it, one with incremented open bracket, another for incremented closed bracket. Hence
 * the solution is O(2^n).
 */
public class GenerateParenthesis {

  public static List<String> generateParenthesis(int n) {
    final List<String> result = new ArrayList<>();

    backtrack(result, new StringBuilder(), 0, 0, n);

    return result;
  }

  private static void backtrack(final List<String> result, final StringBuilder stringBuilder, final int openCount,
      final int closeCount, final int n) {
    if (closeCount == n && openCount == n) {
      result.add(stringBuilder.toString());
      return;
    }

    if (openCount < n) {
      backtrack(result, new StringBuilder(stringBuilder).append("("), openCount + 1, closeCount, n);
    }
    if (closeCount < openCount) {
      backtrack(result, new StringBuilder(stringBuilder).append(")"), openCount, closeCount + 1, n);
    }
  }

  public static void main(String[] args) {
    System.out.println(generateParenthesis(1000));
  }

}
