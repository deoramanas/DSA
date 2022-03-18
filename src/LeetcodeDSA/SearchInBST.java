package LeetcodeDSA;

import LeetcodeAlgorithms.TreeNode;

public class SearchInBST {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        TreeNode treeNode1 = searchBST(treeNode, 2);
        print(treeNode1);
    }

    private static void print(TreeNode treeNode1) {
        if (treeNode1 == null) {
            return;
        }

        print(treeNode1.left);
        System.out.println(treeNode1.val);
        print(treeNode1.right);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        while (curr != null) {

            if (curr.val == val) {
                return curr;
            } else if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }
}
