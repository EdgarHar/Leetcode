package io.github.liledg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> integerToIndexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (integerToIndexMap.containsKey(target - nums[i])) {
        return new int[] {integerToIndexMap.get(target - nums[i]), i};
      }
      integerToIndexMap.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
  }

}
