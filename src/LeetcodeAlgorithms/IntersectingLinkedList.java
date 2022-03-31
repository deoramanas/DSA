package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class IntersectingLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode common = new ListNode(5);
        l1.next.next.next.next = common;


        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(7);
        l2.next.next = common;

        common.next = new ListNode(10);
        common.next.next = new ListNode(11);

        print(l1);
        print(l2);
        ListNode ans = getIntersectionNode(l1, l2);
        System.out.println("Intersecting at : " + ans.val);

    }

    private static void print(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
