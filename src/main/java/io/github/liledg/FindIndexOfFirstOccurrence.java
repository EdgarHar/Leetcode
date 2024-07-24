package io.github.liledg;

public class FindIndexOfFirstOccurrence {

  //initial solution
  public static int strStr(String haystack, String needle) {
    int k = 0;
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.charAt(i) == needle.charAt(k)) {
        k++;
          for (int j = i + 1; j <= haystack.length(); j++) {
            if (k == needle.length()) {
              return i;
            }
            if (haystack.charAt(j) == needle.charAt(k)) {
              k++;
            } else {
              k = 0;
              break;
            }
          }
      }
    }

    return -1;
  }

  public static int strStrSlidingWindow(String haystack, String needle) {
    int hLen = haystack.length();
    int nLen = needle.length();
    int nIndex = 0;
    for (int i = 0; i < hLen; i++) {
      if (haystack.charAt(i) == needle.charAt(nIndex)) {
        nIndex++;
      } else {
        i = i - nIndex;
        nIndex = 0;
      }
      if (nIndex == nLen) {
        return i - nLen + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("mississippi", "issip"));
  }

}
