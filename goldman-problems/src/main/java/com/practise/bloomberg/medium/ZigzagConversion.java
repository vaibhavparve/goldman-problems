package com.practise.bloomberg.medium;

public class ZigzagConversion {
/*


The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
"""
 */

    public String convert(String s, int numRows) {
        //corner case where length of string 1 or number of rows and length of string is same then its same string
        if (s.length() == 1 || s.length() == numRows || numRows == 1) {
            return s;
        }

        //crete an array of string builder for each row so we can append the the chars
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        //append all chars to rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c); // append each char to the existing string formed by the chars

            if (currentRow == 0 || currentRow == (numRows - 1)) {
                goingDown = !goingDown;
            }
            currentRow = currentRow + ((goingDown) ? 1 : -1);
        }

        //return the result as rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    static void main() {
        ZigzagConversion test = new ZigzagConversion();
        System.out.println(test.convert("PAYPALISHIRING", 4));
        System.out.println(test.convert("AB", 1));
    }
}
