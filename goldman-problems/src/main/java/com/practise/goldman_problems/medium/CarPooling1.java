package com.practise.goldman_problems.medium;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling1 {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timeline = new TreeMap<>();

        for(int[] trip: trips){
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            timeline.put(from , timeline.getOrDefault(from, 0) + passengers);
            timeline.put(to, timeline.getOrDefault(to, 0) - passengers);
        }

    }
}
