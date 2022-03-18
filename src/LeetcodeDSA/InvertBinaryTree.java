package LeetcodeDSA;

import LeetcodeAlgorithms.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printInorder(root);

        invertTree(root);
        System.out.println("\nAfter:   ");
        printInorder(root);

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    private static void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
