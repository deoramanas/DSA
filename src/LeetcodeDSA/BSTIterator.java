package LeetcodeDSA;

import java.util.Stack;
import LeetcodeAlgorithms.TreeNode;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {

        while (node != null) {
            stack.push(node);
            if (reverse == true) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (reverse == false) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }
        return temp.val;
    }


}
