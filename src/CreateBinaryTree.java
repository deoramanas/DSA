import java.util.Scanner;

public class CreateBinaryTree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        // BinaryTreeNode root = createTree();

        BinaryTreeNode root = populateTree1();

        inOrder(root);
        System.out.println();

        preOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();

        int height = heightOfTree(root);
        System.out.println("Height of tree is : " + height);

        int size = sizeOfTree(root);
        System.out.println("Size of tree is : " + size);

        int maximumElement = maximumInTree(root);
        System.out.println("<Maximum Element> of tree is : " + maximumElement);

    }

    private static int maximumInTree(BinaryTreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.data, Math.max(maximumInTree(root.left), maximumInTree(root.right)));
        }
    }

    private static int sizeOfTree(BinaryTreeNode root) {
        if (root == null) {

            return 0;
        } else
            return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
    }

    private static int heightOfTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public static BinaryTreeNode populateTree1() {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(1);
        root.left.left = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(8);
        root.right.left.left = new BinaryTreeNode(22);
        root.right.right = new BinaryTreeNode(3);
        return root;
    }

    private static void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }

    private static void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    static BinaryTreeNode createTree() {
        BinaryTreeNode node = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        node = new BinaryTreeNode(data);

        System.out.println("Enter data for left: " + data);
        node.left = createTree();
        System.out.println("Enter data for right: " + data);
        node.right = createTree();
        return node;
    }

}


