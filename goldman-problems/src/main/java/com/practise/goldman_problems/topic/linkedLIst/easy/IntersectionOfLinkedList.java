package com.practise.goldman_problems.topic.linkedLIst.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if any list is null there wont be any intersection
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> visited = new HashSet<>();

        //add all the nodes from list a to the visisted nodes
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return  null;
    }

}
