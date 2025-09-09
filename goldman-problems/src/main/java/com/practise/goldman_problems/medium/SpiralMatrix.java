package com.practise.goldman_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
     * /*
STEP-BY-STEP WALKTHROUGH (3x3 matrix):

Matrix:     Boundaries:      Traversal:
[1 2 3]     top=0, bottom=2  1. Right: [1,2,3] → top=1
[4 5 6]     left=0, right=2  2. Down:  [6,9]   → right=1
[7 8 9]                      3. Left:  [8,7]   → bottom=1
                             4. Up:    [4]     → left=1
                             5. Right: [5]     → complete

Result: [1, 2, 3, 6, 9, 8, 7, 4, 5]

BOUNDARY UPDATES:
- After right: top++   (exclude processed top row)
- After down:  right-- (exclude processed right column)
- After left:  bottom--(exclude processed bottom row)
- After up:    left++  (exclude processed left column)

The key insight is checking if top <= bottom before left traversal
and left <= right before up traversal to avoid duplicate elements
in single row/column scenarios.
     *
     *
     * */


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //handling null condition or empty array condition
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        // lets maintain the directional boundries
        int m = matrix.length; //number of rows
        int n = matrix[0].length; // number of cols

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            //traverse top rows from left to right unitl you reach the right corner
            for (int i = top; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // so this will move to next row in next iteration

            // now lets focus on traversing the last row from top to bottom

            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--; // so this will move right column one line closer to left

            if (top <= bottom) { //traverse from bottom right to left in the last line
                for (int k = right; k >= left; k--) {
                    result.add(matrix[bottom][k]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int l = bottom; l >= top; l--) {
                    result.add(matrix[l][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {1, 2, 3, 4, 5},
                {20, 19, 18, 17, 6},
                {13, 14, 15, 16, 7},
                {12, 11, 10, 9, 8}
        };

        SpiralMatrix test = new SpiralMatrix();

        System.out.println(test.spiralOrder(test1));
    }
}
