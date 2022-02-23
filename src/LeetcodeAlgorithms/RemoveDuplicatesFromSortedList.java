package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        ListNode head = deleteDuplicates(node);
        printList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        //dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        ListNode newlist = dummy;
        while (current != null && current.next != null) {
            int currentValue = current.val;
            if (currentValue != prev.val && currentValue != current.next.val) {
                newlist.next = current;
                newlist = newlist.next;
            }
            prev = current;
            current = current.next;
        }

        if (current.val != prev.val) {
            newlist.next = new ListNode(current.val);
            newlist = newlist.next;
        }

        newlist.next = null;

        return dummy.next;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0 == head.val ? 1 : 0); // to guarantee the dummy node is not same as the original head.

        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        ListNode first = dummy;  // the first node in the new unduplicated(result) list.

        while (cur != null && cur.next != null) {
            if (cur.val != pre.val && cur.val != cur.next.val) { // we found a unique node, we connect it at the tail of the unduplicated list, and update the first node.
                first.next = cur;
                first = first.next;
            }
            pre = cur;
            cur = cur.next;
        }

        if (pre.val != cur.val) { // the last node needs to be dealt with independently
            first.next = cur;
            first = first.next;
        }

        first.next = null; // the subsequent list is duplicate.

        return dummy.next;
    }
}