package LeetcodeAlgorithms;

public class MergeTwoBinaryTree {
    private static TreeNode root = new TreeNode();

    public static void main(String[] args) {

//        [1,2,null,3]
//[1,null,2,null,3]

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        /*
        1    1
       /       \
      2          2
     /            \
    3               3
         */

        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
//        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(3);
        TreeNode treeNode = mergeTrees(root1, root2);

        printTree(treeNode);

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = (root1.val + root2.val);
        root1.left = mergeTrees(root1.left != null ? root1.left : null, root2.left != null ? root2.left : null);
        root1.right = mergeTrees(root1.right != null ? root1.right : null, root2.right != null ? root2.right : null);
        return root1;
    }

    private static void printTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.val);
        printTree(treeNode.left);
        printTree(treeNode.right);
    }
}

