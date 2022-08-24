package com.fish.lab.leetcode;


public class Intersection {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //思路：如果我们终将会相遇，我选择走你走过的路，那么我们便会相遇(浪漫解法)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //p1:可以理解为男主
        ListNode p1 = headA;

        //p2可以理解为女主
        ListNode p2 = headB;

        //如果p1和p2不相等，一直循环
        //如果男主和女主没有相遇，便一直寻找
        while (p1!=p2){
            //如果p1为空，那么便去另一条路，否则向后移动
            //如果男主将自己的路走完了，便奔赴女主走过的路，否则将走完自己的路。
            p1 = p1==null ? headB : p1.next;

            //如果p2为空，那么便去另一条路，否则向后移动
            //如果女主将自己的路走完了，便奔赴男主走过的路，否则将先走完自己的路。
            p2 = p2==null ? headA : p2.next;
        }
        return p1;
    }
}