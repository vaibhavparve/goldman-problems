package com.practise.goldman_problems.medium;

import java.util.Arrays;

public class ValidTriangleNumber {


    /*
     * tip: 3 numbers are valid triangle numbers if a+b>c, a+c>b, b+c>a, sum of any two sides should be greater than third.
     * can be solved using two pointers and sorting why sort to redude the number of iterations.
     *
     *
     *
     * */
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        int count = 0;

        Arrays.sort(nums); //java.util.arrays - why sorting to moving the largest number to the end.

        for (int k = n - 1; k >= 2; k--) {
            //start from the right end and move towards left lets consider case of 2, 3, 4, 4, 5, 6
            int left = 0;
            int right = k - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    count = count + (right - left); // this case will be true for all the elements.
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber test = new ValidTriangleNumber();
        int[] nums = {2, 3, 4, 4};
        System.out.println(test.triangleNumber(nums));
    }
}
