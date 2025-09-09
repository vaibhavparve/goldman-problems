package com.practise.goldman_problems.hard;

import java.util.Arrays;

public class AllocateMailboxesWithHelper {

    int n;
    Integer[][][] mem;

    public int minDistance(int[] houses, int k) {
        n = houses.length;
        mem = new Integer[n][n][k + 1]; //we want use index 1 for hosue 1

        // intiialize cost with -1 for all the houses
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }

        return minDistanceHelper(houses, 0, n - 1, k);
    }

    private int minDistanceHelper(int[] houses, int start, int end, int k) {
        int result = Integer.MAX_VALUE;
        if (start == n) {
            return 0;
        }

        //if we reached this element before we want ot reuse
        if (mem[start][end][k] != -1) {
            return mem[start][end][k];
        }

        if (k == 1) {
            mem[start][end][k] = getMinDistance(houses, start, end);
            return mem[start][end][k];
        }

        for (int endOne = start; endOne <= end; endOne++) {
            int dist = getMinDistance(houses, start, end) + minDistanceHelper(houses, endOne + 1, end, k - 1);
            result = Math.min(result, dist);
        }
        mem[start][end][k] = result;
        return result;
    }

    private Integer getMinDistance(int[] houses, int start, int end) {
        int cost = 0;
        int median = houses[(start + end) / 2];
        for (int i = start; i <= end; i++) {
            cost = cost + Math.abs(houses[i] - median);
        }
        return cost;
    }

    public static void main(String[] args) {
        AllocateMailboxesWithHelper test = new AllocateMailboxesWithHelper();
        // Test case 1
        int[] houses1 = {1, 4, 8, 10, 20};
        int k1 = 3;
        System.out.println(STR."Test 1 - Houses: \{Arrays.toString(houses1)}, k=\{k1} -> \{test.minDistance(houses1, k1)}");
    }
}
