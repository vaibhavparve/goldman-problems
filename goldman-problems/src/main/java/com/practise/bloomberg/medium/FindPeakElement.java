package com.practise.bloomberg.medium;

public class FindPeakElement {

    /*
     * linear solution for this is very easy just comapre the left and right and move through the array and you
     * will get the result
     *
     * to solve this for complexity of O(n log n) we have to use binary search tree
     * */

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        //edge cases for first element
        if (nums[1] > nums[0]) {
            return 0; //first element is peak
        }

        //last element only have to check if its greater than the last -1
        if (nums[len - 1] > nums[len - 2]) {
            return nums[len - 1];
        }

        //for all others
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // this condition signifies that we are already meeting one condition needed for peak
            //1,2,7,5,6,4
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
