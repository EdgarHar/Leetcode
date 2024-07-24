package io.github.liledg;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  private static final Map<String, Integer> romanToIntMap = new HashMap<>();

  public static int romanToInt(String s) {
    romanToIntMap.put("I", 1);
    romanToIntMap.put("V", 5);
    romanToIntMap.put("X", 10);
    romanToIntMap.put("L", 50);
    romanToIntMap.put("C", 100);
    romanToIntMap.put("D", 500);
    romanToIntMap.put("M", 1000);
    romanToIntMap.put("IV", 4);
    romanToIntMap.put("IX", 9);
    romanToIntMap.put("XL", 40);
    romanToIntMap.put("XC", 90);
    romanToIntMap.put("CD", 400);
    romanToIntMap.put("CM", 900);

    int sum = 0;
    String lastAccessed = "@";
    for (int i = s.length() - 1; i >= 0; i--) {
      if (romanToIntMap.containsKey(String.valueOf(s.charAt(i)).concat(lastAccessed))) {
        sum -= romanToIntMap.get(String.valueOf(s.charAt(i)));
      } else {
        sum += romanToIntMap.get(String.valueOf(s.charAt(i)));
      }

      lastAccessed = String.valueOf(s.charAt(i));
    }

    return sum;
  }

  public static int romanToIntOtherSolution(String s) {
    int result = 0;
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    for (int i = 0; i < s.length(); i++) {
      if (i == s.length() - 1) {
        result += map.get(s.charAt(i));
        return result;
      }
      if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
        result += map.get(s.charAt(i));
      } else {
        result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(romanToIntOtherSolution("MCMXCIV"));
  }

}
