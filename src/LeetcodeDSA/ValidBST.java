package LeetcodeDSA;

import LeetcodeAlgorithms.TreeNode;

public class ValidBST {
    public static void main(String[] args) {
        // TreeNode treeNode = new TreeNode(4);
        // treeNode.left = new TreeNode(2);
        // treeNode.right = new TreeNode(7);
        // treeNode.left.left = new TreeNode(1);
        // treeNode.left.right = new TreeNode(3);

        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        boolean validBST = isValidBST(treeNode);
        System.out.println(validBST);
        // print(treeNode);
    }

    public static boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (minValue >= root.val || maxValue <= root.val) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);

    }

    private static void print(TreeNode treeNode1) {
        if (treeNode1 == null) {
            return;
        }

        print(treeNode1.left);
        System.out.println(treeNode1.val);
        print(treeNode1.right);
    }
}
