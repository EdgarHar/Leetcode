package io.github.liledg.neetcode.medium;

import java.util.Arrays;

public class ProductExceptSelf {

  //O(n) without dividing and O(n) space
  public static int[] productExceptSelf(int[] nums) {
    final int[] prefix = new int[nums.length];
    final int[] postfix = new int[nums.length];
    final int[] output = new int[nums.length];
    Arrays.fill(prefix, 1);

    int result = 1;
    for (int i = 0; i < nums.length; i++) {
      result = result * nums[i];
      prefix[i] = result;
    }
    result = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result = result * nums[i];
      postfix[i] = result;
    }

    for (int i = 0; i < output.length; i++) {
      if (i == 0) {
        output[i] = postfix[i + 1];
        continue;
      }
      if (i == nums.length - 1) {
        output[i] = prefix[i - 1];
        continue;
      }

      output[i] = prefix[i - 1] * postfix[i + 1];
    }

    return output;
  }

  //O(n) without dividing and O(1) space
  public static int[] productExceptSelfNoAdditionalArray(int[] nums) {
    final int[] output = new int[nums.length];
    Arrays.fill(output, 1);

    int leftProduct = 1;
    for (int i = 0; i < nums.length; i++) {
      output[i] = leftProduct;
      leftProduct *= nums[i];
    }

    int rightProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      output[i] *= rightProduct;
      rightProduct *= nums[i];
    }

    return output;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[] {-1,0,1,2,3})));
    System.out.println(Arrays.toString(productExceptSelfNoAdditionalArray(new int[] {1,2,4,6})));
  }
}
