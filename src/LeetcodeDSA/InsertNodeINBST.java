package LeetcodeDSA;

import LeetcodeAlgorithms.TreeNode;

public class InsertNodeINBST {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        TreeNode treeNode1 = insertIntoBST(treeNode, 5);
        print(treeNode1);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while (current != null) {

            if (current.val < val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
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
