package com.practise.goldman_problems.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //cover corner case, if only one elemeent return zeor
        if (height.length < 2) {
            return 0;
        }
        //use two pointer to move the heights, the difference in the length would be the width

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            maxArea = Math.max(currentArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }


        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] testSize = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(STR."max Area: {}\{test.maxArea(testSize)}");
    }
}
