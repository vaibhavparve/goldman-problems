package com.practise.goldman_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /*
    *
    * Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
*
* */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        //first row will always be 1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            //add first element
            currentRow.add(1);

            //add middle element
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1);
            //add last element
            triangle.add(currentRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();

        System.out.println("test triangle for the rows : {} " + test.generate(5));
    }
}
