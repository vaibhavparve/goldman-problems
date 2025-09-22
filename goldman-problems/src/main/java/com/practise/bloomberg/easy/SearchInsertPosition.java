package com.practise.bloomberg.easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        //corner case if its greatest
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //if target not found left is insertion position
        return left;
    }

    static void main() {
        SearchInsertPosition test = new SearchInsertPosition();
        int[] test1 = {1, 3, 5, 6};
        System.out.println(test.searchInsert(test1, 2));
        System.out.println(test.searchInsert(test1, 5));
        System.out.println(test.searchInsert(test1, 7));

    }
}
