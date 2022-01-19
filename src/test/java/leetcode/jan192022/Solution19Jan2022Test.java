package leetcode.jan192022;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution19Jan2022Test {
  @Test
  public void testCase_1(){
    int[] nums = new int[]{1,2,3,1};
    int k = 3;
    assertTrue(new Solution19Jan2022().containsNearbyDuplicate(nums, k));
  }

  @Test
  public void testCase_2(){
    int[] nums = new int[]{1,0,1,1};
    int k = 1;
    assertTrue(new Solution19Jan2022().containsNearbyDuplicate(nums, k));
  }

  @Test
  public void testCase_3(){
    int[] nums = new int[]{1,2,3,1,2,3};
    int k = 2;
    assertFalse(new Solution19Jan2022().containsNearbyDuplicate(nums, k));
  }

  @Test
  public void canFindDuplicatesInWholeArray(){
    int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1};
    assertTrue(Solution19Jan2022.containsDuplicateInRange(nums, 0, nums.length));
  }

  @Test
  public void canFindDuplicatesInSubArray(){
    int[] nums = new int[]{1,2,3,4,4,5,6,7,8,9,10,1};
    assertTrue(Solution19Jan2022.containsDuplicateInRange(nums, 0, 5));
  }
}