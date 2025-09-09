package com.practise.goldman_problems.medium;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //validate that each row and column should contain only 1 element.
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        int id = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] -1;
                id = (i / 3) * 3 + j / 3; //getting index of box
                if (rows[i][num] || cols[j][num] || box[id][num]) {
                    return false;
                }

                //mark as used
                rows[i][num] = true;
                cols[j][num] = true;
                box[id][num] = true;
            }
        }
        return true;
    }
}
