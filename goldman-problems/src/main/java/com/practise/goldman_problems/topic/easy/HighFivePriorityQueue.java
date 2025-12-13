package com.practise.goldman_problems.topic.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HighFivePriorityQueue {


    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> studentScores = new HashMap<>();

        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];

            studentScores.computeIfAbsent(studentId, k -> new PriorityQueue<>()).add(score);
            PriorityQueue<Integer> minHeap = studentScores.get(studentId);

            if (minHeap.size() > 5) {
                minHeap.poll();
            }
        }

        int[][] result = new int[studentScores.size()][2]; //number of entries + student id,average itsa 2d array
        int index = 0;
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = studentScores.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entries) {
            Integer studentId = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            int sum = 0;

            while (!scores.isEmpty()) {
                sum = sum + scores.poll();
            }

            int average = sum / 5;
            result[index][0] = studentId;
            result[index][1] = average;
        }
        return result;
    }
}
