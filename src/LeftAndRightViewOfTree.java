import java.util.ArrayList;

public class LeftAndRightViewOfTree {
    public static void main(String[] args) {
        BinaryTreeNode root = populateTree1();

        System.out.println("Left View Of Tree");

        ArrayList<Integer> leftViewList = leftViewOfTree(root, 0, new ArrayList<>());

        leftViewList.forEach(System.out::println);

        System.out.println("Right View Of Tree");

        ArrayList<Integer> rightViewList = rightViewOfTree(root, 0, new ArrayList<>());

        rightViewList.forEach(System.out::println);
    }

    private static ArrayList<Integer> leftViewOfTree(BinaryTreeNode root, int level, ArrayList<Integer> arrayList) {
        if (root == null) {
            return null;
        }

        if (level == arrayList.size()) {
            arrayList.add(root.data);
        }

        leftViewOfTree(root.left, level + 1, arrayList);
        leftViewOfTree(root.right, level + 1, arrayList);
        return arrayList;
    }

    private static ArrayList<Integer> rightViewOfTree(BinaryTreeNode root, int level, ArrayList<Integer> arrayList) {
        if (root == null) {
            return null;
        }

        if (level == arrayList.size()) {
            arrayList.add(root.data);
        } else {
            arrayList.set(level, root.data);
        }

        rightViewOfTree(root.left, level + 1, arrayList);
        rightViewOfTree(root.right, level + 1, arrayList);
        return arrayList;
    }

    private static BinaryTreeNode populateTree1() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(8);
        root.right.right = new BinaryTreeNode(15);
        root.right.left = new BinaryTreeNode(12);
        root.right.right.left = new BinaryTreeNode(14);
        return root;
    }

    /*
    10

    2 3
  7 8  12 15
      14
     */
}
