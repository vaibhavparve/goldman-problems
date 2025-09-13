package com.practise.goldman_problems.topic.priorityQ.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {

    PriorityQueue<Integer> maxHeap; // it will awalys contain the min numbers
    PriorityQueue<Integer> minHeap; // list of min numbers

    MedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    void addNum(int num) {
        //always add to the maxHeap
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) { //awlays maintain max heap equal or more elements
            maxHeap.offer(minHeap.poll());
        }
    }


    /*
            1, 2, 3, 4, 5
    *  x 3, 2, 1
     * m 4, 5
     */
    double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
