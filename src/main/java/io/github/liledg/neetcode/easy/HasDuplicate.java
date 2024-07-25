package io.github.liledg.neetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {

  public static boolean hasDuplicate(int[] nums) {
    final Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(hasDuplicate(new int[]{1, 2, 3, 1}));
  }
}
