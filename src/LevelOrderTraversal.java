import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class LevelOrderTraversal {
    static Scanner sc = null;

    public static void main(String[] args) {

        BinaryTreeNode root = populateTree1();

        System.out.println("Level Order Traversal");
//        for (int i = 0; i <= heightOfTree(root); i++) {
//            levelOrderTraversalAtLevel(root, i);
//        }

        //     levelOrderTraversalUsingQueue(root);
        MultiValuedMap<Integer, Integer> map = new ArrayListValuedHashMap<Integer, Integer>();

        map = levelOrderTraversalUsingMap(root, 1, map);

        map.entries().stream().forEach(integerIntegerEntry -> System.out
                .println(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue()));
    }

    private static MultiValuedMap<Integer, Integer> levelOrderTraversalUsingMap(BinaryTreeNode root,
            int level, MultiValuedMap<Integer, Integer> map) {

        if (root == null) {
            return null;
        }

        map.put(level, root.data);

        levelOrderTraversalUsingMap(root.left, level + 1, map);
        levelOrderTraversalUsingMap(root.right, level + 1, map);

        return map;
    }

    private static List<List<Integer>> levelOrderTraversalUsingQueueZigzag(BinaryTreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        queue.add(null);
        boolean flag = true;
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.add(null);
                    flag = !flag;
                    if (flag) {
                        Collections.reverse(curr);
                    }
                    list.add(new ArrayList<>(curr));
                    curr.clear();
                    continue;
                } else {
                    flag = !flag;
                    if (flag) {
                        Collections.reverse(curr);
                    }
                    list.add(new ArrayList<>(curr));
                    return list;
                }
            }
            // System.out.print(current.data + " ");
            curr.add(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return list;
    }

    private static void levelOrderTraversalUsingQueue(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.add(null);
                    continue;
                } else {
                    return;
                }
            }
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private static void levelOrderTraversalAtLevel(BinaryTreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        }

        levelOrderTraversalAtLevel(root.left, level - 1);
        levelOrderTraversalAtLevel(root.right, level - 1);
    }

    private static int heightOfTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
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
