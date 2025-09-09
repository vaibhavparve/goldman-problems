package com.practise.goldman_problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollEnvelopes {
    /*
    You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
    One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
    Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
    Note: You cannot rotate an envelope.

    Example 1:

    Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
    Output: 3
    Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

    Example 2:
    Input: envelopes = [[1,1],[1,1],[1,1]]
    Output: 1
    */

    public int maxEnvelopes(int[][] envelopes) {
        //fails with timeout this is intuitive solution
        int max = 1;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);  //fill all the values to the envelopes a doll can store equals 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //cause we know at this point that dp[0] can fit in dp[1]
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxEnvelopesOptimized(int[][] envelopes) {
        //fails with timeout this is intuitive solution
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;

        int[] heights = new int[n]; // get all the heights to get the Longest increasing subsequence(LIS)

        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }

        List<Integer> lis = new ArrayList<>();

        for (int h : heights) {
            int id = Collections.binarySearch(lis, h); //returns the insertion point

            if (id < 0) { // if height not foudn in LIS
                //then add it
                id = -(id + 1);
            }

            if (id == lis.size()) {
                lis.add(h);
            } else {
                lis.set(id, h);
            }
        }

        return lis.size();
    }

    public static void main(String[] args) {
        //[[4,5],[4,6],[6,7],[2,3],[1,1]]
      //  int[][] trip = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] trip = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        RussianDollEnvelopes test = new RussianDollEnvelopes();

        System.out.println(STR."max: \{test.maxEnvelopesOptimized(trip)}");
    }
}
