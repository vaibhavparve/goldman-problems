package com.practise.capitalone;

/*
*
* n array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
* An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

* Example 1:
Input: nums = [1,2,2,3]
Output: true
Example 2:*/
public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
      //only thing we want to check is whether it holds the pattern
      return isIncreasing(nums) || isDecreasing(nums);
    }

    private boolean isDecreasing(int[] nums) {
        for(int i =1; i< nums.length; i++){
            if(nums[i] > nums[i-1]){ // checking only false clause
                return false;
            }
        }
        return true;
    }

    private boolean isIncreasing(int[] nums) {
        for(int i =1; i< nums.length; i++){
            if(nums[i] < nums[i-1]){ // checking only false clause
                return false;
            }
        }
        return true;
    }
}
