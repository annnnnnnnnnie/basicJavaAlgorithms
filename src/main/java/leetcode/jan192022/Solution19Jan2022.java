package leetcode.jan192022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution19Jan2022 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (k + 1 >= nums.length) {
      return containsDuplicateInRange(nums, 0, nums.length);
    } else {
      Set<Integer> s = new HashSet<>(k + 1);
      for (int i = 0; i <= k; i++) {
        int num = nums[i];
        if (s.contains(num)) {
          return true;
        } else {
          s.add(nums[i]);
        }
      }
      for (int i = 0; i + k + 1 < nums.length; i++) {
        s.remove(nums[i]);
        if (s.contains(nums[i + k + 1])) {
          return true;
        } else {
          s.add(nums[i + k + 1]);
        }
      }
      return false;
    }
  }

  /**
   * Check if there is any duplicate int in nums in range [start, end)
   *
   * @param nums ints
   * @param start inclusive
   * @param end exclusive
   * @return true if there is at least one duplicate
   */
  public static boolean containsDuplicateInRange(int[] nums, int start, int end) {
    return containsDuplicateInRangeSetImplementation(nums, start, end);
  }

  // Overtime for large number of nums
  public static boolean containsDuplicateInRangeSetImplementation(int[] nums, int start, int end) {
    Set<Integer> s = new HashSet<>(end - start);
    for (int i = start; i < end; i++) {
      int num = nums[i];
      if (s.contains(num)) {
        return true;
      } else {
        s.add(nums[i]);
      }
    }
    return s.size() < end - start;
  }

  // Overtime for large number of nums
  public static boolean containsDuplicateInRangeStreamImplementation(
      int[] nums, int start, int end) {
    return end - start != Arrays.stream(nums).skip(start).limit(end - start).distinct().count();
  }
}
