package io.github.liledg;

public class SearchInsertPosition {

  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

  public static int searchInsertRecursion(int[] nums, int target) {
    return searchInsertRecursion(nums, target, 0 , nums.length - 1);
  }

  private static int searchInsertRecursion(int[] nums, int target, int left, int right) {
    if (left > right) {
      return left;
    }

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
      return mid;
    }
    if (nums[mid] < target) {
      return searchInsertRecursion(nums, target, mid + 1, right);
    } else {
      return searchInsertRecursion(nums, target, left, mid - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[]{1, 2, 5, 6}, 8));
    System.out.println(searchInsertRecursion(new int[]{1, 2, 5, 6, 10}, 5));
  }

}
