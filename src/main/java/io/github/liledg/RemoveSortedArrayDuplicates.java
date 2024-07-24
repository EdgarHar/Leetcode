package io.github.liledg;

public class RemoveSortedArrayDuplicates {

  /**
   * We use two pointers, k is used as a pointer to where a new unique element will be present.
   * and we traverse the array, when we find an element that is not equal to the k-th index, means we found new
   * element, and we replace it with k index and increment it.
   */

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int k = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[k] = nums[i];
        k++;
      }
    }

    return k;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }

}
