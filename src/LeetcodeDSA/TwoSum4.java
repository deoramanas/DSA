package LeetcodeDSA;

import LeetcodeAlgorithms.TreeNode;

public class TwoSum4 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        boolean target = findTarget(treeNode, 5);
        System.out.println(target);
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }
}
