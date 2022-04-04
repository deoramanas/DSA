package LeetcodeDSA;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreOrderAndInOrder {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        inorder1(treeNode);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        TreeNode node =
                createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);

        return node;
    }

    private static TreeNode createTree(int[] preorder, int preStart, int preEnd, int[] inorder,
            int inorderStart, int inorderEnd, Map<Integer, Integer> inOrderMap) {

        if (preStart > preEnd || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inOrderMap.get(root.val);
        int fh = inRoot - inorderStart;
        root.left = createTree(preorder, preStart + 1, preStart + fh, inorder, inorderStart, inRoot - 1,
                inOrderMap);
        root.right =
                createTree(preorder, preStart + fh + 1, preEnd, inorder, inRoot + 1, inorderEnd, inOrderMap);

        return root;
    }

    private static void inorder1(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder1(root.left);
        System.out.print(root.val + " ");
        inorder1(root.right);
    }

}


