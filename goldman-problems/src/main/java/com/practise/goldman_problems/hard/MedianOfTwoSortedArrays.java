package com.practise.goldman_problems.hard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    /*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        int[] sortedArrays = new int[nums1.length + nums2.length]; // merged array capacity

        //add elements of first array
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            sortedArrays[index++] = nums1[i];
        }

        //add elements of 2nd array
        for (int i = 0; i < nums2.length; i++) {
            sortedArrays[index++] = nums2[i];
        }

        Arrays.sort(sortedArrays);
        int length = sortedArrays.length;
        if (length % 2 == 1) { //if the array length is odd [1,3,7,8,10]
            median = sortedArrays[length / 2];
        } else {
            int mid1 = sortedArrays[(length / 2) - 1];
            int mid2 = sortedArrays[length / 2];
            median = (mid1 + mid2) / 2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};

        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        System.out.println(test.findMedianSortedArrays(arr1, arr2));
    }
}
