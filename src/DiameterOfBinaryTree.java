public class DiameterOfBinaryTree extends CreateBinaryTree {
    public static void main(String[] args) {

        BinaryTreeNode root = populateTree1();

        diameterOfBinaryTreeUnoptimized(root);
        System.out.println("height : " + heightOfTree(root));
        System.out.println("Diameter : " + diameterOfBinaryTreeUnoptimized(root));
    }

    private static int diameterOfBinaryTreeUnoptimized(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int dl = diameterOfBinaryTreeUnoptimized(root.left);
        int dr = diameterOfBinaryTreeUnoptimized(root.right);

        int currentDiameter = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(currentDiameter, Math.max(dl, dr));

    }

    private static int heightOfTree(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
}
