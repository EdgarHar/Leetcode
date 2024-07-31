package io.github.liledg.neetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {

  private static final char HASHTAG = '#';

  public static String encode(List<String> strs) {
    return strs
        .stream()
        .collect(StringBuilder::new, (builder, str) -> builder
            .append(str.length())
            .append(HASHTAG)
            .append(str), StringBuilder::append)
        .toString();
  }

  //O(N)
  public static List<String> decode(String str) {
    final List<String> result = new ArrayList<>();

    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != HASHTAG) {
        j++;
      }
      int length = Integer.parseInt(str.substring(i, j));

      i = j + length + 1;
      result.add(str.substring(j + 1, i));
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(decode(encode(List.of("Hello", "World", "ED#AR", "eru2r3u2r2"))));
  }

}
