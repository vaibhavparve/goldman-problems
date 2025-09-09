package com.practise.goldman_problems.hard;

import java.util.Arrays;

public class AllocateMailboxes {

    /*
    Topic -DP
    Given the array houses where houses[i] is the location of the ith house along a street and an integer k, allocate k mailboxes in the street.
    Return the minimum total distance between each house and its nearest mailbox.
    The test cases are generated so that the answer fits in a 32-bit integer.

    Constraints:
    1 <= k <= houses.length <= 100
    1 <= houses[i] <= 104
    All the integers of houses are unique.
    */

    public int minDistance(int[] houses, int k) {
        int n = houses.length;

        // Sort houses by position
        Arrays.sort(houses);

        // Precompute costs for placing one mailbox for houses[i...j]
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Optimal position for one mailbox is the median of houses[i...j]
                int median = houses[(i + j) / 2];

                // Calculate total distance from all houses in range [i,j] to the median
                // l iterates through ALL houses in the current range [i,j]
                for (int l = i; l <= j; l++) {
                    cost[i][j] += Math.abs(houses[l] - median);
                }
            }
        }

        // dp[i][j] = minimum cost to allocate j mailboxes to first i houses
        int[][] dp = new int[n + 1][k + 1];

        // Initialize with maximum values
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: 0 houses need 0 cost
        dp[0][0] = 0;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1) {
                    // One mailbox for all houses from 1 to i
                    dp[i][j] = cost[0][i - 1];
                } else {
                    // Try all possible positions for the j-th mailbox
                    for (int l = j - 1; l < i; l++) {
                        if (dp[l][j - 1] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j],
                                    dp[l][j - 1] + cost[l][i - 1]);
                        }
                    }
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        AllocateMailboxes test = new AllocateMailboxes();
        // Test case 1
        int[] houses1 = {1, 4, 8, 10, 20};
        int k1 = 3;
        System.out.println(STR."Test 1 - Houses: \{Arrays.toString(houses1)}, k=\{k1} -> \{test.minDistance(houses1, k1)}");
    }
}
