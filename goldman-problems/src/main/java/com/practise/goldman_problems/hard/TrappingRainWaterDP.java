package com.practise.goldman_problems.hard;

public class TrappingRainWaterDP {

    //main idea here is water can only if trapped by low of heaight at left and right
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];

        //find left max
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //find right max
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water = water + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return water;
    }
}
