package com.practise.capitalone;


/*
* Given a square n x n matrix of integers matrix, rotate it by 90 degrees clockwise.

You must rotate the matrix in-place. Do not allocate another 2D matrix and do the rotation.
*
* 1 2 3       7 4 1
* 4 5 6  -->  8 5 2
* 7 8 9       9 6 3
*/

public class RotateImage {

    public void rotate(int[][] matrix) {
        // we have to do transpose of the matrix first so basically turn rows to columns and vice versa.
        int n = matrix.length;
        //do transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { //tracing column
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        //reverse the matrix
        for(int i=0; i<n ;i++){
            int left =0;
            int right = n-1;

            while(left < right){
               int temp = matrix[i][left];
               matrix[i][left] = matrix[i][right];
               matrix[i][right] = temp;
               left++;
               right--;
            }
        }
    }


}
