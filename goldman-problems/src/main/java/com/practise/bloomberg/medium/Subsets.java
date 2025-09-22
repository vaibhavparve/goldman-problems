package com.practise.bloomberg.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
    * */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> current, List<List<Integer>> result) {
        //add current element to the result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            System.out.println("before removing " + current+ "result " + result);
            current.removeLast(); //very important so we remove the last added elements once we process them in result so we can mvoe to the next iteration
            System.out.println("removing " + current+ "result " + result);

        }
    }

    static void main() {
        Subsets test = new Subsets();
        int[] test1 = {1,2,3};
        System.out.println(test.subsets(test1));
    }
}
