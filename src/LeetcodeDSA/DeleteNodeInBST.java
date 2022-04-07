package LeetcodeDSA;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(7);

        int key = 3;
        TreeNode node = deleteNode(treeNode, key);
        print(node);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = minNode(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private static int minNode(TreeNode right) {
        int minimum = right.val;
        while (right.left != null) {
            minimum = right.left.val;
            right = right.left;
        }
        return minimum;
    }

    private static void print(TreeNode treeNode1) {
        if (treeNode1 == null) {
            return;
        }

        print(treeNode1.left);
        System.out.print(treeNode1.val + " ");
        print(treeNode1.right);
    }
}
