package com.practise.goldman_problems.topic.arrays.medium;

public class MaximumSubarray {


    /*
    Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 2
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

    * # **Step-by-Step Process of Kadane's Algorithm**

      Here's a step-by-step breakdown of how Kadane's Algorithm works:

    - Initialize two variables, max_so_far and max_ending_here, to 0.
    - Iterate through the array from left to right, examining each element one by one.
    - For each element, update max_ending_here as the maximum value is either the current element or the sum of the current element and max_ending_here.
    - Update max_so_far as the maximum of either the current max_so_far or max_ending_here.
    - Repeat steps 3 and 4 for all elements in the array.
    - The value of max_so_far at the end of the iteration will be the maximum subarray sum.
    *
    *
    * */

    public int MaximumSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //handle base conditions
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]); // if sum so far is less than current element start a new array

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main() {
        MaximumSubarray test = new MaximumSubarray();
        int[] input = {2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test.MaximumSubArray(input));
    }
}

