package LeetcodeAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
     //   root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Node ans = connect(root1);
        printTree(ans);

    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    continue;
                } else {
                    break;
                }
            }

            if (current.left != null) {
                current.left.next = current.right;
                queue.add(current.left);
            }

            if (current.right != null) {
            //    current.left.next = current.right;
                queue.add(current.right);
            }

            if (!queue.isEmpty()) {
                if (current.next == null) {
                    current.next = queue.peek();
                }
            }
        }

        return root;
    }

    private static void printTree(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}