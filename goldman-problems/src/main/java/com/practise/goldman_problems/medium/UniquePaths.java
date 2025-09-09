package com.practise.goldman_problems.medium;

public class UniquePaths {
    /*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
     The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    The test cases are generated so that the answer will be less than or equal to 2 * 109.*/

    public int uniquePaths(int m, int n) {
        //lets maintain a grid to keep the track of how many ways we can reach at that location
        int[][] grid = new int[m][n];

        //initialize grid to zero as number of paths
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
        //remember the fact that we can only travel in down or right direction not left so the first row would always
        // have cost of 1 and first column as well


        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;                 //there is only one path
        }

        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;                 //there is only one path to reach this
        }

        //calculate the number of paths we can reach for reamaining all nodes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(3, 7));
        System.out.println(test.uniquePaths(3, 2));
    }
}
