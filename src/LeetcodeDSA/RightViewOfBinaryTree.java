package LeetcodeDSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> list = rightSideView(root);
        System.out.println(list);

    }

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> curr = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    System.out.println();
                    list.add(curr.get(curr.size() - 1));
                    curr.clear();
                    queue.add(null);
                    continue;
                } else {
                    list.add(curr.get(curr.size() - 1));
                    return list;
                }
            }
           // System.out.print(current.val + " ");
            curr.add(current.val);


            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return list;
    }
}
