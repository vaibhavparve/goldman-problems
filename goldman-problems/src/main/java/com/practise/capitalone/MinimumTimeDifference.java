package com.practise.capitalone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    //dont forget to check for cicular difference from last to the first element in the list
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>(); //convert to minutes

        //convert all to min
        for (String point : timePoints) {
            String[] hhMM = point.split(":");
            int min = Integer.parseInt(hhMM[1]);
            int hh = Integer.parseInt(hhMM[0]);
            int toMin = (hh * 60) + min;
            minutes.add(toMin);
        }

        Collections.sort(minutes); // sort  by ascending order

        int minimumD = Integer.MAX_VALUE;

        for (int i = 1; i < minutes.size(); i++) {
            minimumD = Math.min(minimumD, minutes.get(i) - minutes.get(i - 1));
        }

        //check for circular diff
        int circularDiff = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0);

        return Math.min(minimumD, circularDiff);
    }
}
