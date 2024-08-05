package io.github.liledg.neetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * You are given a 9 x 9 Sudoku board. A Sudoku board is valid if the following rules are followed:
 *
 * Each row must contain the digits 1-9 without duplicates.
 * Each column must contain the digits 1-9 without duplicates.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
 * Return true if the Sudoku board is valid, otherwise return false
 */

public class ValidSudoku {

  private static class Pair {
    private Integer row;
    private Integer col;

    public Pair(Integer row, Integer col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      final Pair pair = (Pair) o;
      return Objects.equals(row, pair.row) && Objects.equals(col, pair.col);
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }
  }

  public static boolean isValidSudoku(char[][] board) {
    final Map<Integer, Set<Integer>> rowToColumnsMap = new HashMap<>();
    final Map<Integer, Set<Integer>> columnToRowsMap = new HashMap<>();
    final Map<Pair, Set<Integer>> boxNumberToElementsMap = new HashMap<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == '.') {
          continue;
        }

        if (!(rowToColumnsMap.computeIfAbsent(i, HashSet::new).add(Character.getNumericValue(board[i][j])) &&
        columnToRowsMap.computeIfAbsent(j, HashSet::new).add(Character.getNumericValue(board[i][j])) &&
        boxNumberToElementsMap.computeIfAbsent(new Pair(i / 3, j / 3), k -> new HashSet<>())
                              .add(Character.getNumericValue(board[i][j])))) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValidSudoku(new char[][]{
        {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
        {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
        {'.', '.', '.', '.', '8', '.', '.', '0', '9'}
    }));
  }

}
