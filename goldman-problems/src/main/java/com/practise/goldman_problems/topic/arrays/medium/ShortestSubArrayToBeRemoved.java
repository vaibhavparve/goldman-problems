package com.practise.goldman_problems.topic.arrays.medium;

public class ShortestSubArrayToBeRemoved {

    public int findLengthOfShortestSubarray(int[] arr) {
        //lets handle the conrner case here
        if (arr.length == 1) {
            return 0;
        }
        int n = arr.length;
        //find the left max
        int left = 0;
        while (left <= n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        //it means all the elements are sorted
        if (left == n - 1) {
            return 0;
        }

        int right = n - 1;

        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        //remove everything from left +1
        int result = n - left - 1;

        //remove everything from start to right -1
        result = Math.min(result, right);

        int j = right;
        int i = 0;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;

    }

    static void main() {
        ShortestSubArrayToBeRemoved test = new ShortestSubArrayToBeRemoved();

        int[] testAr = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(test.findLengthOfShortestSubarray(testAr));
    }
}
