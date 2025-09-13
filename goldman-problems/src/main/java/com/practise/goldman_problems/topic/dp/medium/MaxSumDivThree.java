package com.practise.goldman_problems.topic.dp.medium;

public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        // this is mainly derived from math idea of if (a+b)%3 == ((a%3)+(b%3))%3;
        //base condition if the num.size==1 and if its divisible by 3 return first element
        if (nums.length == 1) {
            if (nums[0] % 3 == 0) {
                return nums[0];
            }
        }

        int[] dp = new int[3]; //to track sum for each reminder 0, 1, 2
        //for each element
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] temp = dp.clone(); // to maintain the current state

            for (int j = 0; j < 2; j++) {
                int currentSum = temp[j]; //sum from last iteration
                int newSum = currentSum + num;
                int newReminder = newSum % 3;

                if (newSum > dp[newReminder]) {
                    dp[newReminder] = newSum;
                }
            }
        }
        return dp[0];
    }
}
