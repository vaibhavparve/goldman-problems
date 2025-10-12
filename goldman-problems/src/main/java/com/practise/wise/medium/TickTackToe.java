package com.practise.wise.medium;

public class TickTackToe {
    //tick tack toe consider defining a board

    int[][] board;
    int n; //n number givn

    public void TicTacToe(int n) {
        board = new int[n][n]; //0 no winner 1 player 1 and 2 player 2
        this.n = n;
    }

    public int move(int row, int col, int player) {
        if (checkIfWin(row, col, player)) {
            return player;
        }
        return 0; //if no winner found
    }

    private boolean checkIfWin(int row, int col, int player) {
        //we have to validate 4 conditions
        // check all the rows if teh sum is equal to n then the plaer is winner
        //check if all the cols sum
        // chec diagonal and check anti-diagonal
        int rowCount = 0;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == player) {
                rowCount++;
            }
        }

        if (rowCount == n) {
            return true;
        }

        //check columns
        int colCount = 0;
        for (int j = 0; j < n; j++) {
            if (board[j][col] == player) {
                colCount++;
            }
        }

        if (colCount == n) {
            return true;
        }

        //it means this is a diagonal element, so check all diagonals
        if (row == col) {
            int diag = 0;
            for (int i = 0; i < n; i++) {
                if (board[i][i] == player) {
                    diag++;
                }
            }
            if (diag == n) {
                return true;
            }
        }

        //anti-diagonal
        if (row + col == n - 1) {
            int antiDiag = 0;
            for (int i = 0; i < n; i++) {
                if (board[row][n - 1 - i] == player) {
                    antiDiag++;
                }
            }
            if (antiDiag == n) {
                return true;
            }
        }

        return false;
    }
}
