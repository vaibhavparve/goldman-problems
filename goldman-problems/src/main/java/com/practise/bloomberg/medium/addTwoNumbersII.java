package com.practise.bloomberg.medium;

import java.util.Stack;

public class addTwoNumbersII {
    /*
     * Here best approach is to use stack
     * */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack<>();
        Stack<Integer> list2 = new Stack<>();

        //add all elements to the stack from list1
        while (l1 != null) {
            list1.push(l1.val);
            l1 = l1.next;
        }

        //add all elements to the stack from list2
        while (l2 != null) {
            list2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (!list1.isEmpty() || !list2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!list1.isEmpty()) {
                sum = sum + list1.pop();
            }

            if (!list2.isEmpty()) {
                sum = sum + list2.pop();
            }

            carry = sum / 10; //

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}
