public class FlattenABinaryTree extends CreateBinaryTree {
    static BinaryTreeNode prev;
    static BinaryTreeNode head;

    public static void main(String[] args) {

        BinaryTreeNode root = populateTree2();

        flattenLogic(root);
        BinaryTreeNode start = head;
        while (start != null) {
            System.out.println(start.data);
            start = start.right;
        }
    }

    private static void flattenLogic(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        flattenLogic(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        flattenLogic(root.right);
    }

    public static BinaryTreeNode populateTree2() {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(1);
        root.right.left.left = new BinaryTreeNode(4);
        root.right.left.right = new BinaryTreeNode(6);
        return root;
    }
}
