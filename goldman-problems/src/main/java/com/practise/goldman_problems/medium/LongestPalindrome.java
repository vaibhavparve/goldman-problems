package com.practise.goldman_problems.medium;

public class LongestPalindrome {

    /*
    *
    * Given a string s, return the longest palindromic substring in s.
 Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
    *
    * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        //Method we can use here is finding the even legth palindromes and odd length palindromes and then comapre which one is higher

        for (int i = 0; i < n; i++) {
            // odd length palindrome (centre is single char)
            int len1 = expandAroundCentre(s, i, i);

            // even length palindrome (centre is single char)
            int len2 = expandAroundCentre(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2; //formula to calcuate the start
            }
        }
        return s.substring(start, start + maxLength);
    }

    private int expandAroundCentre(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { //babad consider index 1
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();

        System.out.println(test.longestPalindrome("racecar"));
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("abbc"));
    }
}
