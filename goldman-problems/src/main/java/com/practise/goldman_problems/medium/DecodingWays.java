package com.practise.goldman_problems.medium;

public class DecodingWays {

    /*You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.*/

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        //this is problme of dynamic programming we want to check if we can for single and double digits for a given position

        int[] dp = new int[n + 1]; //to store possible combinations
        dp[0] = 1; //empty space is also 1
        dp[1] = 1; //first character would alawys have 1

        for (int i = 2; i < n; i++) {

            //single digit check
            int singleDigit = Integer.parseInt(s.substring(i - 1, i));
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] = dp[i] + dp[i - 1];
            }
            //double digit check
            int doubleDigit = Integer.parseInt(s.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodingWays test = new DecodingWays();
        System.out.printf("number of ways: %d%n", test.numDecodings("12"));
    }
}
