package io.github.liledg.neetcode.easy;

import java.util.Map;
import java.util.stream.Collectors;

public class IsAnagram {

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    final Map<Character, Long> frequencyOfS = s
        .chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    final Map<Character, Long> frequencyOfT = t
        .chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    for (Map.Entry<Character, Long> entry : frequencyOfS.entrySet()) {
      if (!(frequencyOfT.containsKey(entry.getKey()) && frequencyOfT.get(entry.getKey()).equals(entry.getValue()))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("racecar", "carjace"));
  }

}
