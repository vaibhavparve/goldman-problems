package com.practise.capitalone;

public class CountMatchingSubArrays {


    //solution is find trend first and then pattern on the trend
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length; //pattern length

        //if pattern is longer than array its not possible
        if (m >= n) {
            return 0;
        }
        int[] trends = new int[n - 1]; //find the trends
        //find the trends
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                trends[i] = 1;
            }

            else if (nums[i + 1] == nums[i]) {
                trends[i] = 0;
            } else {
                trends[i] = -1;
            }
        }

        int count = 0;

        for (int i = 0; i <= trends.length - m; i++) {
            if (matchesAt(trends, pattern, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean matchesAt(int[] trend, int[] pattern, int start) {
        for (int i = 0; i < pattern.length; i++) {
            if (trend[start + i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
}
