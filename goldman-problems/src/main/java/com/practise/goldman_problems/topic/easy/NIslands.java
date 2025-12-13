package com.practise.goldman_problems.topic.easy;

public class NIslands {
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
        if (i <= 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
        //mark as visited
        grid[i][j] = '0';

        //check for land all directions
        dfs(grid, i + 1, j, rows, cols); //down
        dfs(grid, i - 1, j, rows, cols); //up
        dfs(grid, i, j + 1, rows, cols); //right
        dfs(grid, i, j - 1, rows, cols); //
    }

}
