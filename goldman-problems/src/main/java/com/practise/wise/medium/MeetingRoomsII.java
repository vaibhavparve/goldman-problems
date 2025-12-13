package com.practise.wise.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    //we can reuse the meeting rooms that are empty or already used so we need to sort
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // to track the end time

        for (int[] interval : intervals) {
            if(!minHeap.isEmpty() && minHeap.peek() <= interval[0]){
                minHeap.poll();
            }
            minHeap.offer(interval[1]); // add end time to the queue
        }

        return minHeap.size();
    }

}
