package com.practise.goldman_problems.medium;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudokuIntuitive {
    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidCol(board) && isValidBox(board);
    }

    private boolean isValidBox(char[][] board) {
        for (int box = 0; box < 9; box++) {
            char[] boxChars = new char[9];
            int id = 0;
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;

            for (int i = 0; i < startRow + 3; i++) {
                for (int j = 0; j < startCol + 3; j++) {
                    boxChars[id++] = board[i][j];
                }
            }
            if (!isValidUnit(boxChars)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board) {
        boolean result = false;
        for (int i = 0; i < 9; i++) {
            char[] cols = new char[9];
            for (int j = 0; j < 9; j++) {
                cols[i] = board[i][j];
            }
            if (!isValidUnit(cols)) {
                return false;
            }
        }
        return result;
    }

    private boolean isValidRow(char[][] board) {
        boolean result = false;
        for (int i = 0; i < 9; i++) {
            char[] rows = board[i]; //this gives the entire row and thts why we can use it here.
            result = isValidUnit(rows);
        }
        return result;
    }

    private boolean isValidUnit(char[] board) {
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (board[i] != '.' && !seen.add(board[i])) {
                return false;
            }
        }
        return true;
    }
}
