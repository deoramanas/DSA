package LeetcodeAlgorithms;

import java.util.HashSet;

public class SubtreeOfAnotherTree {
    public static HashSet<TreeNode> set = new HashSet<>();

    public static void main(String[] args) {
//        TreeNode mainTree = new TreeNode(3);
//        mainTree.left = new TreeNode(4);
//        mainTree.right = new TreeNode(5);
//        mainTree.left.left = new TreeNode(1);
//        mainTree.left.right = new TreeNode(2);
//
//        TreeNode subTree = new TreeNode(4);
//        subTree.left = new TreeNode(1);
//        subTree.right = new TreeNode(2);

        TreeNode mainTree = new TreeNode(1);
        mainTree.left = new TreeNode(1);

        TreeNode subTree = new TreeNode(1);

        boolean ans = isSubtree1(mainTree, subTree);
        System.out.println(ans);
    }

    private static boolean isSubtree1(TreeNode mainTree, TreeNode subTree) {
        if ((mainTree == null && subTree != null) || (mainTree != null && subTree == null))
            return false;
        if (mainTree == null && subTree == null) {
            return false;
        }

        if (mainTree == null || subTree == null) {
            return false;
        }

        if (mainTree.val != subTree.val) {
            return isSubtree1(mainTree.left, subTree) || isSubtree1(mainTree.right, subTree);
        } else if (!isEqual(mainTree, subTree)) {
            return isSubtree1(mainTree.left, subTree) || isSubtree1(mainTree.right, subTree);
        } else {
            return true;
        }
    }

    private static boolean isEqual(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if ((first == null && second != null) || (first != null && second == null))
            return false;

        if (first != null && second != null && first.val == second.val) {
            boolean left = isEqual(first.left, second.left);
            boolean right = isEqual(first.right, second.right);
            return left && right;
        }
        return false;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        set.add(root);
        store(root);

        if (set.contains(subRoot)) {
            return true;
        }
        return false;
    }

    public static TreeNode store(TreeNode root) {

        if (root == null) {
            return null;
        } else {
            set.add(root);
        }
        TreeNode left = store(root.left);
        TreeNode right = store(root.right);
        return root;
    }

}
