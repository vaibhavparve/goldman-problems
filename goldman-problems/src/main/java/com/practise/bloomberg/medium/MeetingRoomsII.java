package com.practise.bloomberg.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        //we have to sort the meetings as per start time to see the overlap
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // to track the end time of the meetings
        minHeap.offer(intervals[0][1]);// add the endtime of first meeting

        for (int i = 1; i <= intervals.length - 1; i++) {
            if (minHeap.peek() < intervals[i][1]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }

    static void main() {
        MeetingRoomsII test = new MeetingRoomsII();
        int[][] mm = {{0, 30}, {5, 10}, {15, 20}};
        int[][] mm1 = {{5, 8}, {6, 8}};
        System.out.println(test.minMeetingRooms(mm));
        System.out.println(test.minMeetingRooms(mm1));
    }
}
