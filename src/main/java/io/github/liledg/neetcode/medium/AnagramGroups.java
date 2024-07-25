package io.github.liledg.neetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroups {

  /**
   * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
   * An anagram is a string that contains the exact same characters as another string, but the order of the characters
   * can be different.
   *
   * @param strs
   *     = ["act","pots","tops","cat","stop","hat"]
   *
   * @return [["hat"],["act", "cat"],["stop", "pots", "tops"]]
   */
  public static List<List<String>> groupAnagrams(String[] strs) {
    final Map<String, List<String>> sortedAnagramToWordMap = new HashMap<>();
    Arrays.stream(strs).forEach(s -> {
      final String sorted = s
          .chars()
          .sorted()
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

      sortedAnagramToWordMap
          .computeIfAbsent(sorted, k -> new ArrayList<>())
          .add(s);
    });

    return sortedAnagramToWordMap
        .values()
        .stream()
        .toList();
  }

  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[] {"act", "pots", "tops", "cat", "stop", "hat"}));
  }

}
