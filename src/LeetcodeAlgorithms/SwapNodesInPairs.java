package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode swappedHead = swapPairs(listNode);
        print(swappedHead);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        dummy.next = current;
        ListNode prev = dummy;
        while (prev != null) {
            ListNode first = prev.next;
            ListNode second = null;

            if (first != null) {
                second = first.next;
            }
            if (second != null) {
                ListNode third = second.next;
                second.next = first;
                first.next = third;
                prev.next = second;
                prev = first;
            } else {
                break;
            }
        }

        return dummy.next;
    }


    private static void print(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        System.out.println();
    }
}
