package Leetcode;

import LeetcodeAlgorithms.TreeNode;

public class MinDepth {
    public static void main(String[] args) {

//        TreeNode treeNode = new TreeNode(3);
//        treeNode.left = new TreeNode(4);
//        treeNode.right = new TreeNode(20);
//        treeNode.right.left = new TreeNode(15);
//        treeNode.right.right = new TreeNode(7);

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        treeNode.right.right.right.right = new TreeNode(5);

        int minDepth = minDepth(treeNode);
        System.out.println(minDepth);

        int max = maxDepth(treeNode);
        System.out.println(max);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        if (root.left == null) {
//            return minDepth(root.right) + 1;
//        }
//        if (root.right == null) {
//            return minDepth(root.right) + 1;
//        }
//        return 1 + Math.min(minDepth(root.left), minDepth(root.right));

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return 1 + Math.max(left, right);
        }

        return 1 + Math.max(left, right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
