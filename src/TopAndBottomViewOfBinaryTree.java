import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopAndBottomViewOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = populateTree1();

        System.out.println("Top View is: ");
        TreeMap<Integer, Integer> treeMap = printTopView(root, new TreeMap<Integer, Integer>(), 0);

        treeMap.values().stream().collect(Collectors.toList()).forEach(element -> System.out.println(element + " "));
        System.out.println("Bottom View is: ");
        TreeMap<Integer, Integer> treeMap1 = printBottomView(root, new TreeMap<Integer, Integer>(), 0);

        treeMap1.values().stream().collect(Collectors.toList()).forEach(element -> System.out.println(element + " "));
    }

    private static TreeMap<Integer, Integer> printTopView(BinaryTreeNode root, TreeMap<Integer, Integer> map, int step) {

        if (root == null) {
            return null;
        }
        map.putIfAbsent(step, root.data);
        printTopView(root.left, map, step - 1);
        printTopView(root.right, map, step + 1);
        return map;
    }

    private static TreeMap<Integer, Integer> printBottomView(BinaryTreeNode root, TreeMap<Integer, Integer> map, int step) {

        if (root == null) {
            return null;
        }
        map.put(step, root.data);
        printBottomView(root.left, map, step - 1);
        printBottomView(root.right, map, step + 1);
        return map;
    }

    private static BinaryTreeNode populateTree1() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        return root;
    }
}

