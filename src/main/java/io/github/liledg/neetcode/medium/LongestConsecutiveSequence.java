package io.github.liledg.neetcode.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements.
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
 * You must write an algorithm that runs in O(n) time.
 */

public class LongestConsecutiveSequence {

  public static int longestConsecutive(int[] nums) {
    final Set<Integer> numberSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int maxConsecutiveSequence = 0;

    for (int num : nums) {
      if (numberSet.contains(num - 1)) { //not a start of a sequence since there exists an element before it
        continue;
      }

      int n = num + 1;
      int sequenceLength = 1;
      while (numberSet.contains(n)) {
        sequenceLength++;
        n++;
      }

      if (sequenceLength > maxConsecutiveSequence) {
        maxConsecutiveSequence = sequenceLength;
      }
    }

    return maxConsecutiveSequence;
  }

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[]{0,3,2,5,4,6,1,1}));
  }

}
