package com.fish.lab.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListSort {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return mergeSort(head, null);
    }
    private ListNode mergeSort(ListNode head, ListNode tail) {
        if(head == null) {
            return head;
        }
        if(head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode listLeft = mergeSort(head, slow);
        ListNode listRight = mergeSort(slow, tail);

        return merge(listLeft, listRight);
    }

    private ListNode merge(ListNode listLeft, ListNode listRight) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, headLeft = listLeft, headRight = listRight;
        while(headLeft != null && headRight != null) {
            if(headLeft.val <= headRight.val) {
                temp.next = headLeft;
                headLeft = headLeft.next;
            } else {
                temp.next = headRight;
                headRight = headRight.next;
            }
            temp = temp.next;
        }
        if(headLeft == null) {
            temp.next = headRight;
        } else {
            temp.next = headLeft;
        }
        return dummyHead.next;
    }
}