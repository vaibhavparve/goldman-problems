package com.practise.goldman_problems.easy;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class HighFivePriorityQueue {

    /*not storing the values more than 5 */

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> studentScores = new TreeMap<>();

        //adding to map
        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];
            studentScores.computeIfAbsent(studentId, k -> new PriorityQueue<>());
            PriorityQueue<Integer> minHeap = studentScores.get(studentId);

            minHeap.offer(score);
            if (minHeap.size() > 5) {
                minHeap.poll();
            }
        }

        //save result
        int[][] result = new int[studentScores.size()][2];
        int index = 0;
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = studentScores.entrySet();

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entries) {
            Integer studentId = entry.getKey();
            PriorityQueue<Integer> topScores = entry.getValue();
            int sum = 0;

            while (!topScores.isEmpty()) {
                sum = sum + topScores.poll();
            }

            int average = sum / 5;

            result[index][0] = studentId;
            result[index][1] = average;
            index++;
        }
        return result;
    }
}
