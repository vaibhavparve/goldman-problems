package com.practise.goldman_problems.topic.intervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /*
     * can be solved using 2 ways either use Arrays.sort() or using priorityQueue sort the intervals in ascending order
     *
     * */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int m = intervals.length;
        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 1; i < m; i++) {
            int[] next = intervals[i];

            if (currentInterval[1] >= next[0]) {
                currentInterval[1] = Math.max(currentInterval[1], next[1]);
                merged.add(currentInterval);
            } else {

                currentInterval = next;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();

        int[][] test1 = {{1, 4}, {5, 6}};
        int[][] test2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(test.merge(test1)));
        System.out.println(Arrays.deepToString(test.merge(test2)));
    }

}
