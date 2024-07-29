package io.github.liledg.neetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

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

  //O(MlogM * N)
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

  //O(M * N)
  public static List<List<String>> groupAnagrams2(String[] strs) {
    final Map<String, List<String>> sortedAnagramToWordMap = new HashMap<>();

    Arrays.stream(strs)
        .forEach(s -> {
          final List<Integer> countList = new ArrayList<>(Collections.nCopies(26, 0)); //number of letters in english

          s.chars()
           .forEach(c -> countList.set(c - 'a', countList.get(c - 'a') + 1));

          Optional.of(countList
              .stream()
              .collect(StringBuilder::new, (stringBuilder, integer) -> stringBuilder
                  .append("#")
                  .append(integer), StringBuilder::append))
              .map(StringBuilder::toString)
              .ifPresent(key -> sortedAnagramToWordMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s));
        });

    return sortedAnagramToWordMap
        .values()
        .stream()
        .toList();
  }

  public static void main(String[] args) {
    System.out.println(groupAnagrams2(new String[] {"act", "pots", "tops", "cat", "stop", "hat"}));
  }

}
