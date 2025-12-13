package com.practise.wise.medium;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargestElement {

    int getKthLargestElementInArray(int[] nums, int k){
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(k-1)
                .findFirst()
                .orElse(-1);
    }

    static void main() {
        int[] nums = {3, 1, 4, 2};

        KthLargestElement test = new KthLargestElement();

        System.out.println(test.getKthLargestElementInArray(nums, 2));

    }
}
