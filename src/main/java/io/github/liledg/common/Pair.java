package io.github.liledg.common;

import java.util.Objects;

public class Pair {

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

  public Integer getCol() {
    return col;
  }

  public Integer getRow() {
    return row;
  }

}

