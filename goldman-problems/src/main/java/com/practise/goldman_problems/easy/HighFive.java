package com.practise.goldman_problems.easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
*
* Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi,
* calculate each student's top five average.
Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average.
* Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
* */
public class HighFive {

    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> studentScores = new TreeMap<>();
        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];

            studentScores.computeIfAbsent(studentId, k -> new ArrayList<>()).add(score);
        }

        int[][] result = new int[studentScores.size()][2];
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : studentScores.entrySet()) {
            int studentId = entry.getKey();
            List<Integer> scores = entry.getValue();

            scores.sort(Collections.reverseOrder()); //reverse of natural ordering i.e.e, descending

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += scores.get(i);
            }

            int average = sum / 5;

            result[index][0] = studentId;
            result[index][1] = average;
            index++;
        }
        return result;
    }
}
