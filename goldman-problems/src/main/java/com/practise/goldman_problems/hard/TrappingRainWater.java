package com.practise.goldman_problems.hard;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105*/
public class TrappingRainWater {
    //below is bruteforce and it will fail for larger solutions.
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;

        if (height == null || n <= 2) {
            return 0;
        }

        for (int i = 1; i < n - 1; i++) {
            // find left max for each position
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            //find right max for each position
            int rightMax = 0;
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            //water level at position i, is min(leftMax, rightMax)
            int waterLevel = Math.min(leftMax, rightMax);

            //if water level is greater than current height, we can trap the water.
            if (waterLevel > height[i]) {
                totalWater = totalWater + (waterLevel - height[i]);
            }

        }
        return totalWater;
    }

    public int trapUsingTwoPointer(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        // Only 20,000 operations total
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();

        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        System.out.println(test.trap(height));
    }
}
