package com.practise.bloomberg.medium;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        //use priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    static void main() {
        KthLargestElementInArray test = new KthLargestElementInArray();
        int[] arr = {3,2,1,4,6,4};
        System.out.println(test.findKthLargest(arr, 2));
    }
}
