package io.github.liledg;

import java.util.Arrays;

public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    final StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < strs[0].length(); i++) {
      boolean addValue = true;
      for (int j = 1; j < strs.length; j++) {
        try {
          if (strs[j].charAt(i) != strs[0].charAt(i)) {
            addValue = false;
            break;
        }
      } catch (StringIndexOutOfBoundsException e) {
          return prefix.toString();
        }
      }
      if (addValue) {
        prefix.append(strs[0].charAt(i));
      } else {
        return prefix.toString();
      }
    }

    return prefix.toString();
  }

  public static String longestCommonPrefixBetterSolution(String[] strs) {
    Arrays.sort(strs);
    final String s1 = strs[0];
    final String s2 = strs[strs.length-1];
    int index = 0;

    while(index < s1.length() && index < s2.length()){
      if(s1.charAt(index) == s2.charAt(index)){
        index++;
      } else {
        break;
      }
    }
    
    return s1.substring(0, index);
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefixBetterSolution(new String[]{"ab", "a"}));
  }

}
