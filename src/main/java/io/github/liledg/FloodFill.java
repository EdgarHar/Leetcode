package io.github.liledg;

import io.github.liledg.common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloodFill {

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    fill(image, sr, sc, color, image[sr][sc], new boolean[image.length][image[0].length]);

    return image;
  }

  public static void fill(int[][] image, int sr, int sc, int color, int sourceColor, boolean[][] visited) {
    final List<Pair> eligibleCells = new ArrayList<>();

    eligibleCells.add(new Pair(sr, sc));
    eligibleCells.add(new Pair(sr, sc - 1));
    eligibleCells.add(new Pair(sr, sc + 1));
    eligibleCells.add(new Pair(sr - 1, sc));
    eligibleCells.add(new Pair(sr + 1, sc));

    final List<Pair> list = eligibleCells
        .stream()
        .filter(pair -> (pair.getRow() >= 0 && pair.getRow() < image.length) &&
                             (pair.getCol() >= 0 && pair.getCol() < image[0].length))
        .filter(pair -> !visited[pair.getRow()][pair.getCol()])
        .filter(pair -> image[pair.getRow()][pair.getCol()] == sourceColor)
        .toList();

    list
        .forEach(pair -> {
          visited[pair.getRow()][pair.getCol()] = true;
          image[pair.getRow()][pair.getCol()] = color;
          fill(image, pair.getRow(), pair.getCol(), color, sourceColor, visited);
        });
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(floodFill(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
//    System.out.println(Arrays.deepToString(floodFill(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0, 0, 0)));
  }

}
