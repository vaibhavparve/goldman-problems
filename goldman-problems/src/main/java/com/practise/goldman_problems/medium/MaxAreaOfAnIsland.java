package com.practise.goldman_problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxAreaOfAnIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; //if nothing found return zero
        Map<Integer, Integer> islandArea = new HashMap<>();

        int rows = grid.length;
        int cols = grid[0].length;
        int islandNumber = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                islandNumber++;
                islandArea.put(islandNumber, 0); //very important
                dfs(grid, i, j, rows, cols, islandNumber, islandArea);
            }
        }

        if (!islandArea.isEmpty()) {
            Set<Map.Entry<Integer, Integer>> entries =
                    islandArea.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                maxArea = Math.max(maxArea, entry.getValue());
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j, int rows, int cols, int islandNumber, Map<Integer, Integer> islandArea) {

        if (i >= rows || i < 0 || j < 0 || j >= cols || grid[i][j] == 0) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0; //mark island as visited

            if (islandArea.containsKey(islandNumber)) {
                islandArea.put(islandNumber, islandArea.get(islandNumber) + 1);
            }
        }

        //call dfs for all 4 directions

        dfs(grid, i + 1, j, rows, cols, islandNumber, islandArea); //down
        dfs(grid, i - 1, j, rows, cols, islandNumber, islandArea); // up
        dfs(grid, i, j + 1, rows, cols, islandNumber, islandArea); //right
        dfs(grid, i, j - 1, rows, cols, islandNumber, islandArea); //left
    }

    public static void main(String[] args) {
        MaxAreaOfAnIsland test = new MaxAreaOfAnIsland();

        int[][] test1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(test.maxAreaOfIsland(test1));
    }
}
