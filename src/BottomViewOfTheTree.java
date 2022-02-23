import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BottomViewOfTheTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Tree tree=new Tree(root);

        //Print bottom view
        tree.bottomView();
    }
}

class Node {
    Node left, right;
    int hd;
    int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
        hd = Integer.MAX_VALUE;
    }
}

class Tree {
    Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public void bottomView() {

        if (root==null){
            return;
        }

        int hd=0;

        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Node> queue=new LinkedList<Node>();

        root.hd=hd;
        queue.add(root);

        while (!queue.isEmpty()){

            Node temp=queue.poll();
            hd=temp.hd;

            map.put(hd,temp.data);

            if(temp.left!=null){
                queue.add(temp.left);
                temp.left.hd=hd-1;
            }

            if(temp.right!=null){
                queue.add(temp.right);
                temp.right.hd=hd+1;
            }
        }


        map.values().stream().collect(Collectors.toList()).forEach(x->System.out.print(x+" "));

    }
}
