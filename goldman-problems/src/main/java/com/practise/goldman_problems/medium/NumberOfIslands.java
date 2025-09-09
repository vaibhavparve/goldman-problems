package com.practise.goldman_problems.medium;
/*
* 1. basic solve using DFS, check all 4 directions instead of loops
* */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        //base case to cover
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';

        //check for land in all 4 direction
        dfs(grid, i + 1, j, rows, cols); //down
        dfs(grid, i - 1, j, rows, cols); //left
        dfs(grid, i, j + 1, rows, cols); //right
        dfs(grid, i, j - 1, rows, cols); //right
    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();

        char[][] test1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(test.numIslands(test1));
    }
}
