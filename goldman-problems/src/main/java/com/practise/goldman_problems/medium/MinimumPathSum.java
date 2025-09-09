package com.practise.goldman_problems.medium;

public class MinimumPathSum {

    /*solving using most intuitive solution would be
    *
    *
    *Core Algorithm Logic
Recurrence Relation:
javadp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
Intuition: At each cell, we can only arrive from the top or left. Choose the path with minimum cost so far, then add the current cell's value.
Step-by-Step Example
Grid:           DP Table:
[1, 3, 1]       [1, 4, 5]
[1, 5, 1]  →    [2, 7, 6]
[4, 2, 1]       [6, 8, 7]

Optimal path: 1→3→1→1→1 = 7
Key Insights

Base Cases: First row and column can only be reached one way
Optimal Substructure: Optimal path to (i,j) includes optimal path to either (i-1,j) or (i,j-1)
No Backtracking: We can only move right or down, making DP perfect for this problem
    *
    *
    *
    * */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n]; // define a dp array that will store the path sum to reach the element

        // we want to handle this in 3 steps 1. fill first row -- can only come from left
        // fill first column -- can only come from top
        //then fill remaining elements

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //fill remaining elements
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }
}
