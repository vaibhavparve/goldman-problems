package com.practise.bloomberg.medium;

import java.util.Arrays;

public class TwoCitySchedulingCost {


    //here main idea is find which city is cheaper to send for a person
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2; // number of people we want to send to each city
        // consider the example of [10,20], [30,200], [400,50], [30,20]
//        Arrays.sort(costs, (a, b) -> {
//            int diffA = a[0] - a[1]; // whether is it cheaper to send to city A or B, if negative then its cheaper to send A
//            int diffB = b[0] - b[1];//
//            return Math.min(diffA, diffB);
//        });
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int minCost = 0;
        //simple after this send first n to city A as we have it sorted now
        for (int i = 0; i < n; i++) {
            minCost = minCost + costs[i][0];
        }

        for (int i = n; i < 2 * n; i++) {
            minCost = minCost + costs[i][1];
        }
        return minCost;
    }
}
