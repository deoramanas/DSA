package LeetcodeAlgorithms;

import Leetcode.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        // node.next.next.next.next.next = new ListNode(6);
        int k = 2;
        ListNode listNode = reverseKGroup(node, k);

        printList(listNode);
    }



    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode listNode = head;
        int len = length(listNode); //length of linkedlist
        int remains = len % k; //since the question mentioned, only multiple of k will be reversed
        int iterations = len - remains; // we have to iterate these many nodes

        ListNode curr = head;
        ListNode prev = new ListNode(-1); //make dummy node
        ListNode p = prev; //to point to the start of list
        ListNode next = null;
        ListNode unchanged = head; //placeholder to merge the 'un-reversed elements' at the end of list

        //unchanged points to the set, that will not be reversed since it's not multiple of k
        //1 2 3 4 5 --> it points to 5
        for (int i = 0; i < iterations; i++) {
            unchanged = unchanged.next;
        }

        while (iterations > 0) {
            int t = k;
            //reversing in group
            while (t > 0 && curr != null) {
                next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = next;
                t--;
            }
            while (prev.next != null) {
                prev = prev.next;
            } //to increase prev
            iterations = iterations - k;
        }



        prev.next = unchanged; //add the untraversed and unreversed list at the end
        return p.next; //return the beginning of prev
    }

    //compute the length of linkedlist
    private static int length(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            len++;
            listNode = listNode.next;
        }

        return len;
    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
